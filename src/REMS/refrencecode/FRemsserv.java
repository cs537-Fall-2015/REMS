package REMS.refrencecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import REMS.Commands;

public class FRemsserv {
	
	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		
		List<String> listOfCommands = new ArrayList<String>();

		// port to establish the connection on
		int port = 3656;

		// Record the timestamp of the client connection
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
		Date date = new Date();

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
				System.out.println("Created Datastream to read input");

				DataInputStream in =  new DataInputStream(con.getInputStream());
				 
/*				for (String line : Files.readAllLines(Paths.get("P:/CS_537/REMS_Workspace/REMS/Commands.txt"))) {
				    for (String part : line.split("\\s")) {
				        listOfCommands.add(part);
				    }
				} */
				String cmdFromClient;
				
                ObjectInputStream objectInput = new ObjectInputStream(con.getInputStream()); //Error Line!
                Object object = objectInput.readObject();
                
                listOfCommands =  (ArrayList<String>) object;
                
//                System.out.println(titleList.get(1));

//                while ((cmdFromClient = in.readUTF().toString()) != null) {
//					listOfCommands.add(cmdFromClient);
//				}
				
				for (String list: listOfCommands) {
					System.out.println(list);
				}
								
				// Store the command from the client
			//	while ((cmdFromClient = in.readUTF().toString()) != null) {
				for (int i = 0; i < listOfCommands.size(); i++) {
					System.out.println("Message from client: " + listOfCommands.get(i));

					// Data output stream to write data to the client
					DataOutputStream out = new DataOutputStream(con.getOutputStream());

					// Created an object of commands
					Commands cmd = new Commands();

					// check if the command is valid
					switch (listOfCommands.get(i)) {
					case "REMS_WINDSPEED_MIN":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN WIND SPEED " + cmd.getREMS_WINDSPEED_MIN());
						break;
					case "REMS_WINDSPEED":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED WIND SPEED " + cmd.getREMS_WINDSPEED());
						break;
					case "REMS_WINDSPEED_MAX":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX WIND SPEED " + cmd.getREMS_WINDSPEED_MAX());
						break;
					case "REMS_GROUDTEMP_MIN":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN GROUND TEMPERATURE " + cmd.getREMS_GROUDTEMP_MIN());
						break;
					case "REMS_GROUNDTEMP_MAX":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX GROUND TEMPERATURE " + cmd.getREMS_GROUNDTEMP_MAX());
						break;
					case "REMS_GROUNDTEMP":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED GROUND TEMPERATURE " + cmd.getREMS_GROUNDTEMP());
						break;
					case "REMS_AIRTEMP":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED AIR TEMPERATURE " + cmd.getREMS_AIRTEMP());
						break;
					case "REMS_AIRTEMP_MIN":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN AIR TEMPERATURE " + cmd.getREMS_AIRTEMP_MIN());
						break;
					case "REMS_AIRTEMP_MAX":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX AIR TEMPERATURE " + cmd.getREMS_AIRTEMP_MAX());
						break;
					case "REMS_PRESSURE":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED PRESSURE " + cmd.getREMS_PRESSURE());
						break;
					case "REMS_ULTRAVIOLET":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED ULTRAVIOLET " + cmd.getREMS_ULTRAVIOLET());
						break;
					case "REMS_HUMIDITY":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED HUMIDITY " + cmd.getREMS_HUMIDITY());
						break;
					case "REMS_HUMIDITY_MIN":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN HUMIDITY " + cmd.getREMS_HUMIDITY_MIN());
						break;
					case "REMS_HUMIDITY_MAX":
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX HUMIDITY" + cmd.getREMS_HUMIDITY_MAX());
						break;
					default:
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