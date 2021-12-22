package com.jfsd.WeatherAPI;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfsd.BEAN.ApiKey;

public class WeatherAPI 
{
	public JSONObject getWeatherData(String locationkey)
	{
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		ApiKey apikey=(ApiKey) acb.getBean("ApiKey");
		String url="http://dataservice.accuweather.com/currentconditions/v1/"+locationkey+"?apikey="+apikey.getApikey();
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String json = IOUtils.toString(entity.getContent());
		    JSONArray WeatherArray = new JSONArray(json);
		    JSONObject WeatherObject = WeatherArray.getJSONObject(0);
		    JSONObject WeatherData=new JSONObject();
		    WeatherData.put("WeatherStatus", WeatherObject.get("WeatherText"));
		    WeatherData.put("IsDayTime",WeatherObject.get("IsDayTime") );
		    WeatherData.put("Temperature_Celcius",WeatherObject.getJSONObject("Temperature").getJSONObject("Metric").get("Value"));
		    return WeatherData;
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
