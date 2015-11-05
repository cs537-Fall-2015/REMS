package REMS;

import java.util.Random;
import java.util.Scanner;

public class Command_temp {
	int groudtemp_max=100,groudtemp_min=45,groudtemp;
	

	

		public int getGroudtemp_max() {
		return groudtemp_max;
	}


	public void setGroudtemp_max(int groudtemp_max) {
		this.groudtemp_max = groudtemp_max;
	}


	public int getGroudtemp_min() {
		return groudtemp_min;
	}


	public void setGroudtemp_min(int groudtemp_min) {
		this.groudtemp_min = groudtemp_min;
	}


		public int getGroudtemp() {
		
			
			Random r = new Random();
			int windspeed = r.nextInt(groudtemp_max-groudtemp_min)+groudtemp_min;		
			return windspeed;
		}


	void startup()
	{
		int count = 0;
		
		System.out.println("1)MINIMUM Tempreture \n2)GROUDTEMP \n3) MAXIMUM Tempreture");
		System.out.println("enter command choice \n ");
		
		Scanner scaner =  new Scanner(System.in);
		
		int choice = scaner.nextInt();
		
		
		switch(choice)
		{
		case 1:System.out.println("groudtemp_max is :"+this.getGroudtemp_min());
			
			break;
			
		case 2:
			System.out.println("groud temperature is :"+this.getGroudtemp());
			
			break;
			
		case 3:
			System.out.println("groudtemp_min is :"+this.getGroudtemp_max());
			
			break;
		
		
			
		
		}
		
		
		
		
		
	}
		
		public static void main(String args[])
		{
			Commands comand = new Commands();
			comand.startup();
			System.out.println("press 1 to continue");
			Scanner scaner = new Scanner(System.in);
			
			int c=scaner.nextInt(); 
			switch(c)
			{
			case 1: comand.startup();
			break;
			
			default: System.out.println("exited"); break;
			}
			
		}
		
}
