package com.jfsd.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.AdditionalForecastsAPI.AdditionalForecastsAPI;
import com.jfsd.BEAN.subscribers;
import com.jfsd.DAO.DAO;
import com.jfsd.FutureDataAPI.FutureDataAPI;
import com.jfsd.LocationAPI.LocationAPI;
import com.jfsd.PollutionAPI.PollutionAPI;
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
	@RequestMapping("/gotopollution")
	String gotoPollution(Model model) throws JSONException
	{
		JSONObject pollution=new JSONObject();
		pollution.put("co", 0);
		pollution.put("no",0);
		pollution.put("no2",0);
		pollution.put("o3",0);
		pollution.put("so2",0);
		pollution.put("pm2_5",0);
		pollution.put("pm10",0);
		pollution.put("nh3",0);
		JSONObject PollutionComponents=new JSONObject();
		PollutionComponents.put("PollutionComponents", pollution);
		model.addAttribute("aqi", 0);
		model.addAttribute("PollutionData",PollutionComponents);
		return "Pollution";
	}
	@RequestMapping("/gotoMaps")
	String getMaps() throws JSONException
	{
		return "maps";
	}
	@RequestMapping("/subscribe")
	String Subscribe(Model model,@RequestParam(value="username") String username, @RequestParam(value="email") String email,@RequestParam(value="phone") long phone) throws IOException
	{
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		DAO dao=(DAO) acb.getBean("DAO");
		subscribers sub=(subscribers) acb.getBean("sub");
		sub.setEmail(email);
		sub.setUser_name(username);
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
		if(String.valueOf(LocationData.get("Status")).equals("Location Found"))
		{
		WeatherAPI WeatherAPI=(WeatherAPI) acb.getBean("WeatherAPI");
		JSONObject WeatherData=WeatherAPI.getWeatherData(String.valueOf(LocationData.get("Latitude")),String.valueOf(LocationData.get("Longitude")));
		AdditionalForecastsAPI addiForeAPI=(AdditionalForecastsAPI) acb.getBean("AdditionalForecastsAPI");
		JSONObject ForecastsData=addiForeAPI.getAdditionalForecastsData(String.valueOf(LocationData.get("Key")));
		FutureDataAPI FutureDataAPI=(com.jfsd.FutureDataAPI.FutureDataAPI) acb.getBean("FutureDataAPI");
		JSONObject FutureData=FutureDataAPI.getFutureData(String.valueOf(LocationData.get("Latitude")),String.valueOf(LocationData.get("Longitude")));
		model.addAttribute("FutureData",FutureData);
		model.addAttribute("LocationData",LocationData);
		model.addAttribute("WeatherData",WeatherData);
		model.addAttribute("AdditionalForecasts",ForecastsData);
		}
		else
		{
			model.addAttribute("LocationData",LocationData);
			System.out.println("Location Not Found");
		}
		return "index";
	}
	@RequestMapping("/getPollution")
	String Pollution(Model model,@RequestParam(value="location") String Location) throws JSONException
	{
		Location=Location.replace(" ", "%20");
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		LocationAPI LocationAPI=(LocationAPI) acb.getBean("LocationAPI");
		JSONObject LocationData=LocationAPI.getLocationData(Location);
		if(String.valueOf(LocationData.get("Status")).equals("Location Found"))
		{
			PollutionAPI PollutionAPI=(PollutionAPI) acb.getBean("PollutionAPI");
			JSONObject PollutionData=PollutionAPI.getPollution(LocationData.getString("Latitude"),LocationData.getString("Longitude"));
			model.addAttribute("LocationData",LocationData);
			model.addAttribute("PollutionData",PollutionData);
			System.out.println(PollutionData);
		}
		else
		{
			model.addAttribute("LocationData",LocationData);
			System.out.println("Location Not Found");
		}
		return "Pollution";
	}
	@RequestMapping("/getMapLocation")
	String getMap(Model model,@RequestParam(value="location") String Location) throws JSONException
	{
		JSONObject Cords=new JSONObject();
		Location=Location.replace(" ", "%20");
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
		LocationAPI LocationAPI=(LocationAPI) acb.getBean("LocationAPI");
		JSONObject LocationData=LocationAPI.getLocationData(Location);
		Cords.put("lat", LocationData.get("Latitude"));
		Cords.put("lon", LocationData.get("Longitude"));
		Cords.put("location", LocationData.get("City"));
		model.addAttribute("Cords",Cords);
		return "maps";
	}
	@RequestMapping("/deleteSubscriber")
	  String deleteSubscriber(Model model, @RequestParam(value="user_id") int user_id) {
	    ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
	    DAO dao=(DAO) acb.getBean("DAO");
	    int i=dao.deleteSubscriber(user_id);	
	    return "AdminHome";
	  }
	@RequestMapping("/unsubscribe")
	@ResponseBody
	  String Unsubscribe(Model model, @RequestParam(value="email") String email) {
	    ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
	    DAO dao=(DAO) acb.getBean("DAO");
	    int i=dao.unsubscribe(email);	
	    if(i>0)
	    {
	    	return "Unsubscribed Successfully";
	    }

	    return "No User Found";
	  }
	@RequestMapping("/gotoAdminLogin")
	String gotoAdminLogin()
	{
		return "AdminLogin";
	}
	@RequestMapping("/adminlogin")
	String ValidateLogin(Model model, @RequestParam(value="username") String username,  @RequestParam(value="password") String password,HttpSession session)
	{
		ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
	    DAO dao=(DAO) acb.getBean("DAO");
	    if(dao.validateAdminLogin(username, password))
	    {
	    	session.setAttribute("username", username);
	    	return "AdminHome";
	    }
	    model.addAttribute("failMessage","Login Credentials Not Matched");
	    return "AdminLogin";
	}
	@RequestMapping("/logout")
	String LogOut(Model model,HttpSession session)
	{
		session.removeAttribute("username");
		model.addAttribute("logOutMessage","Logged-Out Successfully");
		return "AdminLogin";
	}
	@RequestMapping("/gotocontactus")
	String ContactUs()
	{
		
		return "ContactUs";
	}
	
}
