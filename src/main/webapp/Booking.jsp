<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.topnav {
  overflow: hidden;
  background-color: #333;
}


.topnav a {
  float: right;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}</style>



<body style="font-size: 25px;padding-top:0px;background-image: url(steering.jpg); height: 700px; background-repeat: no-repeat;background-size: 100% 100%;"> 
<div  style="text-decoration: none;font-size: 17px;background-color: #1DA497;">
<span style="padding-top:0px;font-size:27px;font-style: bold; font-family: "Times New Roman", Times, serif;" align="center"><center>
VEHICLE HIRING SYSTEM</center></span>
<div><center><marquee width="250px">Drive Like its your Own!!!!!!!!!</marquee></center> </div>
</div>
<div class="topnav">
 
  <a class="active" href="#" >LOGOUT</a>
  <a href="Homepage.jsp">HomePage</a>
</div>

    
	<fieldset>
	<legend><b>Short Distance(1-10Km) Fare-Rs3/km</b> </legend>
	<legend><b>Medium Distance(11-20km) Fare-Rs5/km </b></legend>
	<legend><b>Long Distance(More than 20Km) Fare-Rs7/km</b> </legend>
	<form action="BookingServlet" method="post">
	<div>
	<br>
	<center><font color=white>Vehicle_id <input type="text" name="vehicle_id" value ="${vehicleid}" readonly="readonly"><br></font></center>
	<br>
	<br>
	<center><font color=white>Pickup</font><input type="text" name="pickup" required="required"><br></center>
	<br>
	<br>
	<center><font color=white>Drop-Location</font><input type="text" name="droploc" required="required"><br></center>
	<br>
	<br>
	</div>
	
	<center><font color=white>Distance(in km)</font><input type="text" name="distance" required="required"><br></center>
	<center><input type="submit" value="Confirm Booking"></center>
	
	</form>
	</fieldset>

</body>
</html>