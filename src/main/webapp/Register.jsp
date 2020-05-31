<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
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

<body style="font-size: 25px;padding-top:0px;background-image: url(hector.jpg); height: 700px; background-repeat: no-repeat;background-size: 100% 100%;"> 
<div  style="text-decoration: none;font-size: 17px;background-color: #1DA497;">
<span style="padding-top:0px;font-size:27px;font-style: bold; font-family: "Times New Roman", Times, serif;" align="center"><center>
VEHICLE HIRING SYSTEM</center></span>
<div><center><marquee width="250px">Drive Like its your Own!!!!!!!!!</marquee></center> </div>
</div>
<div class="topnav">
 
  <a class="active" href="#" >Register</a>
  <a  href="Login.jsp" >Login</a>
  <a href="Homepage.jsp">HomePage</a>
</div>

<center><h1>Register</h1></center>
<center>
<div >
<form action="RegisterServlet" method="post">

	<font color=white><b>Name </b><input align="middle" type="text" name="name" required="required" /><br></font>
	<br>
	<br>
	<font color=white><b>Password </b>   <input align="middle" type="password" name="password" required="required" /><br></font>
	<br>
	<br>
	<font color=white><b>Contact No </b> <input align="middle" type="text" name="contact" required="required" /><br></font>
	<br>
	<br>
    <input type="submit" value="Submit" name="Register" /></form></center><br>
    <br>
   
</div>
</body>
</html>