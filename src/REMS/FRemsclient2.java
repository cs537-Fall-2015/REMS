package REMS;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FRemsclient2 extends Thread{

	private String host;
	private int port;
	
	public FRemsclient2(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	Socket client = null;
	
	List<String> listOfCommands = new ArrayList<String>();
	
	String msgFromServer;
	
	public void run() {
		try {
			client = new Socket(host, port);

			System.out.println("Connecting to server on port " + port);

			System.out.println("Connection Established: " + client.getRemoteSocketAddress());

			DataInputStream in = new DataInputStream(client.getInputStream());
	
			
			System.out.println("Command Sent for processing");

			while((msgFromServer = in.readUTF().toString().toUpperCase()) != null) {
				
				listOfCommands.add(msgFromServer);
												
				System.out.println("\nResponse From Server: " + msgFromServer);
				
				AddToFile(listOfCommands);
				System.out.println("Done");	
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
		
		File file = new File("P:/CS_537/REMS_Workspace/REMS/ServerOutput.txt");
		
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
