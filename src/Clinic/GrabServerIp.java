/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

/**
 *
 * @author Jimma University
 */
import java.net.*;

public class GrabServerIp {
    public static void main(String[] args) throws Exception {
        String message = "please provide me your ip address so that i play with you with 148197";
        int port = 12345;

        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);

        byte[] buffer = message.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

        socket.send(packet);

        byte[] responseData = new byte[1024];
        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
        socket.receive(responsePacket);

        String responseMessage = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("Received response: " + responseMessage);

        socket.close();
    }
}
