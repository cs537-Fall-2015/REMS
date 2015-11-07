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
		}
	}
}
