import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.regex.Pattern;

public class PacketAnalyzer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9999);
            byte[] buffer = new byte[1024];

            System.out.println("Listening for packets...");
            
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received Packet: " + received);
                
                // Check for suspicious patterns
                if (isMalicious(received)) {
                    System.out.println("⚠️ Potential Threat Detected! ⚠️");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isMalicious(String packetData) {
        // Example: Detecting suspicious IPs or patterns
        return packetData.contains("192.168.1.1") || Pattern.compile(".*malicious.*").matcher(packetData).find();
    }
}
