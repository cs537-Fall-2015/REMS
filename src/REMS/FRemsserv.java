package REMS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FRemsserv {

	public static void main(String args[]) throws IOException {
		// port to establish the connection on
		int port = 3656;

		// Record the timestamp of the client connection
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
		Date date = new Date();

		String cmdFromClient = "";
		Socket con = null;

		try {
			// Establish a serversocket on a specified port
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Waiting for client to request a connection.. ");

			// Accept the connection from a client
			while (true) {

				con = ss.accept();
				System.out.println("Connection Established to: " + con.getRemoteSocketAddress() + "\nTimestamp: "
						+ dateFormat.format(date));

				// Data input steam to read the incoming data from the client
				DataInputStream in = new DataInputStream(con.getInputStream());
				System.out.println("Created Datastream to read input");

				
				// Store the command from the client
				while ((cmdFromClient = in.readUTF().toString()) != null) {
										
					System.out.println("Message from client: " + cmdFromClient);

					// Data output stream to write data to the client
					DataOutputStream out = new DataOutputStream(con.getOutputStream());

					// Created an object of commands
					Commands cmd = new Commands();

					// check if the command is valid
					if (cmdFromClient.equalsIgnoreCase("maxspeed")) {
						out.writeUTF("MAX SPEED " + cmd.windmax);
					} else if (cmdFromClient.equalsIgnoreCase("minspeed")) {
						out.writeUTF("MAX SPEED " + cmd.windmin);
					} else if (cmdFromClient.equalsIgnoreCase("speed")) {
						out.writeUTF("MAX SPEED " + cmd.getWindspeed());
					} else if (cmdFromClient.equalsIgnoreCase("exit")) {
						out.writeUTF("Connection Terminated");
					} else {
						out.writeUTF("Invalid Command");
					}
				}
			}
			// catch any exceptions
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			// close the connection
			con.close();
		}

	}

}