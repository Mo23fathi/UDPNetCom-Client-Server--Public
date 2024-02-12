/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp;
import javax.imageio.IIOException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Server {
    private DatagramSocket datagramSocket;
    private byte[] buffer = new byte[64000];

    public Server(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    public void udpserver() throws IOException{
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
           try{
               DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
               datagramSocket.receive(datagramPacket);
               InetAddress inetAdress = datagramPacket.getAddress();
               int port =datagramPacket.getPort();
               String massageFromClinet = new String(datagramPacket.getData(),0,datagramPacket.getLength());
               System.out.println("Massage from the client : " + massageFromClinet);
               if (massageFromClinet.equals("ca")){
                   System.out.println("calculator mode ");
                    // Creating a socket to listen at port 1234
       
  
     
                    while (true) {
            byte[] buf = new byte[65535];
  
            // Creating a DatagramPacket to receive the data.
            DatagramPacket DpReceive = new DatagramPacket(buf, buf.length);
  
            // Receiving the data in byte buffer.
            datagramSocket.receive(DpReceive);
  
            String inp = new String(buf, 0, buf.length);
  
            // Using trim() method to
            // remove extra spaces.
            inp = inp.trim();
  
            System.out.println("Equation Received: "
                               + inp);
  
            // Exit the server if the client sends "bye"
            if (inp.equals("bye")) {
                System.out.println(
                    "Client sent bye.....EXITING");
  
                // Exit from program here itself without
                // checking further
                break;
            }
  
            int result;
  
            // Use StringTokenizer to break the
            // equation into operand and operation
            StringTokenizer st = new StringTokenizer(inp);  
            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());
  
            // Perform the required operation
            if (operation.equals("+"))
                result = oprnd1 + oprnd2;
  
            else if (operation.equals("-"))
                result = oprnd1 - oprnd2;
  
            else if (operation.equals("*"))
                result = oprnd1 * oprnd2;
  
            else
                result = oprnd1 / oprnd2;
  
           // System.out.println("Sending the result...");
            String res = Integer.toString(result);
  
            // Clearing the buffer after every message
            buffer = res.getBytes();
  
            // Getting the port of client
           // int port = DpReceive.getPort();
  
          DatagramPacket  DpSend = new DatagramPacket(
                buffer, buffer.length, InetAddress.getLocalHost(),
                port);
            datagramSocket.send(DpSend);
            System.out.println("Sending the result...");
        }
                   
                   
               }
                System.out.print("server : " );
                String mess =scanner.nextLine();
                buffer =mess.getBytes();
          
                datagramPacket = new DatagramPacket(buffer,buffer.length,inetAdress,port);
            datagramSocket.send(datagramPacket);
              
           }catch (IOException e){
               e.printStackTrace();
               break;
           }
        }
    }
    public static void main(String [] args) throws SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket(1234);
        Server server = new Server(datagramSocket);
        server.udpserver();
        

    }
}
