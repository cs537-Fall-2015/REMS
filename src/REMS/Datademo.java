package sockets;

import java.io.FileWriter;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Datademo {

	public static void main (String args[])
	{
		
		int NoOfValues=10;
		JSONObject mainObj = new JSONObject();
JSONArray windspeedarray = new JSONArray();		
		
		
//mainObj.put("MAXWINDSPEED", String.valueOf(100));
//mainObj.put("MAXWINDSPEED", String.valueOf(100));
mainObj.put("REMS_WINDSPEED_MIN", String.valueOf(40));
mainObj.put("REMS_WINDSPEED_MAX", String.valueOf(100));

mainObj.put("REMS_GROUDTEMP_MIN", String.valueOf(40));
mainObj.put("REMS_GROUDTEMP_MAX", String.valueOf(100));

mainObj.put("REMS_AIRTEMP_MIN", String.valueOf(-100));
mainObj.put("REMS_AIRTEMP_MAX", String.valueOf(10));

mainObj.put("REMS_PRESSURE_MIN", String.valueOf(4));
mainObj.put("REMS_PRESSURE_MAX", String.valueOf(8));

mainObj.put("REMS_HUMIDITY_MIN", String.valueOf(40));
mainObj.put("REMS_HUMIDITY_MAX",String.valueOf(100));

mainObj.put("REMS_UV_MIN", String.valueOf(40));
mainObj.put("REMS_UV_MAX", String.valueOf(100));




		int windspeedmax=60,windspeedmin=20;
		int windspeedvalue,i;
		String windspeedstring;
		for(i=1;i<NoOfValues;i++)
		{
			
			//list
			
			Random rad = new Random();
			windspeedvalue = rad.nextInt(windspeedmax-windspeedmin)+windspeedmin;
			//windspeedstring= String.valueOf(windspeedvalue);
		
			windspeedarray.add(windspeedvalue);
			
		}
		
		mainObj.put("WINDSPEED", windspeedarray);	
			
//		
		JSONArray groundtemparray = new JSONArray();		
		
		
		int groundtempmax=72,groundtempdmin=-220;
		int groundtempvalue;
		String groundtempstring;
		for(i=1;i<NoOfValues;i++)
		{
			
			//list
			Random rad = new Random();
			groundtempvalue = rad.nextInt(groundtempmax-groundtempdmin)+groundtempdmin;
			//groundtempstring=String.valueOf(groundtempvalue);
			
			groundtemparray.add(groundtempvalue);
			
		}
	 
		mainObj.put("groundtemp", groundtemparray);	
		
	//airtemp
		
		JSONArray Airtemp = new JSONArray();		
		
		
		int airtempmax=10,airtempmin=-100;
		int airtemprature;
		for(i=1;i<NoOfValues;i++)
		{
			
			//list
			Random rad = new Random();
			airtemprature = rad.nextInt(airtempmax-airtempmin)+airtempmin;
		
			Airtemp.add(airtemprature);
			
		}
		
		mainObj.put("Airtemp", Airtemp);
		
		
//		
JSONArray pressurearray = new JSONArray();		
		
		
		int pressuremax=8,pressuremin=4;
		int pressurevalue;
		for(i=1;i<NoOfValues;i++)
		{
			
			//list
			Random rad = new Random();
			pressurevalue = rad.nextInt(pressuremax-pressuremin)+pressuremin;
		
			pressurearray.add(pressurevalue);
			
		}
     		
		mainObj.put("pressure", pressurearray);
		
/////
	////humidity
		
JSONArray humidityarray = new JSONArray();		
		
		
		int humiditymax=100,humiditymin=40;
		int humidityvalue;
		for(i=1;i<NoOfValues;i++)
		{
			
			//list
			Random rad = new Random();
			humidityvalue = rad.nextInt(humiditymax-humiditymin)+humiditymin;
		
			humidityarray.add(humidityvalue);
			
		}	
		
		mainObj.put("humidity", humidityarray);
		
		
//ultraviolet
		
		JSONArray uvarray = new JSONArray();		
//		
//		
		int uvmax=400,uvmin=200;
		int uvvalue;
		for(i=1;i<NoOfValues;i++)
		{
			
			//list
			Random rad = new Random();
			uvvalue = rad.nextInt(uvmax-uvmin)+uvmin;
		
			uvarray.add(uvvalue);
			
		}
		mainObj.put("ultraviolet", humidityarray);
		
		try{
			FileWriter file = new FileWriter("E:\\REMSDEMODATA.txt");
			file.write(mainObj.toJSONString());
			//file.write(list.toJSONString());
			file.flush();
			file.close();
			
			
		}catch(Exception e){
			
			System.out.println("error"+e.getLocalizedMessage()+e.getStackTrace());
		}
		
		System.out.println(mainObj);
		
	
	}
		
		
		
		
	}

