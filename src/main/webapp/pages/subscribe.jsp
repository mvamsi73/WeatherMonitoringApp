<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Subscribe Here</title>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
		<link href="pages/Index_Page_Styling/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="pages/Index_Page_Styling/style.css">
		
		<!--[if lt IE 9]>
		<script src="js/ie-support/html5.js"></script>
		<script src="js/ie-support/respond.js"></script>	
		<![endif]-->
<style>

	div.fullwidth-block {
  	margin: auto;

}

</style>
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
							<li class="menu-item"><a href="/">Home</a></li>
							<li class="menu-item"><a href="/gotoMaps">Maps</a></li>
							<li class="menu-item"><a href="gotopollution">Air Pollution</a></li>
							<li class="menu-item current-menu-item"><a href="/gotosubscribe">Subscribe</a></li>
															<li class="menu-item "><a href="/gotocontactus">Contact Us</a></li>
							
						</ul> <!-- .menu -->
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>

				</div>
			</div> <!-- .site-header -->

			<main class="main-content" >
				<div class="container">
					<div class="breadcrumb">
						<a href="/">Home</a>
						<span>Subscribe</span>
					</div>
				</div>

				<div class="fullwidth-block">
					<div class="container" >
						<div class="col-md-6 col-md-offset-1">
							<h2 class="section-title">Subscribe</h2>
							<p>A change in the weather is sufficient to recreate the world and ourselves.</p>
							<form action="subscribe" method="post" class="contact-form">
								<div class="row">
									<div class="col-md-6"><input type="text" name="username" placeholder="Your name..."></div>
								</div>
								<div class="row">
									<div class="col-md-6"><input type="text" name="email" placeholder="Enter Your Email"></div>
								</div>
								<div class="row">
									<div class="col-md-6"><input type="text" name="phone" placeholder="Enter Your Phone Number"></div>
								</div>

								<div class="row">
									<input type="submit" placeholder="Send message">
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

					<p class="colophon">Copyright 2022 Clima. Designed by SDP128. All rights reserved</p>
				</div>
			</footer> <!-- .site-footer -->
		</div>
		
		<script src="pages/Index_Page_Styling/js/jquery-1.11.1.min.js"></script>
		<script type="pages/Index_Page_Styling/text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
		<script src="pages/Index_Page_Styling/js/plugins.js"></script>
		<script src="pages/Index_Page_Styling/js/app.js"></script>
		
	</body>

</html>