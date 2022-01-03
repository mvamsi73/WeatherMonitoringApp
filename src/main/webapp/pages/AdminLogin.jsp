<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>

<title>Admin Login</title>

<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="pages/Index_Page_Styling/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="pages/Index_Page_Styling/style.css">
		
		<!--[if lt IE 9]>
		<script src="pages/Index_Page_Styling/js/ie-support/html5.js"></script>
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
				
							
		
						</ul> <!-- .menu -->
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>

				</div>
			</div> <!-- .site-header -->

			<main class="main-content" >
				<div class="container">
					<div class="breadcrumb">
						<a href="/">Home</a>
						<span>Admin LogIn</span>
					</div>
				</div>

				<div class="fullwidth-block">
					<div class="container" >
						<div class="col-md-6 col-md-offset-1">
							<h2 class="section-title">Admin Login</h2>
							<p>A change in the weather is sufficient to recreate the world and ourselves.</p>
							<c:if test="${not empty logOutMessage }"><p style="color:green;">${logOutMessage }</p></c:if>
							<c:if test="${not empty failMessage }"><p style="color:red;">Login Credentials Not Matched</p></c:if>
							<form action="/adminlogin" method="post" class="contact-form">
								
								<div class="row">
									<div class="col-md-6"><input type="text" name="username" placeholder="User Name" required></div>
					
								</div>
								<div class="row">
									<div class="col-md-6"><input type="password" name="password" placeholder="Password" required></div>
								</div>

								<div class="row">
									<input type="submit" value="LogIn">
								</div>
							</form>

						</div>
					</div>
				</div>
				
			</main> <!-- .main-content -->

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

					<p class="colophon">Copyright 2014 Company name. Designed by Themezy. All rights reserved</p>
				</div>
			</footer> <!-- .site-footer -->
		</div>
		
		<script src="pages/Index_Page_Styling/js/jquery-1.11.1.min.js"></script>
		<script type="pages/Index_Page_Styling/text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
		<script src="pages/Index_Page_Styling/js/plugins.js"></script>
		<script src="pages/Index_Page_Styling/js/app.js"></script>

</body>
</html>