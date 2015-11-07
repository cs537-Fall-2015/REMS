package REMS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FRemsclient {

	public static void main(String[] args) throws IOException {
		int port = 3656;
		Socket client = null;
		Scanner scan = new Scanner(System.in);
		String msg = null;
		try {
			client = new Socket("localhost", port);

			System.out.println("Connecting to server on port " + port);

			System.out.println("Connection Established: " + client.getRemoteSocketAddress());

			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			DataInputStream in = new DataInputStream(client.getInputStream());

			while (msg != "exit") {

				System.out.print("Enter A Command: ");

				msg = scan.nextLine();

				if (msg.equalsIgnoreCase("exit")) {
					out.writeUTF(msg);

					String msgfromserver = in.readUTF().toString().toUpperCase();
					System.out.println("Response From Server: " + msgfromserver.toUpperCase());

					break;
				}

				out.writeUTF(msg);
				System.out.println("Command Sent for processing");

				String msgfromserver = in.readUTF().toString().toUpperCase();
				
				System.out.println("\nResponse From Server: " + msgfromserver);
				
				String msgfromserver2 = in.readUTF().toString().toUpperCase();

				System.out.println("\nResponse From Server: " + msgfromserver2);

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			client.close();
		}
	}
}
