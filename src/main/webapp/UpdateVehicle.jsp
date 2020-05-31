
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
  color: black;
}</style>


<body>
<form action=""> 
vehicleId<input type="text" name="vehicleId"  value="${vehicle.vehicleid}"><br>
noOfSeats<input type="text" name="noOfSeats" value="${vehicle.noOfSeats}"><br>
noOfVehicles<input type="text" name="noOfVehicles" value="${vehicle.noOfVehicles}"><br>

<input type="Submit" values="Update">
<a href=    >
</a>
</form>
</body>
</html>