package REMS.REMS_testFramework;


import java.io.IOException;
import REMS.FRemsclient2;
import REMS.FRemsserv2;

public class REMS_Testmain {

	public static void main(String[] args) throws IOException {

		// Each module has its own port
		int port = 9001;

		try {
			FRemsserv2 serverOne = new FRemsserv2("localhost", port);
			serverOne.start();
			
			System.out.println("The Server Has Been Started");
			System.out.println("The Client Will Start in 3 sec");
			
			Thread.sleep(3000);
			FRemsclient2 clientOne = new FRemsclient2("localhost", port);
			clientOne.start();
			System.out.println("The Client Has Been Connected");
			
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} 
	}
}
