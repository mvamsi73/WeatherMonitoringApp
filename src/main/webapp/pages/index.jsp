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
<c:if test="${not empty LocationData}">
<c:set var="keys" scope="session" value="${LocationData.keys()}"/>
<c:forEach var="key" items="${keys}">
${key }:${LocationData.get(key) }<br>
</c:forEach>
</c:if>
</html>