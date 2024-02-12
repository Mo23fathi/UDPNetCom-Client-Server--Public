This project consists of two Java files, Client.java and Server.java, which together form a UDP (User Datagram Protocol) communication toolkit. The UDP protocol is used for connectionless communication over a network, making it suitable for applications where speed and efficiency are crucial.

Client.java
The Client.java file contains the implementation of the UDP client. Here's an overview of its functionalities:

Establishes a connection with the server using a DatagramSocket.
Reads input from the user and sends it to the server.
Receives messages from the server and displays them to the user.

Supports two modes:
Standard messaging mode: Allows the client to send and receive messages with the server.
Calculator mode ("ca" command): Allows the client to perform arithmetic calculations by sending mathematical expressions to the server and receiving the results.

Server.java
The Server.java file contains the implementation of the UDP server. Here's an overview of its functionalities:

Listens for incoming UDP packets on a specified port using a DatagramSocket.
Receives messages from clients and processes them accordingly.

Supports two modes:
Standard messaging mode: Allows the server to receive messages from clients and send responses.
Calculator mode: Processes arithmetic expressions received from clients, computes the results, and sends them back to the clients.

How to Use
Compile both Client.java and Server.java using a Java compiler.
Start the server by running the compiled Server class.
Start the client by running the compiled Client class.
Follow the prompts on the client and server consoles to send and receive messages or perform calculations.

Dependencies
Java Development Kit (JDK) version 8 or higher.
