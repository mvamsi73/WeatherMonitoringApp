<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<button align="center"><a href="gotosubscribe">Subscribe Here</a></button>

<h2>Search :</h2>
<form action="searchLocation" method="post">
<input type="text" name="location" placeholder="Enter Location">
<input type="submit" value="Search">
</form>

<h2>${LocationData.get("Status") }</h2>

<h1 align="center">${LocationData.get("City")} ,${LocationData.get("State")} ,${LocationData.get("Country") }</h1>

<!-- For Location Data -->

<c:set var="keys" scope="session" value="${LocationData.keys()}"/>
<c:forEach var="key" items="${keys}">
${key }:${LocationData.get(key) }<br>
</c:forEach>
<br><br>


<!-- For Weather Data -->

<c:set var="keys" scope="session" value="${WeatherData.keys()}"/>
<c:forEach var="key" items="${keys}">
${key }:${WeatherData.get(key) }<br>
</c:forEach>

<br><br>

<!-- For Additional Forecasts Data -->

<c:set var="keys" scope="session" value="${AdditionalForecasts.keys()}"/>
<c:forEach var="key" items="${keys}">
${key }:<br>
Value: ${AdditionalForecasts.get(key).get("Value") }<br>
Category: ${AdditionalForecasts.get(key).get("Category") }<br><br>
</c:forEach>

</html>