Network Packet Sniffer

# Project Overview
The Network Packet Sniffer is a tool designed to capture, analyze, and monitor network traffic in real-time. The primary objective of this project is to capture UDP packets using Python, transmit them to a Java server, and perform analysis to detect suspicious or malicious patterns in the traffic.

The project consists of three components:
1. Packet Sniffer (Python): Captures network packets using Scapy and sends them to a Java server.
2. Packet Receiver (Java): Receives the captured packets and displays their content.
3. Packet Analyzer (Java): Analyzes the packet data for potential threats or malicious content.

# Objectives
The main objectives of this project are:
1. Packet Capturing: Capture live network packets from the network using Python's Scapy library.
2. Packet Transmission: Transmit the captured packets to a Java server via UDP.
3. Packet Reception: Receive the UDP packets on a specific port using a Java application.
4. Packet Analysis: Analyze the received packet data to detect suspicious content based on predefined patterns.
5. Network Security Monitoring: Provide insights about potential malicious activities based on the packet content.

# Methodology
The project uses a combination of Python and Java to achieve packet capturing, transmission, and analysis. Below is a detailed step-by-step methodology for each component.

# 1. Packet Sniffer (Python)
File: PacketSniffer.py  
Role: Captures live network packets and sends them to the Java server.

- The script uses the Scapy library to capture packets.
- For each packet captured, the packet's summary is converted to a string and sent via a UDP socket to the Java server.
- The server listens on a specified port (`9999`) to receive incoming packets.

# Key Code Snippet:
def packet_callback(packet):
    data = f"{packet.summary()}"
    sock.sendto(data.encode(), server_address)

# Functionality:
- Captures packets using the `sniff()` method from Scapy.
- Sends the packet data to the Java server using a UDP socket.

# 2. Packet Receiver (Java)
File: PacketReceiver.java  
Role: Receives packets sent from the Python script and displays them.

- The Java program uses a DatagramSocket to listen for incoming UDP packets.
- When a packet is received, the sender's address, port, and packet data are displayed.
- This component acts as a listener to capture any incoming packet from the Python script.

Key Code Snippet:
DatagramSocket socket = new DatagramSocket(port);
socket.receive(packet);
String received = new String(packet.getData(), 0, packet.getLength());

Functionality:
- Continuously listens for incoming UDP packets.
- Prints the sender's IP address, port, and data received from the packet.

# 3. Packet Analyzer (Java)
File: PacketAnalyzer.java  
Role: Analyzes the incoming packet data for suspicious patterns.

- This Java component uses regular expressions and string matching to identify potentially malicious traffic.
- The program scans for specific IP addresses, suspicious content, or predefined keywords that might indicate a security threat.
- If a suspicious pattern is detected, the application logs a potential threat warning.

Detection Logic:

if (isMalicious(received)) {
    System.out.println("⚠️ Potential Threat Detected! ⚠️");
}


**Threat Detection Example:**
- Detect IP 192.168.1.1 as a suspicious IP.
- Detect any packet containing the keyword malicious

# Flow of Data
The project workflow can be summarized as follows:

1. **Packet Capture:** The Python script captures network packets using Scapy.
2. **Packet Transmission:** The captured packet data is sent to the Java server using UDP.
3. **Packet Reception:** The Java server listens for incoming packets and logs them.
4. **Packet Analysis:** The Packet Analyzer evaluates the packet content for suspicious patterns.
5. **Threat Alert:** If malicious content is detected, it will alert with a warning.

---

# Results
The expected outcomes of the project are as follows:
1. Successful Packet Capture: The Python script captures live network traffic and forwards it to the Java server.
2. Packet Reception: The Java server successfully receives and displays packet data.
3. Packet Analysis: The Packet Analyzer detects any suspicious activity based on predefined rules.
4. Threat Detection: When malicious content is identified, a warning alert is displayed.

Example Output:
Received Packet from 192.168.1.5:45578
Data: HTTP GET /login.php

⚠️ Potential Threat Detected! ⚠️

# Technologies Used
- Python: Used for packet capturing with the Scapy library.
- Java: Used for receiving and analyzing the captured packets.
- Socket Programming: UDP sockets are used to transmit packet data from Python to Java.
- Regular Expressions (Java): Used to detect malicious patterns in packet data.

# Future Enhancements
1. Deep Packet Inspection (DPI): Enhance the Packet Analyzer to inspect packet payload in detail.
2. Real-time Dashboard: Build a web interface to visualize network traffic in real-time.
3. Signature-based Threat Detection: Integrate known malicious IP addresses or payload signatures to enhance threat detection.
4. Packet Logging: Implement logging of packet data for further analysis and forensics.
   
# How to Run the Project
# Step 1: Run the Packet Sniffer (Python)
Open a terminal and execute:
python3 PacketSniffer.py

# Step 2: Run the Packet Receiver (Java)
Open another terminal in the project directory and execute:
javac PacketReceiver.java
java PacketReceiver

# Step 3: Run the Packet Analyzer (Java)
Open a third terminal and execute:
javac PacketAnalyzer.java
java PacketAnalyzer

# Step 4: Observe the Output
- The Packet Receiver will display incoming packets.
- The Packet Analyzer will analyze the packets for any suspicious content.
- If a potential threat is detected, it will alert with a warning.

# Conclusion
This project demonstrates the power of network packet sniffing and real-time analysis. By leveraging Python's Scapy and Java's socket programming, the tool effectively captures, transmits, and analyzes network traffic. Additionally, the packet analyzer serves as a basic Intrusion Detection System (IDS) capable of detecting suspicious network activity.

The project lays the foundation for more advanced cybersecurity tools, such as deep packet inspection, traffic analysis, and real-time network monitoring. With further enhancements, this tool could be extended into a full-fledged network security monitor.

