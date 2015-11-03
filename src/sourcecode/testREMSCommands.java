package sourcecode;

public class testREMSCommands {

	public static void main(String[] args) {
		
		REMSCommands commands = new REMSCommands(Commands.REMS_GROUDTEMP_MIN);
		commands.remsCommands();
		
		REMSCommands commands1 = new REMSCommands(Commands.REMS_ULTRAVIOLET);
		commands1.remsCommands();
		
		REMSCommands commands2 = new REMSCommands(Commands.REMS_AIRTEMP_MIN);
		commands2.remsCommands();
		
		REMSCommands commands3 = new REMSCommands(Commands.REMS_WINDSPEED_MIN);
		commands3.remsCommands();

	}

}
