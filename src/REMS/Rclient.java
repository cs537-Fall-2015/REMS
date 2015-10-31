package REMS;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Rclient {

	
	 public static void main(String [] args)
	   {
		 int port = 9001;
		 
		
		 
		 
		 try
	      {
			 ServerSocket ss = new ServerSocket(8080);
			 
	         System.out.println("Connecting to server" +
			 " on port " + port);
	         Socket client = new Socket("localhost",port);
	        
	         System.out.println("Just connected to " 
			 + client.getRemoteSocketAddress());
	         
	         
	         OutputStream outToServer = client.getOutputStream();
	         
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("this Rems  client "+client.getLocalAddress());
	         
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         System.out.println("Server says " + in.readUTF());
	         
	         
	         client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	         System.out.println(e.getLocalizedMessage());	      }
	   }
	}