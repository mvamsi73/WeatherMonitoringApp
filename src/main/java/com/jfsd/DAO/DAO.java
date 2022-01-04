package com.jfsd.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jfsd.BEAN.Admin;
import com.jfsd.BEAN.subscribers;

public class DAO 
{

	HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp=temp;
	}
	
//	public void insertSubscriber(subscribers sub) throws IOException
//	{
//		URL url = new URL ("http://localhost:8090/subscribers");
//		HttpURLConnection con = (HttpURLConnection)url.openConnection();
//		con.setRequestMethod("POST");
//		con.setRequestProperty("Content-Type", "application/json; utf-8");
//		con.setRequestProperty("Accept", "application/json");
//		con.setDoOutput(true);
//		String jsonInputString = "{\"email\": \""+sub.getEmail()+"\",\"user_name\": \""+sub.getUser_name()+"\",\"phone_number\":"+String.valueOf(sub.getPhone_number())+"}" ;
//		System.out.println(jsonInputString);
//		try(OutputStream os = con.getOutputStream()) {
//		    byte[] input = jsonInputString.getBytes("utf-8");
//		    os.write(input, 0, input.length);			
//		}
//		try(BufferedReader br = new BufferedReader(
//				  new InputStreamReader(con.getInputStream(), "utf-8"))) {
//				    StringBuilder response = new StringBuilder();
//				    String responseLine = null;
//				    while ((responseLine = br.readLine()) != null) {
//				        response.append(responseLine.trim());
//				    }
//				    System.out.println(response.toString());
//				}
//	}
	public void insertSubscriber(subscribers sub)
	{
		int f=0;
		List<subscribers> lst=getSubscribersData();
		for(subscribers s:lst)
		{
			if(s.getEmail().equals(sub.getEmail()))
			{
				f=1;
				break;
			}
		}
		if(f==0)
		{
		int i=(int) temp.save(sub);
		if(i>0)
		{
			String to = sub.getEmail();
		      String from = "climaweatherforecast@gmail.com";
		      Properties properties = System.getProperties();
		        properties.put("mail.smtp.starttls.enable", "true"); 
		        properties.put("mail.smtp.host", "smtp.gmail.com");
		        properties.put("mail.smtp.port", "587");
		        properties.put("mail.smtp.auth", "true");
		        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
		          protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		              return new PasswordAuthentication("climaweatherforecast@gmail.com", "hutoviqbekmrxkiv");
		          }});
		        try{
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(from));
		            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		            message.setSubject("Welcome On Board! "+sub.getUser_name());
		            message.setContent("<h1>You have Subscribed to CLIMA <br> Enjoy Receiving Weather Reports!</h1><br><a href='http://localhost:8080/unsubscribe?email="+sub.getEmail()+"'>Unsubscribe</a>","text/html" );
		            Transport.send(message);
		            System.out.println("Sent message successfully....");
		         }catch (MessagingException mex) {
		            mex.printStackTrace();
		         }
		}
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
