package com.jfsd.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jfsd.BEAN.Admin;
import com.jfsd.BEAN.subscribers;

public class DAO 
{

	HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp=temp;
	}
	
	public void insertSubscriber(subscribers sub) throws IOException
	{
		URL url = new URL ("http://localhost:8090/subscribers");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		String jsonInputString = "{\"email\": \""+sub.getEmail()+"\",\"user_name\": \""+sub.getUser_name()+"\",\"phone_number\":"+String.valueOf(sub.getPhone_number())+"}" ;
		System.out.println(jsonInputString);
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(con.getInputStream(), "utf-8"))) {
				    StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				    System.out.println(response.toString());
				}
	}
	public int deleteSubscriber(int user_id) {
	    int t=temp.bulkUpdate("delete from subscribers where user_id=?",user_id);
	    System.out.println(t);
	    return t;
	  }
	
	public int unsubscribe(String email) {
	    int t=temp.bulkUpdate("delete from subscribers where email=?",email);
	    System.out.println(t);
	    return t;
	  }
	
	public boolean validateAdminLogin(String username,String password)
	{
		List<Admin> lst= (List<Admin>)temp.find("from Admin");
		for(Admin ad:lst)
		{
			if(ad.getUsername().equals(username) && ad.getPassword().equals(password))
			{
				return true;
			}
		}
		    
		    return false;
	}
	public List<subscribers> getSubscribersData()
	{
		return (List<subscribers>)temp.find("from subscribers");
	}

}
