package sourcecode;

public class REMSCommands {
	
	Commands commands;
	
	public REMSCommands(Commands commands) {
		this.commands = commands;
	}
	
	public void remsCommands() {
		switch (commands) {
		case REMS_WINDSPEED_MIN: 
			System.out.println("Command Called: REMS_WINDSPEED_MIN");
			break;
		
		case REMS_WINDSPEED: 
			System.out.println("Command Called: REMS_WINDSPEED");
			break;
			
		case REMS_WINDSPEED_MAX: 
			System.out.println("Command Called: REMS_WINDSPEED_MAX");
			break;
			
		case REMS_GROUDTEMP_MIN: 
			System.out.println("Command Called: REMS_GROUDTEMP_MIN");
			break;
			
		case REMS_GROUNDTEMP_MAX: 
			System.out.println("Command Called: REMS_GROUNDTEMP_MAX");
			break;
			
		case REMS_GROUNDTEMP: 
			System.out.println("Command Called: REMS_GROUNDTEMP");
			break;
			
		case REMS_AIRTEMP: 
			System.out.println("Command Called: REMS_AIRTEMP");
			break;
						
		case REMS_AIRTEMP_MIN: 
			System.out.println("Command Called: REMS_AIRTEMP_MIN");
			break;
			
		case REMS_AIRTEMP_MAX: 
			System.out.println("Command Called: REMS_AIRTEMP_MAX");
			break;
			
		case REMS_PRESSURE: 
			System.out.println("Command Called: REMS_PRESSURE");
			break;
			
		case REMS_ULTRAVIOLET: 
			System.out.println("Command Called: REMS_ULTRAVIOLET");
			break;
			
		case REMS_HUMIDITY: 
			System.out.println("Command Called: REMS_HUMIDITY");
			break;
			
		case REMS_HUMIDITY_MIN: 
			System.out.println("Command Called: REMS_HUMIDITY_MIN");
			break;
			
		case REMS_HUMIDITY_MAX: 
			System.out.println("Command Called: REMS_HUMIDITY_MAX");
			break;
		
		default: 
			System.out.println("Command doesn't exist");
		}
	}
	
}
	
