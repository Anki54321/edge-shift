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
			<img src="assets/images/network.png" alt="" class="image-1"> 

			<c:choose>
				<c:when test="${info!=null}">
					${info}
					<br />
				</c:when>    
				<c:otherwise>
					<form action="register" method="post">
						<h3>Register</h3>
						<div class="form-holder">
							<span class="lnr lnr-user"></span>
							<input type="text" class="form-control" placeholder="Username" name="name">
						</div>
						<div class="form-holder">
							<span class="lnr lnr-phone-handset"></span>
							<input type="text" class="form-control" placeholder="Phone Number" name="mobile">
						</div>
						<div class="form-holder">
							<span class="lnr lnr-envelope"></span>
							<input type="text" class="form-control" placeholder="Mail" name="emailid">
						</div>
						<div class="form-holder">
							<span class="lnr lnr-lock"></span>
							<input type="password" class="form-control" placeholder="Password" name="password">
						</div>
					
						<center><input type="submit" value="register" class="btn btn-primary"/></center>
					</form>
				</c:otherwise>
			</c:choose>
				
				<img src="assets/images/image-2.png" alt="" class="image-2">
			</div>
			
		</div>
		
		<script src="../js/jquery-3.3.1.min.js"></script>
		<script src="../js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>