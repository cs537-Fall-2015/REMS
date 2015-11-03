package REMS.refrencecode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;
	private int port;

	public Server(int port) {
		this.port = port;
	} 

	public void start() throws IOException {
		System.out.println("Starting the socket server at port:" + port);
		serverSocket = new ServerSocket(port);

		// Listen for clients. Block till one connects

		System.out.println("Waiting for clients...");
		Socket socketclient = serverSocket.accept();

		sendWelcomeMessage(socketclient);
	}

	private void sendWelcomeMessage(Socket socketclient) throws IOException {
		BufferedWriter bfwriter = new BufferedWriter(new OutputStreamWriter(socketclient.getOutputStream()));
		bfwriter.write("Hello. You are connected to a Simple Socket Server. What is your name?");
		bfwriter.flush();
		bfwriter.close();
	}

	/**
	 * Creates a SocketServer object and starts the server.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// Setting a default port number.
		int portNumber = 10254;

		try {
			// initializing the Socket Server
			Server socketServer = new Server(portNumber);
			socketServer.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
