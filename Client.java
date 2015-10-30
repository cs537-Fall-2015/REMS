import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	 private String hostname;
	    private int port;
	    Socket socketClient;

	    public Client(String hostname, int port){
	        this.hostname = hostname;
	        this.port = port;
	    }

	    public void connect() throws UnknownHostException, IOException{
	        System.out.println("Attempting to connect to "+hostname+":"+port);
	        socketClient = new Socket(hostname,port);
	        System.out.println("Connection Established");
	    }

	    public void readResponse() throws IOException{
	        String userInput;
	        BufferedReader bfReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

	        System.out.println("Response from server:");
	        while ((userInput = bfReader.readLine()) != null) {
	            System.out.println(userInput);
	        }
	    }

	    public static void main(String arg[]){
	        //Creating a SocketClient object
	        Client socketclient = new Client ("localhost",10254);
	        try {
	            //trying to establish connection to the server
	            socketclient.connect();
	            //if successful, read response from server
	            socketclient.readResponse();

	        } catch (UnknownHostException e) {
	            System.err.println("Host unknown. Cannot establish connection");
	        } catch (IOException e) {
	            System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
	        }
	    }
}
