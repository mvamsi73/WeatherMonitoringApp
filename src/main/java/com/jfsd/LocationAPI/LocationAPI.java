package com.jfsd.LocationAPI;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfsd.BEAN.AccuWeatherApiKey;

public class LocationAPI 
{
	JSONObject LocationData=new JSONObject();
	public JSONObject getLocationData(String location) throws JSONException
	{
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		AccuWeatherApiKey Accuapikey=(AccuWeatherApiKey) acb.getBean("AccuWeatherApiKey");
		String url="http://dataservice.accuweather.com/locations/v1/search?apikey="+Accuapikey.getAccuapikey()+"&q="+location;
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String json = IOUtils.toString(entity.getContent());
		    JSONArray LocationsArray = new JSONArray(json);
		    JSONObject LocationsObject = LocationsArray.getJSONObject(0); 
		    JSONObject GeoPosition= LocationsObject.getJSONObject("GeoPosition");
		    JSONObject Continent=LocationsObject.getJSONObject("Region");
		    JSONObject Country=LocationsObject.getJSONObject("Country");
		    JSONObject State=LocationsObject.getJSONObject("AdministrativeArea");
		    JSONArray DistrictArray=LocationsObject.getJSONArray("SupplementalAdminAreas");
		    JSONObject District=DistrictArray.getJSONObject(0);
		    LocationData.put("Status", "Location Found");
		    LocationData.put("Key", LocationsObject.get("Key"));
		    LocationData.put("City", LocationsObject.get("LocalizedName"));
		    LocationData.put("City_Type", LocationsObject.get("Type"));
		    LocationData.put("Latitude", GeoPosition.get("Latitude"));
		    LocationData.put("Longitude", GeoPosition.get("Longitude"));
		    LocationData.put("Continent", Continent.get("LocalizedName"));
		    LocationData.put("Country", Country.get("LocalizedName"));
		    LocationData.put("District", District.get("LocalizedName"));
		    LocationData.put("State", State.get("LocalizedName"));
		    		    			
		}
		catch(IOException ioe) 
		{
			System.out.println("Something went wrong on getting Location");
			LocationData.put("Status", "Location Not Found");
//		ioe.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Unknown Error:");
			LocationData.put("Status", "Location Not Found");
//		e.printStackTrace();
		}
		return LocationData;
	}

}
