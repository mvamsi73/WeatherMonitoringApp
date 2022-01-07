<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
    <%@page import="org.springframework.context.ApplicationContext" %>
    <%@page import="com.jfsd.DAO.DAO" %>
    <%@page import="com.jfsd.BEAN.subscribers" %>
    <%@ page import="java.util.*" %>
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
<script type="text/javascript" src="pages/Index_Page_Styling/js/circle.js"></script>

		<!--[if lt IE 9]>
		<script src="pages/Index_Page_Styling/js/ie-support/html5.js"></script>
		<script src="pages/Index_Page_Styling/js/ie-support/respond.js"></script>
		<![endif]-->
		
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		
		<style>
*,
*:before,
*:after {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.circular-progress {
  position: relative;
  height: 250px;
  width: 250px;
  border-radius: 50%;
  display: grid;
  place-items: center;
}
.circular-progress:before {
  content: "";
  position: absolute;
  height: 84%;
  width: 84%;
  background-color: #ffffff;
  border-radius: 50%;
}
.value-container {
  position: relative;
  font-family: "Poppins", sans-serif;
  font-size: 50px;
  color: #231c3d;
}

* {
  box-sizing: border-box;
}

/* Create three unequal columns that floats next to each other */
.column {
  float: left;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

.left, .right {
  width: 33.3%;
}

.middle {
  width: 33%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

table {
border-collapse: collapse;
  width: 90%;
  border:none;
}

th {
  height: 70px;
   background-color: red;
  color: white;
}

td {
  text-align: center;
}



th, td {
  padding: 8px;
}
tr:nth-child(even){}

</style>


	</head>


	<body>

		<div class="site-content">
			<div class="site-header">
				<div class="container">
					<a href="#" class="branding">
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
							
							<li class="menu-item current-menu-item""><a href="/logout">LogOut</a></li>
						</ul> <!-- .menu -->
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>

				</div>
			</div> <!-- .site-header -->

			<div class="hero" data-bg-image="pages/Index_Page_Styling/images/banner.png">
				<div class="container">
					

				</div>
			</div>
			<div class="forecast-table">
				<div class="container">
					<div class="forecast-container">
						<div class="today forecast">
				<div class="forecast-header">
					<h2>Admin DashBoard</h2>
				</div> <!-- .forecast-header -->
							<div class="forecast-content">
				<div class="row">
  <div class="column left">
    <div class="container">
     <table align='center' cellspacing="0" cellpadding="0">
<tr><td><h3>User ID</h3></td><td><h3>Email</h3></td><td><h3>Phone Number</h3></td><td><h3>Delete</h3></td></tr>
<%
ApplicationContext acb=new ClassPathXmlApplicationContext("spring.xml");
DAO dao=(DAO) acb.getBean("DAO");
List<subscribers> lst=dao.getSubscribersData();
for(subscribers sub:lst)
{
%>

<tr><td><%=sub.getUser_id() %></td><td><%=sub.getEmail() %></td><td><%=sub.getPhone_number() %></td><td><a  href="/deleteSubscriber?user_id=<%=sub.getUser_id() %>"><button class="w3-button w3-blue w3-hover-red w3-round-xxlarge">Delete</button>
</a></td></tr>

<%} %>
</table>
	

    </div>

  </div>
   
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

					<p class="colophon">Copyright 2022 Clima. Designed by SDP128. All rights reserved</p>
				</div>
			</footer> <!-- .site-footer -->


		<script src="pages/Index_Page_Styling/js/jquery-1.11.1.min.js"></script>
		<script src="pages/Index_Page_Styling/js/plugins.js"></script>
		<script src="pages/Index_Page_Styling/js/app.js"></script>
		</div>
	</body>

</html>