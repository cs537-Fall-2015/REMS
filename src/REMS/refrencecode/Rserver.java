package REMS.refrencecode;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Rserver {
	
	
	
	public static void main(String args[])
	
	{
		
		
try{
	 
	 ServerSocket ss = new ServerSocket(8080);
 
	 Socket con = ss.accept();


	 System.out.println("Just connected to "
             + con.getRemoteSocketAddress());
       DataInputStream in =
             new DataInputStream(con.getInputStream());
       System.out.println(in.readUTF());
       DataOutputStream out =new DataOutputStream(con.getOutputStream());
       out.writeUTF("Thank you for connecting to "+ con.getLocalSocketAddress() + "\nGoodbye!");
     
       con.close();









}catch(Exception e)
{
	System.out.println(e.getLocalizedMessage());
}

	}
}