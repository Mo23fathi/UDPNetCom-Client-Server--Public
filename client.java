/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Client {
    private DatagramSocket datagramSocket;
    private InetAddress inetAddress;
    private byte[] buffer= new byte [64000];

    public Client(DatagramSocket datagramSocket, InetAddress inetAddress) {
        this.datagramSocket = datagramSocket;
        this.inetAddress = inetAddress;
    }
    public void udpclient() throws IOException{
       Scanner sc = new Scanner(System.in);        
        while(true)
        try {
            System.out.print("client  :" );
            String massageToSend = sc.nextLine();
              buffer =massageToSend.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,inetAddress,1234);
            datagramSocket.send(datagramPacket);
            if(massageToSend.equals("ca")){
           
  
        // Step 1
        // Create the socket object for carrying data
        //DatagramSocket ds = new DatagramSocket();
  
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = new byte[65000];
   Scanner scc = new Scanner(System.in); 
        // loop while user not enters "bye"
        while (true) {
 // Scanner scc = new Scanner(System.in); 
            System.out.print(
                "Enter the equation in the format:");
            System.out.println(
                "'operand1 operator operand2'");
  
            // Awaiting from entered input
            String inp = scc.nextLine();
            
           // buf = new byte[65535];
  
            // Converting the String input into the byte
            // array
            buf = inp.getBytes();
  
            // Step 2
            // Creating the datagramPacket for sending the
            // data.
            DatagramPacket DpSend = new DatagramPacket(
                buf, buf.length, ip, 1234);
  
            // Invoking the send call to actually send the
            // data.
            datagramSocket.send(DpSend);
  
            // Break the loop if user enters "bye"
            // using the break keyword
            if (inp.equals("bye"))
                break;
  
           // buf = new byte[65535];
  
            // Creating an object of DatagramPacket class
            DatagramPacket DpReceive
                = new DatagramPacket(buf, buf.length);
  
            datagramSocket.receive(DpReceive);
  String answer = new String(DpReceive.getData(),0,DpReceive.getLength());
            // Print and display command
            System.out.println("answer"+answer);
//            System.out.println(
//                "Answer = "   + new String(buf, 0, buf.length));
        }
    }
            
     
            datagramSocket.receive(datagramPacket);
            String massageFromServer = new String(datagramPacket.getData(),0,datagramPacket.getLength());
            System.out.println("The server says  " + massageFromServer);
        }catch (IOException e){
            e.printStackTrace();
            break;
        }
    }
    public static void main(String [] args) throws UnknownHostException, SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Client client = new Client(datagramSocket,inetAddress);
        System.out.println("send datagram packet to a server");
        client.udpclient();
    }
}
