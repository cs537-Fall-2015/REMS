package REMS;

import java.util.Random;
import java.util.Scanner;

public class Commands {

	private int windmax = 100;
	private int windmin = 45;
	private int windspeed;

	public int getWindmax() {
		return windmax;
	}
	
	public void setWindMax (int windmax) {
		this.windmax = windmax;
	}

	public int getWindmin() {
		return windmin;
	}
	
	public void setWindMin(int windmin) {
		this.windmin = windmin;
	}

	public int getWindspeed() {

		Random r = new Random();
		int windspeed = r.nextInt(windmax - windmin) + windmin;
		return windspeed;
	}

/*	void startup() {
		int count = 0;

		System.out.println("1)MINIMUM SPEED \n2)WIND SPEED \n3) MAXIMUM SPEED");
		System.out.println("enter command choice \n ");

		Scanner scaner = new Scanner(System.in);

		int choice = scaner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("MINwind speed is :" + this.getWindmin());

			break;

		case 2:
			System.out.println("wind speed is :" + this.getWindspeed());

			break;

		case 3:
			System.out.println("maximum is :" + this.getWindmax());

			break;

		}

	}

	public static void main(String args[]) {
		Commands comand = new Commands();
		comand.startup();
		System.out.println("press 1 to continue");
		Scanner scaner = new Scanner(System.in);

		int c = scaner.nextInt();
		switch (c) {
		case 1:
			comand.startup();
			break;

		default:
			System.out.println("exited");
			break;
		}

	}
 */
}
