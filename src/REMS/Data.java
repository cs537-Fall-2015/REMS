package sockets;

import java.io.FileWriter;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

public class Data {

	
	public static void main (String args[])
	{
		
		JSONObject obj = new JSONObject();
		obj.put("maxspeed", "100");
		obj.put("minspeed", "45");

		JSONArray list = new JSONArray();
		
		
		
		
		int i=0,max=100,min=45;
		int windspeed;
		for(i=1;i<15;i++)
		{
			
			
			Random rad = new Random();
			windspeed = rad.nextInt(max-min)+min;
		
			list.add(windspeed);
			
		}
		
		obj.put("speed",list);
		
		JSONObject obj2 = new JSONObject();
	    
		obj2.put("tempmax", 120);
		
		
		
		
		try{
			FileWriter file = new FileWriter("E:\\Rspeed.json");
			file.write(obj.toJSONString());
			//file.write(list.toJSONString());
			file.flush();
			file.close();
			
			
		}catch(Exception e){
			
			System.out.println("error"+e.getLocalizedMessage()+e.getStackTrace());
		}
		
		System.out.println(obj);
		
	
	}
	
	
	
}
