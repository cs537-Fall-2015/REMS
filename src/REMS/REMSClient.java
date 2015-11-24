package REMS;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class REMSClient extends Thread{

	private String host;
	private int port;
	
	public REMSClient(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	Socket client = null;
	
	List<String> listOfCommands = new ArrayList<String>();
	List<String> responseFromServer = new ArrayList<String>();
	
	String msgFromServer;
	
	public void run() {
		try {
			client = new Socket(host, port);
			
			System.out.println("Connecting to server on port " + port);

			System.out.println("Client Connection Established: " + client.getRemoteSocketAddress());
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			
			//read the commands from a text file
			for (String line : Files.readAllLines(Paths.get("P:/CS_537/REMS_Workspace/REMS/Commands.txt"))) {
			    for (String part : line.split("\\s")) {
			        listOfCommands.add(part);
			    }
			}
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(client.getOutputStream());
            objectOutput.writeObject(listOfCommands);

			System.out.println("Command Sent for processing\n");

			//Read all the responses from the server
			while((msgFromServer = in.readUTF().toString().toUpperCase()) != null) {
				
				responseFromServer.add(msgFromServer);
																
				System.out.println("\nResponse From Server: " + msgFromServer);
				Thread.sleep(1000);
					
				//create an output file
				AddToFile(responseFromServer);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {	
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}	
	}

	private static void AddToFile(List<String> responseFromServer) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
		Date date = new Date();
		
		//files location
		File file = new File("P:/CS_537/REMS_Workspace/REMS/ServerOutput.txt");
		
		//creating a new file
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("==================== " +  dateFormat.format(date) + " ====================\n");
		//write data to the output file
		for (String list: responseFromServer) {
			bw.write(list + "\n");
		}
		bw.write("===================================================================\n");
		
		//close the writer
		bw.close();
		
	}	
}
