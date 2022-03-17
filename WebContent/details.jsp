<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.LoginDAO"%>
<%@page import="com.models.EmployeeModel"%>
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
	
	<%
	LoginDAO loginDAO = new LoginDAO();
	int empid = Integer.parseInt(request.getParameter("emp_id"));
	System.out.println(empid);
	ArrayList<EmployeeModel> employees = loginDAO.getDetails(empid);
	System.out.println(employees.size());
	%>
	
	<%
    for(int i = 0; i < employees.size(); i++)
    {
    	EmployeeModel employee = employees.get(i);
    	employee.display();
    %>
	<div style="padding: 10px">
	<div class="card text-white bg-dark" style="width: 18rem; padding: 10px;">
	  <div class="card-body">
	    <h5 class="card-title">Name : <%= employee.getFirstname() + " " + employee.getLastname() %></h5>
	    <h6 class="card-text">Job Title : <%= employee.getJob() %></h6>
	    <p class="card-text">Employee ID : <%= employee.getEmpID() %></p>
	    <p class="card-text">Contact : <%= employee.getContact() %></p>
	    <p class="card-text">Salary : <%= employee.getSalary() %></p>
	    <p class="card-text">Yearly Bonus : <%= employee.getYearlyBonus() %></p>
	    <p class="card-text">Yearly Salary : <%= (employee.getSalary()*12) + employee.getYearlyBonus() %></p>
	  </div>
	</div>
	</div>
	<%	
    }
    %>
	
</body>
</html>