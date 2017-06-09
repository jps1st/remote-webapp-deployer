/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smilesdeployer;

// TCPClient.java
// A client program implementing TCP socket
import java.net.*;
import java.io.*;


public class TCPClient {

    public static void main(String args[]) {// arguments supply message and hostname of destination  
        if(args.length < 3){
            System.out.println("Invalid arguments.");
            return;
        }
        
        try {
            Socket socket = null;
            String host = args[1];
            
            socket = new Socket(host, 6880);
            
            File file = new File(args[2]);
            // Get the size of the file
            long length = file.length();
            byte[] bytes = new byte[16 * 1024];
            InputStream in = new FileInputStream(file);
            OutputStream out = socket.getOutputStream();
            
            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
            
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
