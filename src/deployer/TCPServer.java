/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deployer;

// TCPServer.java
// A server program implementing TCP socket
import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main(String args[]) {
        try {

            if (args.length < 2) {
                System.out.println("Invalid arguments.");
            }

            ServerSocket serverSocket = null;

            try {
                serverSocket = new ServerSocket(6880);
            } catch (IOException ex) {
                System.out.println("Can't setup server on this port number. ");
            }

            Socket socket = null;
            InputStream in = null;
            OutputStream out = null;

            try {
                socket = serverSocket.accept();
            } catch (IOException ex) {
                System.out.println("Can't accept client connection. ");
            }
            
            String appName = args[1];
            
            File appFolder = new File(appName);
            if (appFolder.exists()) {
                appFolder.delete();
            }

            String warFileName = appName + ".war";
            File warFile = new File(warFileName);
            if (warFile.exists()) {
                warFile.delete();
            }
            
            try {
                in = socket.getInputStream();
            } catch (IOException ex) {
                System.out.println("Can't get socket input stream. ");
            }

            try {
                out = new FileOutputStream(warFileName);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found. ");
            }

            byte[] bytes = new byte[16 * 1024];

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }

            out.close();
            in.close();
            socket.close();
            serverSocket.close();
            
            System.out.println("Done.");

        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
    }
}