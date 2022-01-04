package com.jfsd.FutureDataAPI;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfsd.BEAN.OpenWeatherApiKey;

public class FutureDataAPI 
{
	public JSONObject getFutureData(String latitude,String longitude)
	{

		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		OpenWeatherApiKey Openapikey=(OpenWeatherApiKey) acb.getBean("OpenWeatherApiKey");
		String url="https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&exclude=hourly,minutely&units=metric&appid="+Openapikey.getOpenapikey();
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String json = IOUtils.toString(entity.getContent());
		    JSONObject FutureDataArray = new JSONObject(json);
		    JSONArray Daily=FutureDataArray.getJSONArray("daily");
		    JSONObject Day1=Daily.getJSONObject(1);
		    long dt=Day1.getLong("dt");
		    Day1=Day1.getJSONObject("temp");
		    Day1.put("date", dt);
		    JSONObject Day2=Daily.getJSONObject(2);
		    dt=Day2.getLong("dt");
		    Day2=Day2.getJSONObject("temp");
		    Day2.put("date", dt);
		    JSONObject Day3=Daily.getJSONObject(3);
		    dt=Day3.getLong("dt");
		    Day3=Day3.getJSONObject("temp");
		    Day3.put("date", dt);
		    JSONObject Day4=Daily.getJSONObject(4);
		    dt=Day4.getLong("dt");
		    Day4=Day4.getJSONObject("temp");
		    Day4.put("date", dt);
		    JSONObject Day5=Daily.getJSONObject(5);
		    dt=Day5.getLong("dt");
		    Day5=Day5.getJSONObject("temp");
		    Day5.put("date", dt);
		    JSONObject Day6=Daily.getJSONObject(6);
		    dt=Day6.getLong("dt");
		    Day6=Day6.getJSONObject("temp");
		    Day6.put("date", dt);
		    JSONObject returnObject=new JSONObject();
		    returnObject.put("day1", Day1);
		    returnObject.put("day2", Day2);
		    returnObject.put("day3", Day3);
		    returnObject.put("day4", Day4);
		    returnObject.put("day5", Day5);
		    returnObject.put("day6", Day6);
		    System.out.println(returnObject);
		    System.out.println(returnObject);
		    return returnObject;
		}
		catch(IOException ioe) 
		{
			System.out.println("Something went wrong on getting Future Data");
//		ioe.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Unknown Error:");
//		e.printStackTrace();
		}
		return null;
	}

}
