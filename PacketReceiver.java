import java.net.*;

public class PacketReceiver {
    public static void main(String[] args) {
        try {
            // Use a specific port (change if needed)
            int port = 4444;
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Listening for packets on port " + port + "...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                InetAddress senderAddress = packet.getAddress();
                int senderPort = packet.getPort();

                System.out.println("Received Packet from " + senderAddress + ":" + senderPort);
                System.out.println("Data: " + received);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
