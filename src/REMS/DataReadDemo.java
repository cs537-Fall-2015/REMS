package REMS;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

public class DataReadDemo {

	static ArrayList<Integer> REMS_WINDSPEED = new ArrayList<Integer>();
	static ArrayList<Integer> REMS_GROUDTEMP = new ArrayList<Integer>();
	static ArrayList<Integer> REMS_AIRTEMP = new ArrayList<Integer>();
	static ArrayList<Integer> REMS_PRESSURE = new ArrayList<Integer>();
	static ArrayList<Integer> REMS_HUMIDITY = new ArrayList<Integer>();
	static ArrayList<Integer> REMS_UV = new ArrayList<Integer>();

	static String REMS_WINDSPEED_MIN;
	static String REMS_WINDSPEED_MAX;

	static String REMS_GROUDTEMP_MIN;
	static String REMS_GROUDTEMP_MAX;

	static String REMS_AIRTEMP_MIN;
	static String REMS_AIRTEMP_MAX;

	static String REMS_PRESSURE_MIN;
	static String REMS_PRESSURE_MAX;

	static String REMS_HUMIDITY_MIN;
	static String REMS_HUMIDITY_MAX;

	static String REMS_UV_MIN;
	static String REMS_UV_MAX;

	public static void main(String args[]) {

		String url = "E:\\REMSDEMODATA.txt";
		JSONParser parser = new JSONParser();
		try {

			Object obj = parser.parse(new FileReader(url));

			JSONObject jsonObject = (JSONObject) obj;

			REMS_WINDSPEED_MIN = (String) jsonObject.get("REMS_WINDSPEED_MIN");
			REMS_WINDSPEED_MAX = (String) jsonObject.get("REMS_WINDSPEED_MAX");

			REMS_GROUDTEMP_MIN = (String) jsonObject.get("REMS_GROUDTEMP_MIN");
			REMS_GROUDTEMP_MAX = (String) jsonObject.get("REMS_GROUDTEMP_MAX");

			REMS_AIRTEMP_MIN = (String) jsonObject.get("REMS_AIRTEMP_MIN");
			REMS_AIRTEMP_MAX = (String) jsonObject.get("REMS_AIRTEMP_MAX");

			REMS_PRESSURE_MIN = (String) jsonObject.get("REMS_PRESSURE_MIN");
			REMS_PRESSURE_MAX = (String) jsonObject.get("REMS_PRESSURE_MAX");

			REMS_HUMIDITY_MIN = (String) jsonObject.get("REMS_HUMIDITY_MIN");
			REMS_HUMIDITY_MAX = (String) jsonObject.get("REMS_HUMIDITY_MAX");

			REMS_UV_MIN = (String) jsonObject.get("REMS_UV_MIN");
			REMS_UV_MAX = (String) jsonObject.get("REMS_UV_MAX");

			System.out.println("REMS_WINDSPEED_MIN: " + REMS_WINDSPEED_MIN);
			System.out.println("REMS_WINDSPEED_MAX: " + REMS_WINDSPEED_MAX);

			System.out.println("REMS_GROUDTEMP_MIN: " + REMS_GROUDTEMP_MIN);
			System.out.println("REMS_GROUDTEMP_MAX: " + REMS_GROUDTEMP_MAX);

			System.out.println("REMS_AIRTEMP_MIN: " + REMS_AIRTEMP_MIN);
			System.out.println("REMS_AIRTEMP_MAX: " + REMS_AIRTEMP_MAX);

			System.out.println("REMS_PRESSURE_MIN: " + REMS_PRESSURE_MIN);
			System.out.println("REMS_PRESSURE_MAX: " + REMS_PRESSURE_MAX);

			System.out.println("REMS_HUMIDITY_MIN: " + REMS_HUMIDITY_MIN);
			System.out.println("REMS_HUMIDITY_MAX: " + REMS_HUMIDITY_MAX);

			System.out.println("REMS_UV_MIN: " + REMS_UV_MIN);
			System.out.println("REMS_UV_MAX: " + REMS_UV_MAX);

			// String author = (String) jsonObject.get("REMS_WINDSPEED_MAX");

			JSONArray WINDSPEED = (JSONArray) jsonObject.get("WINDSPEED");
			JSONArray ground = (JSONArray) jsonObject.get("groundtemp");
			JSONArray Airtemp = (JSONArray) jsonObject.get("Airtemp");
			JSONArray pressure = (JSONArray) jsonObject.get("pressure");
			JSONArray humidity = (JSONArray) jsonObject.get("humidity");
			JSONArray ultraviolet = (JSONArray) jsonObject.get("ultraviolet");

			// System.out.println("Author: " + author);

			System.out.println("\nWINDSPEED:");
			Iterator<Integer> iterator = WINDSPEED.iterator();
			while (iterator.hasNext()) {

				System.out.println(iterator.next());

			}

			System.out.println("values to arraylist");
			String str = "";

			for (int i = 0; i < WINDSPEED.size(); i++) {
				str = WINDSPEED.get(i).toString();
				int s = Integer.parseInt(str);

				REMS_WINDSPEED.add(s);
			}
			System.out.println("arraylist \n" + REMS_WINDSPEED);

			System.out.println("\nground:");
			Iterator<Integer> iterator2 = ground.iterator();
			while (iterator2.hasNext()) {

				System.out.println(iterator2.next());

			}

			// convert to arraylist
			System.out.println("values to arraylist");

			for (int i = 0; i < ground.size(); i++) {
				str = ground.get(i).toString();
				int s = Integer.parseInt(str);

				REMS_GROUDTEMP.add(s);
			}
			System.out.println("arraylist \n" + REMS_GROUDTEMP);

			System.out.println("\nAirtemp:");
			Iterator<Integer> iterator3 = Airtemp.iterator();
			while (iterator3.hasNext()) {
				System.out.println(iterator3.next());

			}

			// convert to arraylist
			System.out.println("values to arraylist");

			for (int i = 0; i < Airtemp.size(); i++) {
				str = Airtemp.get(i).toString();
				int s = Integer.parseInt(str);

				REMS_AIRTEMP.add(s);
			}
			System.out.println("arraylist \n" + REMS_AIRTEMP);

			//// pressure
			//
			System.out.println("\npressure:");

			Iterator<Integer> iterator4 = pressure.iterator();
			while (iterator4.hasNext()) {
				System.out.println(iterator4.next());

			}
			// convert to arraylist
			System.out.println("values to arraylist");

			for (int i = 0; i < pressure.size(); i++) {
				str = pressure.get(i).toString();
				int s = Integer.parseInt(str);

				REMS_PRESSURE.add(s);
			}
			System.out.println("arraylist \n" + REMS_PRESSURE);

			System.out.println("\nhumidity:");

			Iterator<Integer> iterator5 = humidity.iterator();
			while (iterator5.hasNext()) {
				System.out.println(iterator5.next());

			}
			// convert to arraylist
			System.out.println("values to arraylist");

			for (int i = 0; i < humidity.size(); i++) {
				str = humidity.get(i).toString();
				int s = Integer.parseInt(str);

				REMS_HUMIDITY.add(s);
			}
			System.out.println("arraylist \n" + REMS_HUMIDITY);

			// ultraviolet
			System.out.println("\nultraviolet:");

			Iterator<Integer> iterator6 = ultraviolet.iterator();
			while (iterator6.hasNext()) {
				System.out.println(iterator6.next());

			}

			// convert to arraylist
			System.out.println("values to arraylist");

			for (int i = 0; i < ultraviolet.size(); i++) {
				str = ultraviolet.get(i).toString();
				int s = Integer.parseInt(str);

				REMS_UV.add(s);
			}
			System.out.println("arraylist \n" + REMS_UV);

		} catch (Exception e) {

			System.out.println("error  : " + e.getLocalizedMessage());
			System.out.println(e.getMessage());

		}

	}

}
