import socket
from scapy.all import sniff

# Create a UDP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server_address = ('localhost', 9999)  # Java server address

def packet_callback(packet):
    data = f"{packet.summary()}"
    sock.sendto(data.encode(), server_address)

# Capture network packets
sniff(prn=packet_callback, store=False)
