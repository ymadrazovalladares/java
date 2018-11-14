
import java.net.*;
import java.io.*;

public class conexion {
    public static void main(String[] args) {
       /* if (args.length != 3)
            System.out.println ("This program requires three command line arguments");
        else {*/
            try {
                InetAddress receiverHost = InetAddress.getByName("192.168.161.248");//InetAddress.getByName(args[0]);
                int receiverPort = 12345;//Integer.parseInt(args[1]);
                String message = "Hola como estas";//args[2];

                // instantiates a datagram socket for sending the data
                DatagramSocket  mySocket = new DatagramSocket();
                byte[ ] buffer = message.getBytes( );
                DatagramPacket datagram =
                        new DatagramPacket(buffer, buffer.length,
                                receiverHost, 12);
                mySocket.send(datagram);
                mySocket.close( );
            } // end try
            catch (Exception ex) {
                ex.printStackTrace( );
            /*}*/
        } // end else
    } // end main
} // end class
