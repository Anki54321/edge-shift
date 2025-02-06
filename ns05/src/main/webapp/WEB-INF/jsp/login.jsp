	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="../css/style.css" rel="stylesheet" media="all">
		<link href="../css/style.css.map" rel="stylesheet" media="all">
		<link href="../css/style.scss" rel="stylesheet" media="all">
		<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="all">

	</head>

	<body>
<h1 style="text-align: center;"></h1>
		<div class="wrapper">
			
			<div class="inner">
			<img src="../images/network.png" alt="" class="image-1"> 
				<form action="loginsubmit" method="post">
					<h3>Login</h3>
					<h2 class="title" style="color: red;">${info}</h2>
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" class="form-control" placeholder="Mail" name="emailid">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" class="form-control" placeholder="Password" name="password">
					</div>
				
					<div>
					<center><input type="submit" value="Login" class="btn btn-primary"></center><br/><br/>
					<center><a href="registerForm">Register</a></center>
					</div>
				</form>
				
				<img src="assets/images/image-2.png" alt="" class="image-2">
			</div>
			
		</div>
		
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>