package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {
public static void main(String[] args) throws IOException 
{
	URL url = new URL ("http://localhost:8090/subscribers");
	HttpURLConnection con = (HttpURLConnection)url.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("Content-Type", "application/json; utf-8");
	con.setRequestProperty("Accept", "application/json");
	con.setDoOutput(true);
	String jsonInputString = "{\"email\": \"mvamsi73@gmail.com\",\"user_name\": \"Programmer\",\"phone_number\":7702437999}" ;
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
}
