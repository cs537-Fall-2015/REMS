package REMS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class REMSServer extends Thread{
	
	private String host;
	private int port;
	
	List<String> listOfCommands = new ArrayList<String>();

	// Record the timestamp of the client connection
	DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
	Date date = new Date();

	Socket con = null;
	
	public REMSServer(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void run() {
		try {
			// Establish a serversocket on a specified port
			ServerSocket ss = new ServerSocket(port);
			
			
			System.out.println("Waiting for client to request a connection.. ");

			// Accept the connection from a client
			while (true) {

				con = ss.accept();
				System.out.println("Server Connection Established to: " + con.getRemoteSocketAddress() + "\nTimestamp: "
						+ dateFormat.format(date));

				// Data input steam to read the incoming data from the client
				System.out.println("Created Datastream to read input\n");
			
				
				
				DataInputStream in =  new DataInputStream(con.getInputStream());
				 
				ObjectInputStream objectInput = new ObjectInputStream(con.getInputStream()); //Error Line!
                Object object = objectInput.readObject();
                
                listOfCommands =  (ArrayList<String>) object;
				
             // Data output stream to write data to the client
				DataOutputStream out = new DataOutputStream(con.getOutputStream());

				// Created an object of commands
				Commands cmd = new Commands();
				Random rn = new Random();
				
				for (int i = 0; i < listOfCommands.size(); i++) {
					System.out.println("Message from client: " + listOfCommands.get(i));
				}
				
				// Store the command from the client
			//	while ((cmdFromClient = in.readUTF().toString()) != null) {
				for (int i = 0; i < listOfCommands.size(); i++) {
					
//					System.out.println("Message from client: " + listOfCommands.get(i));

					// check if the command is valid
					switch (listOfCommands.get(i)) {
					case "REMS_WINDSPEED_MIN":
						// 5mph - 10mph
						int min_windspeed = rn.nextInt(10 - 5 + 1) + 5;
						cmd.setREMS_WINDSPEED_MIN(min_windspeed);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN WIND SPEED " + cmd.getREMS_WINDSPEED_MIN() + " mph");
						break;
					case "REMS_WINDSPEED":
						// 20mph - 40mph
						int windspeed = rn.nextInt(40 - 20 + 1) + 20;
						cmd.setREMS_WINDSPEED(windspeed);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED WIND SPEED " + cmd.getREMS_WINDSPEED() + " mph");
						break;
					case "REMS_WINDSPEED_MAX":
						// 55mph - 65mph
						int max_windspeed = rn.nextInt(65 - 55 + 1) + 55;
						cmd.setREMS_WINDSPEED_MAX(max_windspeed);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX WIND SPEED " + cmd.getREMS_WINDSPEED_MAX() + " mph");
						break;
					case "REMS_GROUDTEMP_MIN":
						// 55F - 68F
						int min_groundTemp = rn.nextInt(68 - 55 + 1) + 55;
						cmd.setREMS_GROUDTEMP_MIN(min_groundTemp);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN GROUND TEMPERATURE " + cmd.getREMS_GROUDTEMP_MIN()+ " Fahrenheit");
						break;
					case "REMS_GROUNDTEMP_MAX":
						// -220F - -243F
						int max_groundTemp = rn.nextInt(243 - 220 + 1) + 220;
						cmd.setREMS_GROUNDTEMP_MAX(max_groundTemp);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX GROUND TEMPERATURE -" + cmd.getREMS_GROUNDTEMP_MAX() + " Fahrenheit");
						break;
					case "REMS_GROUNDTEMP":
						// 80F - -80F
						int groundTemp = rn.nextInt((80) - (-40 + 1)) + (-40);
						cmd.setREMS_GROUNDTEMP(groundTemp);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED GROUND TEMPERATURE " + cmd.getREMS_GROUNDTEMP() + " Fahrenheit");
						break;
					case "REMS_AIRTEMP": 
						// 350 - 500 pascals
						int atmosphericPress = rn.nextInt( 500 - 350 + 1 ) + 350;
						cmd.setREMS_AIRTEMP(atmosphericPress);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED ATMOSPHERIC PRESSURE " + cmd.getREMS_AIRTEMP() + " Pascal");
						break;
					case "REMS_AIRTEMP_MIN":
						// 30 - 80 pascals
						int min_atmosphericPress = rn.nextInt( 80 - 30 + 1 ) + 30;
						cmd.setREMS_AIRTEMP_MIN(min_atmosphericPress);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN ATMOSPHERIC PRESSURE " + cmd.getREMS_AIRTEMP_MIN() + " Pascal");
						break;
					case "REMS_AIRTEMP_MAX":
						// 600 - 750 pascal
						int max_atmosphericPress = rn.nextInt( 750 - 600 + 1 ) + 600;
						cmd.setREMS_AIRTEMP_MAX(max_atmosphericPress);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX ATMOSPHERIC PRESSURE " + cmd.getREMS_AIRTEMP_MAX() + " Pascal");
						break;
					case "REMS_ULTRAVIOLET":
						int ultraviolet = rn.nextInt( 5 - 1 + 1 ) + 1;
						cmd.setREMS_ULTRAVIOLET(ultraviolet);
						
						String getUltraviolet = "Moderate radiation";
						
						switch (cmd.getREMS_ULTRAVIOLET()) {
						case 5:
							getUltraviolet = "Extream Radiation";
							break;
						case 4:
							getUltraviolet = "Very High Radiation";
							break;
						case 3:
							getUltraviolet = "High Radiation";
							break;
						case 2:
							getUltraviolet = "Moderate Radiation";
							break;
						case 1:
							getUltraviolet = "Low Radiation";
							break;
						default:
								
						}
						
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED ULTRAVIOLET " + getUltraviolet);
						break;
					case "REMS_HUMIDITY":
						// 70% - 74%
						int humidity = rn.nextInt( 74 - 70 + 1 ) + 70;
						cmd.setREMS_HUMIDITY(humidity);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED HUMIDITY " + cmd.getREMS_HUMIDITY()  + "%");
						break;
					case "REMS_HUMIDITY_MIN":
						// 75% - 79%
						int min_humidity = rn.nextInt( 79 - 75 + 1 ) + 75;
						cmd.setREMS_HUMIDITY_MIN(min_humidity);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MIN HUMIDITY " + cmd.getREMS_HUMIDITY_MIN() + "%");
						break;
					case "REMS_HUMIDITY_MAX":
						// 80% - 100%
						int max_humidity = rn.nextInt( 100 - 80 + 1 ) + 80;
						cmd.setREMS_HUMIDITY_MAX(max_humidity);
						out.writeUTF(listOfCommands.get(i) + ": CALCULATED MAX HUMIDITY " + cmd.getREMS_HUMIDITY_MAX() + "%");
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
			try {
				con.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}