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

			System.out.println("Connection Established: " + client.getRemoteSocketAddress());

			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			
			for (String line : Files.readAllLines(Paths.get("M:/S/Courses/CS537/workspace/REMS/Commands.txt"))) {
			    for (String part : line.split("\\s")) {
			        listOfCommands.add(part);
			    }
			}
			
		
			ObjectOutputStream objectOutput = new ObjectOutputStream(client.getOutputStream());
            objectOutput.writeObject(listOfCommands);

            
			System.out.println("Command Sent for processing");

			while((msgFromServer = in.readUTF().toString().toUpperCase()) != null) {
				
				responseFromServer.add(msgFromServer);
												
				System.out.println("\nResponse From Server: " + msgFromServer);
								
				AddToFile(responseFromServer);				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {		
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}	
	}

	private static void AddToFile(List<String> listOfCommands) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
		Date date = new Date();
		
		File file = new File("M:/S/Courses/CS537/workspace/REMS/ServerOutput.txt");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("==================== " +  dateFormat.format(date) + " ====================\n");
		for (String list: listOfCommands) {
			bw.write(list + "\n");
		}
		bw.write("===================================================================\n");

		bw.close();
		
	}	
}
