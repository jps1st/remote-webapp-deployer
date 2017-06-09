/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deployer;

/**
 *
 * @author jes123
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(args.length ==0){
            System.out.println("Invalid arguments. Use either 'server' or 'client' ");
            return;
        }
        
        if(args[0].equalsIgnoreCase("server")){
            TCPServer.main(args);
        }else{
            TCPClient.main(args);
        }
        
    }
    
}
