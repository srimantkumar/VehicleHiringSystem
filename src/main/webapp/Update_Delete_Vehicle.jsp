<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>choose vehicle</title>
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
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}


.topnav a.active {
  background-color: #4CAF50;
  color: white;
}</style>
<body style="font-size: 25px;padding-top:0px;background-image: url(bike.jpg);  height: 700px; background-repeat: no-repeat;background-size: 100% 100%;"> 
<div  style="text-decoration: none;font-size: 17px;background-color: #1DA497;">
<span style="padding-top:0px;font-size:27px;font-style: bold; font-family: "Times New Roman", Times, serif;" align="center"><center>
VEHICLE HIRING SYSTEM</center></span>
<div><center><marquee width="250px">Drive Like its your Own!!!!!!!!!</marquee></center> </div>
</div>
<div class="topnav">
 
  <a class="active" href="#" >LOGOUT</a>
  <a href="Homepage.jsp">HomePage</a>
  <a href="AdminMenu.jsp">Menu</a>
</div>
<divstyle="font-size: 25px;padding-top:0px;background-image: url(bike.jpg); height: 700px; background-repeat: no-repeat;background-size: 100% 100%;">
<center>
	<b><center><h1 style="color: white"><u>VEHICLES AVAILABLE</u></h1></center><b>
	
	
	<form action="Hiring.jsp" >
	<font color=white><table style="color: white    " border="2">
	<tr><th>Vehicle_id<th>No_of_seats <th>No_of_vehicles</th><th colspan=>ACTION</th></tr>
	<c:forEach var ="vehicle" items ="${requestScope.vehiclelist}">
	<tr>
	<td><c:out value="${vehicle.vehicleid}"></c:out></td>
	<td><c:out value="${vehicle.noOfSeats}"></c:out></td>
	<td><c:out value="${vehicle.noOfVehicle}"></c:out></td>
	
	<td><a  style="color:white" href="Delete_VehicleServlet?vehicleid=${vehicle.vehicleid}">DELETE</a></td>
	
	</tr>
</c:forEach>
</table>
</font>
<br>
<br>
<br>
<center><a href="Add_Vehicle.jsp" class="button">CLICK HERE TO ADD A VEHICLE </a></center>
	
</form>
</center>
</div>
</body>
</html>