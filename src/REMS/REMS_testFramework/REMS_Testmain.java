package REMS.REMS_testFramework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class REMS_Testmain {

	public static void main(String[] args) {
		int port = 3656;

		try {
			Socket client = new Socket("localhost", port);

			System.out.println("Connecting to server" + " on port " + port);

			System.out.println("Just connected to client " + client.getRemoteSocketAddress());

			DataOutputStream out = new DataOutputStream(client.getOutputStream());

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
