package REMS.REMS_testFramework;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class REMS_Testmain {

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

			System.out.println("Command Sent for processing");

			while ((msgFromServer = in.readUTF().toString().toUpperCase()) != null) {

				listOfCommands.add(msgFromServer);

				System.out.println("\nResponse From Server: " + msgFromServer);

				for (String list : listOfCommands) {
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

		File file = new File("P:/CS_537/REMS_Workspace/REMS/ServerOutput.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		for (String list : listOfCommands) {
			bw.write(list + "\n");
		}

		bw.close();

	}
}
