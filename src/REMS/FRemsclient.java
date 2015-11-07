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

<<<<<<< HEAD
	public static void main(String[] args) {
		int port = 3656;

		try {
			Socket client = new Socket("localhost", port);

			System.out.println("Connecting to server" + " on port " + port);

			System.out.println("Just connected to client "
					+ client.getRemoteSocketAddress());

			DataOutputStream out = new DataOutputStream(
					client.getOutputStream());

			System.out.println("enter mesaage for server");
			Scanner scan = new Scanner(System.in);
			String msg = scan.nextLine();

			out.writeUTF(msg);
			System.out.println("out for deliverd");

			DataInputStream in = new DataInputStream(client.getInputStream());

			String msgfromserver = in.readUTF().toString().toUpperCase();

			System.out.println("msg  from  server " + msgfromserver);

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
=======
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
					System.out.println("Response From Server: " + msgfromserver);

					break;
				}

				out.writeUTF(msg);
				System.out.println("Command Sent");

				String msgfromserver = in.readUTF().toString().toUpperCase();

				System.out.println("\nResponse From Server: " + msgfromserver);

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			client.close();
>>>>>>> refs/remotes/origin/Sunil-Branch
		}
	}
}
