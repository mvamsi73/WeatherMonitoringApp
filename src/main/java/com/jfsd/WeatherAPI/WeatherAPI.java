package com.jfsd.WeatherAPI;

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

public class WeatherAPI 
{
	public JSONObject getWeatherData(String latitude,String longitude)
	{
		
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		OpenWeatherApiKey Openapikey=(OpenWeatherApiKey) acb.getBean("OpenWeatherApiKey");
		String url="http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid="+Openapikey.getOpenapikey();
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String json = IOUtils.toString(entity.getContent());
		    JSONObject MasterData = new JSONObject(json);
		    JSONArray weather=MasterData.getJSONArray("weather");
		    JSONObject WeatherObject=weather.getJSONObject(0);
		    JSONObject Climate=new JSONObject();
		    Climate.put("climate", WeatherObject.get("main"));
		    Climate.put("description", WeatherObject.get("description"));
		    JSONObject TemperatureObject=MasterData.getJSONObject("main");
		    JSONObject Temperature=new JSONObject();
		    Temperature.put("current", TemperatureObject.get("temp"));
		    Temperature.put("Minimum_Temp", TemperatureObject.get("temp_min"));
		    Temperature.put("Maximum_Temp", TemperatureObject.get("temp_max"));
		    Temperature.put("humidity", TemperatureObject.get("humidity"));
		    JSONObject WindObject=MasterData.getJSONObject("wind");
		    JSONObject Wind=new JSONObject();
		    Wind.put("speed", WindObject.get("speed"));
		    Wind.put("degree", WindObject.get("deg"));
		    JSONObject returnObject=new JSONObject();
		    returnObject.put("Climate", Climate);
		    returnObject.put("Temperature",Temperature);
		    returnObject.put("Wind", Wind);
		    return returnObject;
		}
		catch(IOException ioe) 
		{System.out.println("Something went wrong on getting Weather");
		ioe.printStackTrace();
		}
		catch(Exception e)
		{System.out.println("Unknown Error:");
		e.printStackTrace();
		}
		return null;
	}

}
