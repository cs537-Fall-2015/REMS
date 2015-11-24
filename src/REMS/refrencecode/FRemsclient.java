package REMS.refrencecode;

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

public class FRemsclient {

	public static void main(String[] args) throws IOException {
		int port = 3656;
		Socket client = null;
		
		List<String> listOfCommands = new ArrayList<String>();
		
		String msgFromServer;

		
		try {
			client = new Socket("localhost", port);

			System.out.println("Connecting to server on port " + port);

			System.out.println("Connection Established: " + client.getRemoteSocketAddress());

			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			
			for (String line : Files.readAllLines(Paths.get("P:/CS_537/REMS_Workspace/REMS/Commands.txt"))) {
			    for (String part : line.split("\\s")) {
			        listOfCommands.add(part);
			    }
			}
			
			for (String list: listOfCommands) {
				System.out.println(list);
			}
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(client.getOutputStream());
            objectOutput.writeObject(listOfCommands);
			
			
			System.out.println("Command Sent for processing");

			while((msgFromServer = in.readUTF().toString().toUpperCase()) != null) {
				
			listOfCommands.add(msgFromServer);
												
				System.out.println("\nResponse From Server: " + msgFromServer);
				
				for (String list: listOfCommands) {
					System.out.println(" Added To ArrayList: " + list);
				}
				
				AddToFile(listOfCommands);
				System.out.println("Done");	
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			client.close();			
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
