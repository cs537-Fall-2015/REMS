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
										
					System.out.println("Message from client: " + cmdFromClient.toUpperCase());

					// Data output stream to write data to the client
					DataOutputStream out = new DataOutputStream(con.getOutputStream());

					// Created an object of commands
					Commands cmd = new Commands();

					// check if the command is valid
					if (cmdFromClient.equalsIgnoreCase("REMS_WINDSPEED_MAX")) {
						out.writeUTF("MAX WINDSPEED IS BEING CALCULATED. Please Wait..");
						Thread.sleep(5000);
						out.writeUTF("CALCULATED MAX SPEED " + cmd.getWindmax());
					} else if (cmdFromClient.equalsIgnoreCase("REMS_WINDSPEED_MIN")) {
						out.writeUTF("MIN WINDSPEED IS BEING CALCULATED. Please Wait..");
						Thread.sleep(4000);
						out.writeUTF("CALCULATED MIN SPEED " + cmd.getWindmin());
					} else if (cmdFromClient.equalsIgnoreCase("REMS_WINDSPEED")) {
						out.writeUTF("WINDSPEED IS BEING CALCULATED. Please Wait..");
						Thread.sleep(2000);
						out.writeUTF("CALCULATED SPEED " + cmd.getWindspeed());
					} else if (cmdFromClient.equalsIgnoreCase("exit")) {
						out.writeUTF("Connection Terminated");
						out.writeUTF("Exit");
					} else if (cmdFromClient.equalsIgnoreCase("Command List")) {
						out.writeUTF("\n\tREMS_WINDSPEED_MIN,"
									+ "\tREMS_WINDSPEED_MAX"
									+ "\tREMS_WINDSPEED"
									+ "\n\tREMS_GROUDTEMP_MIN"
									+ "\tREMS_GROUNDTEMP_MAX"
									+ "\tREMS_GROUNDTEMP"
									+ "\n\tREMS_AIRTEMP"
									+ "\t\tREMS_AIRTEMP_MIN"
									+ "\tREMS_AIRTEMP_MAX"
									+ "\n\tREMS_PRESSURE"
									+ "\t\tREMS_ULTRAVIOLET"
									+ "\n\tREMS_HUMIDITY"
									+ "\t\tREMS_HUMIDITY_MIN"
									+ "\tREMS_HUMIDITY_MAX");
						out.writeUTF("");
					}else {
						out.writeUTF("Invalid Command");
						out.writeUTF("");
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