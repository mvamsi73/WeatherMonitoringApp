<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Clima Weather forcast</title>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="pages/Index_Page_Styling/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="pages/Index_Page_Styling/style.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		
		<!--[if lt IE 9]>
		<script src ="pages/Index_Page_Styling/js/ie-support/html5.js"></script>
		<script src="pages/Index_Page_Styling/js/ie-support/respond.js"></script>
		<![endif]-->

	</head>


	<body>
		
		<div class="site-content">
			<div class="site-header">
				<div class="container">
					<a href="/" class="branding">
						<img src="pages/Index_Page_Styling/images/logo.png" alt="" class="logo">
						<div class="logo-type">
							<h1 class="site-title">Clima</h1>
							<small class="site-description">A change in the weather is sufficient to recreate the world and ourselves.</small>
						</div>
					</a>

					<!-- Default snippet for navigation -->
					<div class="main-navigation">
						<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
						<ul class="menu">
							<li class="menu-item current-menu-item"><a href="/">Home</a></li>
							<li class="menu-item"><a href="news.html">Maps</a></li>
							<li class="menu-item"><a href="/gotopollution">Air Pollution</a></li>
							<li class="menu-item"><a href="/gotosubscribe">Subcribe</a></li>
						</ul> <!-- .menu -->
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>

				</div>
			</div> <!-- .site-header -->

			<div class="hero" data-bg-image="pages/Index_Page_Styling/images/banner.png">
				<div class="container">
					<form action="searchLocation" method="post" class="find-location">
					<input type="text" name="location" placeholder="Enter Location">
					<input type="submit" value="Search">
					</form>
				</div>
			</div>
			<div class="forecast-table">
				<div class="container">
					<div class="forecast-container">
						<div class="today forecast">
							<div class="forecast-header">
								<div class="day" id="weekday">Monday</div>
								<div class="date" id="date-month">6 Oct</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="location"><h1 align="center">${LocationData.get("City")}, ${LocationData.get("State")}, ${LocationData.get("Country") }</h1></div>
								<div class="degree">
								
								<c:set var="Temp" value="${WeatherData.get(\"Temperature\").get(\"current\") - 273.15}"/>  
								
									<div class="num"><fmt:formatNumber type="number" maxFractionDigits="0" value="${Temp}" /><sup>o</sup>C</div>
									<div class="forecast-icon">
										<img src="pages/Index_Page_Styling/images/icons/icon-1.svg" alt="" width=90>
									</div>	
								</div>
								<c:set var="Min_Temp" value="${WeatherData.get(\"Temperature\").get(\"Minimum_Temp\") - 273.15}"/> 
								<c:set var="Max_Temp" value="${WeatherData.get(\"Temperature\").get(\"Maximum_Temp\") - 273.15}"/> 
								<span>Minimum  Temp : <fmt:formatNumber type="number" maxFractionDigits="0" value="${Min_Temp}" /><sup>o</sup>C  </span>
								<span>Maximum  Temp : <fmt:formatNumber type="number" maxFractionDigits="0" value="${Max_Temp}" /><sup>o</sup>C  </span><p></p>
								<span><img src="pages/Index_Page_Styling/images/icon-wind.png" alt=""> ${WeatherData.get("Wind").get("speed") * 3.6 } Km/h</span>
								<span><img src="pages/Index_Page_Styling/images/icon-compass.png" alt="">Wind ${WeatherData.get("Wind").get("degree")} Degrees</span>
							</div>
						</div>
						<div class="forecast">
							<div class="forecast-header">
								<div class="day">Tuesday</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="forecast-icon">
									<img src="pages/Index_Page_Styling/images/icons/icon-3.svg" alt="" width=48>
								</div>
								<div class="degree">23<sup>o</sup>C</div>
								<small>18<sup>o</sup></small>
							</div>
						</div>
						<div class="forecast">
							<div class="forecast-header">
								<div class="day">Wednesday</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="forecast-icon">
									<img src="pages/Index_Page_Styling/images/icons/icon-5.svg" alt="" width=48>
								</div>
								<div class="degree">23<sup>o</sup>C</div>
								<small>18<sup>o</sup></small>
							</div>
						</div>
						<div class="forecast">
							<div class="forecast-header">
								<div class="day">Thursday</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="forecast-icon">
									<img src="pages/Index_Page_Styling/images/icons/icon-7.svg" alt="" width=48>
								</div>
								<div class="degree">23<sup>o</sup>C</div>
								<small>18<sup>o</sup></small>
							</div>
						</div>
						<div class="forecast">
							<div class="forecast-header">
								<div class="day">Friday</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="forecast-icon">
									<img src="pages/Index_Page_Styling/images/icons/icon-12.svg" alt="" width=48>
								</div>
								<div class="degree">23<sup>o</sup>C</div>
								<small>18<sup>o</sup></small>
							</div>
						</div>
						<div class="forecast">
							<div class="forecast-header">
								<div class="day">Saturday</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="forecast-icon">
									<img src="pages/Index_Page_Styling/images/icons/icon-13.svg" alt="" width=48>
								</div>
								<div class="degree">23<sup>o</sup>C</div>
								<small>18<sup>o</sup></small>
							</div>
						</div>
						<div class="forecast">
							<div class="forecast-header">
								<div class="day">Sunday</div>
							</div> <!-- .forecast-header -->
							<div class="forecast-content">
								<div class="forecast-icon">
									<img src="pages/Index_Page_Styling/images/icons/icon-14.svg" alt="" width=48>
								</div>
								<div class="degree">23<sup>o</sup>C</div>
								<small>18<sup>o</sup></small>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
			<div class="forecast-table" style="padding:80px;">
				<div class="container">
					<div class="forecast-container">
						<div class="today forecast">
							<div class="forecast-header">

							</div> <!-- .forecast-header -->
							<div class="forecast-content">
							<div class="w3-container">
							  <h3>Flight Delays</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="flight" class="w3-container w3-red w3-round-xlarge" style="height:24px;width:0"></div>
							  </div>
							  <br>
							</div>	
							
							<div class="w3-container">
							  <h3>Jogging</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="jog" class="w3-container w3-blue w3-round-xlarge" style="height:24px;width:0"></div>
							  </div>
							  <br>
							</div>	
							<div class="w3-container">
							  <h3>Bicycling</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="bic" class="w3-container w3-green w3-round-xlarge" style="height:24px;width:0"></div>
							  </div>
							  <br>
							</div>	
							
							<div class="w3-container">
							  <h3>Beach</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="beach" class="w3-container w3-yellow w3-round-xlarge" style="height:24px;width:0"></div>
							  </div>
							  <br>
							</div>	
							
							<div class="w3-container">
							  <h3>Fishing</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="fish" class="w3-container w3-purple w3-round-xlarge" style="height:20px;width:0"></div>
							  </div>
							  <br>
							</div>	
							
							<div class="w3-container">
							  <h3>Construction</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="con" class="w3-container w3-pink w3-round-xlarge" style="height:20px;width:0"></div>
							  </div>
							  <br>
							</div>	
							
							<div class="w3-container">
							  <h3>Asthama</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="asth" class="w3-container w3-orange w3-round-xlarge" style="height:20px;width:0"></div>
							  </div>
							  <br>
							</div>		
							
							<div class="w3-container">
							  <h3>Driving Conditions</h3>
							  <div class="w3-light-grey w3-round-xlarge">
							    <div id="drive" class="w3-container w3-light-green w3-round-xlarge" style="height:20px;width:0"></div>
							  </div>
							  <br>
							</div>							
								
							</div>
						</div>
					</div>
				</div>
			</div>
				
		
			


			<footer class="site-footer">
				<div class="container">
					<div class="row">
						
						<div class="col-md-3 col-md-offset-1">
							<div class="social-links">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-google-plus"></i></a>
								<a href="#"><i class="fa fa-pinterest"></i></a>
							</div>
						</div>
					</div>

					<p class="colophon" align="center">Copyright 2022 Clima. Designed by SDP128. All rights reserved</p>
				</div>
			</footer> <!-- .site-footer -->
		</div>
		
		<script>
		function displayDate() {
            var today = new Date();
            var dd = today.getDate();
            var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Spet", "Oct", "Nov", "Dec"];
            var month = months[today.getMonth()];
            var weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
            var weekday = weekdays[today.getDay()];

            var yyyy = today.getFullYear();
            var h = today.getHours();
            var m = today.getMinutes();
            var s = today.getSeconds();
            m = checkTime(m);
            var ampm = h >= 12 ? 'PM' : 'AM';
            h = h % 12;
            h = h ? h : 12;
            h = checkTime(h);
            s = checkTime(s);
            document.getElementById('weekday').innerHTML = weekday;
            document.getElementById('date-month').innerHTML = dd + ' ' +month;
        }
        function checkTime(i) {
            if (i < 10) {i = "0" + i};
            return i;
        }
        function progress(v,kd){
        	 var elem = document.getElementById(kd);   
        	  var width = 1;
        	  var id = setInterval(frame, 10);
        	  function frame() {
        	    if (width >=v ) {
        	      clearInterval(id);
        	    } else {
        	      width++; 
        	      elem.style.width = width + '%'; 
        	    }
        	  }
        }
        displayDate();
        progress(50,"flight");
        progress(30,"jog");
        progress(40,"bic");
        progress(50,"beach");
        progress(60,"fish");
        progress(70,"con");
        progress(80,"asth");
        progress(90,"drive");
		</script>
		
		
		<script src="pages/Index_Page_Styling/js/jquery-1.11.1.min.js"></script>
		<script src="pages/Index_Page_Styling/js/plugins.js"></script>
		<script src="pages/Index_Page_Styling/js/app.js"></script>
		
	</body>

</html>