<%@page import="jdbc_servelet_seprated_statement_crud_operation.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
	<h3>Display page</h3>
<table border="2">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>email</th>
	<th>phone</th>
	<th>dob</th>
	<th>doj</th>
	<th colspan="2">Action</th>
	</tr>
	
	<% 
	EmployeeDao dao=new EmployeeDao();
	List<Employee> employees=dao.getAllEmployeeDao();
	for(Employee employee:employees)
	{
	%>
	
	
	
	
	
	<tr>
	<td><%= employee.getId() %></td>
	<td><%= employee.getName() %></td>
	<td><%= employee.getEmail() %></td>
	<td><%= employee.getPhone() %></td>
	<td><%= employee.getDob() %></td>
	<td><%= employee.getDoj() %></td>
	<td><a href="updateEmployee.jsp">update</a></td>
	<td><a href="#">Delete</a></td>
	</tr>
	
	<%} %>
	
	<tr>
	<td>123</td>
	<td>gaurav</td>
	<td>gaurav@123</td>
	<td>878932732</td>
	<td>14-11-2006</td>
	<td>24-11-2026</td>
	<td><a href="#">update</a></td>
	<td><a href="#">Delete</a></td>
	</tr>
	</table>
</body>
</html>