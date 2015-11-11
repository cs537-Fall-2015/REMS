package sockets;


import java.io.*;

public class CommandsRead {

	
	static String path="C:/Users/daxesh/Documents/GitHub/REMS/src/REMS/cmdline.txt";
	static String cmd[] = new String[10];
	
	
	public static void main (String args[])
	{
		cm();
		
	}
	
	static void cm()
	{
		String line;
		try{
				FileReader file = new FileReader(path); 		
				
				BufferedReader read = new BufferedReader(file);
				
				
				
				System.out.println("commad list :: ");
				int i=0;
				while((line = read.readLine())!= null)
				{
					
					cmd[i]=line;
					System.out.println(cmd[i]);
					i++;
				}
				
				
				
				
				
		}catch(Exception e )
		{

			System.out.println("error msg is"+e.getLocalizedMessage()+e.getStackTrace());
		}
	}
	
	
}
