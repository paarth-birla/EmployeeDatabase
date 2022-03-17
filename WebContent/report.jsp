<%@page import="com.models.EmployeeModel"%>
<%@page import="com.DAO.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	Welcome <%= session.getAttribute("name") %>
	<br><br>
	<form action="details.jsp" method="post">
	<label for="empid">EmployeeID </label><input type="text" name="emp_id"/>
	<button type="submit" style="background: #DF4E18;">Get Details</button>
	</form>
	
	
	
</body>
</html>