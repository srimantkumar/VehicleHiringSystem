
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

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}</style>
<body style="font-size: 25px;padding-top:0px;background-image: url(back.jpg);  height: 700px; background-repeat: no-repeat;background-size: 100% 100%;"> 
<div  style="text-decoration: none;font-size: 17px;background-color: #1DA497;">
<span style="padding-top:0px;font-size:27px;font-style: bold; font-family: "Times New Roman", Times, serif;" align="center"><center>
VEHICLE HIRING SYSTEM</center></span>
<div><center><marquee width="250px">Drive Like its your Own!!!!!!!!!</marquee></center> </div>
</div>
<div class="topnav">
 
  <a class="active" href="#" >LOGOUT</a>
  <a href="Homepage.jsp">HomePage</a>
</div>
	<b><center><h1><u>UPDATE OR DELETE YOUR VEHICLE TYPE</u></h1></center><b>
	<form action="Hiring.jsp" >
	<font color=white><table border="2">
	<tr><th>Vehicle_id<th>No_of_seats <th>No_of_vehicles</th><th colspan=2>ACTION</th></tr>
	<c:forEach var ="vehicle" items ="${vehicle}">
	<tr>
	<td><c:out value="${vehicle.id}"></c:out></td>
	<td><c:out value="${vehicle.nos}"></c:out></td>
	<td><c:out value="${vehicle.nov}"></c:out></td>
	<td><a href="UpdateVehicle">UPDATE</a></td>
	<td><a href="DeleteVehicle">DELETE</a></td>
	
	</tr>
</c:forEach>
</table>
</font>
	
	</form>
</body>
</html>