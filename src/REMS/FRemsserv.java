package REMS;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class FRemsserv {

	public static void main(String args[])

	{
		int port = 3656;

		try {
			ServerSocket ss = new ServerSocket(port);

			System.out.println("waiting to connect ");

			Socket con = ss.accept();

			System.out.println("Just connected to " + con.getRemoteSocketAddress());

			DataInputStream in = new DataInputStream(con.getInputStream());
			System.out.println("created datastream");

			String cmdfromclient = in.readUTF().toString();

			System.out.println("message from client  is :" + cmdfromclient);

			DataOutputStream out = new DataOutputStream(con.getOutputStream());

			// out.writeUTF("Thank you for connecting to "+
			// con.getLocalSocketAddress() + "\nGoodbye!");

			Commands cmd = new Commands();

			if (cmdfromclient.equalsIgnoreCase("maxspeed")) {
				out.writeUTF("MAX SPEED " + cmd.windmax);
				// System.out.println(" MAX SPEED "+cmd.windmax);
			}

			else if (cmdfromclient.equalsIgnoreCase("minspeed")) {
				out.writeUTF("MAX SPEED " + cmd.windmin);

				// System.out.println(" MIN SPEED "+cmd.windmin);
			} else if (cmdfromclient.equalsIgnoreCase("speed")) {
				out.writeUTF("MAX SPEED " + cmd.getWindspeed());

				// System.out.println(" SPEED "+cmd.getWindspeed());
			}

			else {
				out.writeUTF("eneter proper command ");
				out.writeUTF("1)maxspeed\n2)minspeed \n3) speed");
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}