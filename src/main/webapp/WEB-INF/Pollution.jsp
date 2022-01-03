<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.springframework.boot.configurationprocessor.json.JSONObject" %>
    <%@ page import ="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pollution</title>
</head>
<body>
<%
try{
Object param = request.getAttribute("PollutionData");
String jsonInString = new Gson().toJson(param);
JSONObject PollutionData = new JSONObject(jsonInString);
PollutionData=PollutionData.getJSONObject("nameValuePairs");
System.out.println(PollutionData);
int aqi=PollutionData.getInt("aqi");
JSONObject PollutionComponents=PollutionData.getJSONObject("PollutionComponents");
PollutionComponents = PollutionComponents.getJSONObject("nameValuePairs");
%>
<h1>Get Pollution Details Now</h1>
<h2>Search :</h2>
<form action="getPollution" method="post">
<input type="text" name="location" placeholder="Enter Location">
<input type="submit" value="Search">
</form>

<h2>${LocationData.get("Status") }</h2>
<h1 align="center">${LocationData.get("City")} ,${LocationData.get("State")} ,${LocationData.get("Country") }</h1>
<table align="center" border="1.0">
<tr>
<td>Air Quality Index</td>
<td>Pollution Status</td>
<td>co</td>
<td>no</td>
<td>no2</td>
<td>o3</td>
<td>so2</td>
<td>pm2_5</td>
<td>pm10</td>
<td>nh3</td>
</tr>
<tr>
<td><%=aqi %></td>
<% if(aqi==1){ %>
<td>Very Poor</td>
<%}
else if(aqi==2)
{
%>
<td>Poor</td>
<%}
else if(aqi==3)
{
%>
<td>Moderate</td>
<%} 
else if(aqi==4)
{
%>
<td>Fair</td>
<%}
else{
%>
<td>Very High</td>
<%} %>
<td><%=PollutionComponents.get("co") %></td>
<td><%=PollutionComponents.get("no") %></td>
<td><%=PollutionComponents.get("no2") %></td>
<td><%=PollutionComponents.get("o3") %></td>
<td><%=PollutionComponents.get("so2") %></td>
<td><%=PollutionComponents.get("pm2_5") %></td>
<td><%=PollutionComponents.get("pm10") %></td>
<td><%=PollutionComponents.get("nh3") %></td>
</tr>
</table>
<%}
catch(Exception e){
	System.out.println(e);
	%>
	
	<h1>Get Pollution Details Now</h1>
	<h2>Search :</h2>
<form action="getPollution" method="post">
<input type="text" name="location" placeholder="Enter Location">
<input type="submit" value="Search">
</form>
<%
}
%>
</body>
</html>