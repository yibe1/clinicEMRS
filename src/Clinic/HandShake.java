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
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandShake {
    public static void main(String[] args) throws IOException {
        
    }

    boolean shake(String ip) throws SocketException {
        int port = 51241;
        boolean status = false;
        Socket socket = null;
      
        try {
            socket = new Socket(ip, port);
            socket.setSoTimeout(10); 
            
          System.out.println("Connected to server at " + ip + ":" + port);  
          status = true;
        } catch (IOException ex) {
            Logger.getLogger(HandShake.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HandShake.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
