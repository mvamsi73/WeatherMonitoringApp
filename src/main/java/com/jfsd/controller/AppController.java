package com.jfsd.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfsd.AdditionalForecastsAPI.AdditionalForecastsAPI;
import com.jfsd.BEAN.subscriber;
import com.jfsd.DAO.DAO;
import com.jfsd.LocationAPI.LocationAPI;
import com.jfsd.WeatherAPI.WeatherAPI;
@Controller
public class AppController 
{
	@RequestMapping("/")
	public String getIndex()
	{
		return "index";
	}
	@RequestMapping("/gotosubscribe")
	String gotoSubscribe()
	{
		return "subscribe";
	}
	@RequestMapping("/subscribe")
	String Subscribe(Model model, @RequestParam(value="email") String email,@RequestParam(value="phone") long phone)
	{
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		DAO dao=(DAO) acb.getBean("DAO");
		subscriber sub=(subscriber) acb.getBean("sub");
		sub.setEmail(email);
		sub.setPhone_number(phone);
		dao.insertSubscriber(sub);
		return "index";
	}
	@RequestMapping("/searchLocation")
	String Search(Model model,@RequestParam(value="location") String Location) throws JSONException
	{
		Location=Location.replace(" ", "%20");
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		LocationAPI LocationAPI=(LocationAPI) acb.getBean("LocationAPI");
		JSONObject LocationData=LocationAPI.getLocationData(Location);
		WeatherAPI WeatherAPI=(WeatherAPI) acb.getBean("WeatherAPI");
		JSONObject WeatherData=WeatherAPI.getWeatherData(String.valueOf(LocationData.get("Key")));
		AdditionalForecastsAPI addiForeAPI=(AdditionalForecastsAPI) acb.getBean("AdditionalForecastsAPI");
		JSONObject ForecastsData=addiForeAPI.getAdditionalForecastsData(String.valueOf(LocationData.get("Key")));
		model.addAttribute("LocationData",LocationData);
		model.addAttribute("WeatherData",WeatherData);
		model.addAttribute("AdditionalForecasts",ForecastsData);
		return "index";
		
	}
	
	
}
