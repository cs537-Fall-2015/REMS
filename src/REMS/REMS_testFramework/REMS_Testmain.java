package REMS.REMS_testFramework;


import java.io.IOException;
import REMS.REMSClient;
import REMS.REMSServer;

public class REMS_Testmain {

	public static void main(String[] args) throws IOException {

		// Each module has its own port
		int port = 9001;

		try {
			REMSServer serverOne = new REMSServer("localhost", port);
			serverOne.start();
			
			System.out.println("The Server Has Been Started");
			System.out.println("The Client Will Start in 3 sec");
			
			Thread.sleep(3000);
			REMSClient clientOne = new REMSClient("localhost", port);
			clientOne.start();
			
	//		REMSClient clientTwo = new REMSClient("localhost", port);
	//		clientTwo.start();
			
			
			System.out.println("The Client Has Been Connected");
			
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} 
	}
}
