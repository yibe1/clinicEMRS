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
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private String responseMessage;
    public String grabIp(){
        try {
            String message = "please provide me your ip address so that i play with you with 148197";
            int port = 51241;
            
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            
            byte[] buffer = message.getBytes();
            InetAddress address = InetAddress.getByName("255.255.255.255");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            
            socket.send(packet);
            
            byte[] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);
            
            responseMessage = new String(responsePacket.getData(), 0, responsePacket.getLength());
            
            
            socket.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex1..."+ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex2..."+ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex3..."+ex);
        }
        return responseMessage;
        
    }
}
