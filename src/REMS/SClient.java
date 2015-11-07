package REMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SClient {

	public static void main(String[] args) throws IOException {

		String serverHostname = new String("localhost");
		int port = 9876;
		
		System.out.println("Attemping to connect to host " + serverHostname + " on port " + port);

		Socket remsSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			remsSocket = new Socket(serverHostname, port);
			out = new PrintWriter(remsSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(remsSocket.getInputStream()));
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.print("input: ");
		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
			System.out.print("input: ");
		}

		out.close();
		in.close();
		stdIn.close();
		remsSocket.close();

	}

}
