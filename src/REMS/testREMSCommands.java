package REMS;

import java.util.Scanner;

public class testREMSCommands {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter A Command");
//		String command = sc.nextLine();

	
		REMSCommands commands = new REMSCommands(TestCommands.REMS_GROUDTEMP_MIN);
		commands.remsCommands();
		
		REMSCommands commands1 = new REMSCommands(TestCommands.REMS_ULTRAVIOLET);
		commands1.remsCommands();
		
		REMSCommands commands2 = new REMSCommands(TestCommands.REMS_AIRTEMP_MIN);
		commands2.remsCommands();
		
		REMSCommands commands3 = new REMSCommands(TestCommands.REMS_WINDSPEED_MIN);
		commands3.remsCommands();

	}

}
