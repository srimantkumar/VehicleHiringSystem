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
<center>
<body style="font-size: 25px;padding-top:0px;background-image: url(bike.jpg); height: 700px; background-repeat: no-repeat;background-size: 100% 100%;"> 
<div  style="text-decoration: none;font-size: 17px;background-color: #1DA497;">
<span style="padding-top:0px;font-size:27px;font-style: bold; font-family: "Times New Roman", Times, serif;" align="center"><center>
VEHICLE HIRING SYSTEM</center></span>
<div><center><marquee width="250px">Drive Like its your Own!!!!!!!!!</marquee></center> </div>
</div>
<div class="topnav">
 
  <a class="active" href="#" >LOGOUT</a>
  <a href="Homepage.jsp">HomePage</a>
</div>
</center>

<br>
<br>
<center>
<fieldset>
<legend><b> <font color=white>BILLING INFO</font></b></legend>
<form method="post" action="BillingServlet">

    <font color=white>BookId :</font> <input type="text" name="book_id" value ="${book_id}" readonly="readonly"><br><br>
	<font color=white>TotalAmt:</font> <input type="text" name="amount" value ="${amount}"  readonly="readonly"><br><br>
	<input type="submit" value="PAY"> 
	</center>
		</form>
</fieldset>
</body>
</html>