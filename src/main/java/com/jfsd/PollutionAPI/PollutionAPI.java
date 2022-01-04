package com.jfsd.PollutionAPI;

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

public class PollutionAPI 
{
	public JSONObject getPollution(String latitude,String longitude)
	{
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		OpenWeatherApiKey Openapikey=(OpenWeatherApiKey) acb.getBean("OpenWeatherApiKey");
		String url="http://api.openweathermap.org/data/2.5/air_pollution?lat="+latitude+"&lon="+longitude+"&appid="+Openapikey.getOpenapikey();
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		try {
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		String json = IOUtils.toString(entity.getContent());
	    JSONObject MasterData = new JSONObject(json);
	    JSONArray pollutionArray= MasterData.getJSONArray("list");
	    JSONObject PollutionObject=pollutionArray.getJSONObject(0).getJSONObject("main");
	    int aqi=PollutionObject.getInt("aqi");
//	    System.out.println(PollutionObject);
	    JSONObject PollutionComponents=pollutionArray.getJSONObject(0).getJSONObject("components");
	    JSONObject returnData=new JSONObject();
	    
	    returnData.put("aqi", aqi);
	    returnData.put("PollutionComponents", PollutionComponents);
	    return returnData;
	    
		}
		catch(IOException ioe) 
		{System.out.println("Something went wrong on getting Pollution Details");
		ioe.printStackTrace();
		}
		catch(Exception e)
		{System.out.println("Unknown Error:");
		e.printStackTrace();
		}
		return null;
	}

}
