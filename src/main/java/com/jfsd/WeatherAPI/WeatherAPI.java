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
		String url="http://dataservice.accuweather.com/forecasts/v1/daily/1day/"+locationkey+"?apikey="+apikey.getApikey();
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String json = IOUtils.toString(entity.getContent());
		    JSONObject WeatherObject = new JSONObject(json);
		    JSONObject HeadLine=WeatherObject.getJSONObject("Headline");
		    JSONArray DailyForecasts=WeatherObject.getJSONArray("DailyForecasts");
		    JSONObject Temperature=DailyForecasts.getJSONObject(0).getJSONObject("Temperature");
		    JSONObject DayStatus=DailyForecasts.getJSONObject(0).getJSONObject("Day");
		    JSONObject NightStatus=DailyForecasts.getJSONObject(0).getJSONObject("Night");
		    JSONObject WeatherData=new JSONObject();
		    WeatherData.put("HeadLine", HeadLine);
		    WeatherData.put("Temperature",Temperature);
		    WeatherData.put("DayStatus", DayStatus);
		    WeatherData.put("NightStatus", NightStatus);
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
