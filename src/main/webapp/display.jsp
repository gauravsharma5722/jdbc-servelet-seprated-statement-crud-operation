<%@page
	import="jdbc_servelet_seprated_statement_crud_operation.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page
	import="jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;

	background: #f4f6f9;
	text-align: center;
}

/* Heading */
h3 {
	color: #2c3e50;
	margin-top: 30px;
}

/* Table */
table {
	margin: 30px auto;
	border-collapse: collapse;
	width: 80%;
	background: white;
	box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
}

th {
	background: #2c3e50;
	color: white;
	padding: 12px;
}

td {
	padding: 10px;
}

tr:nth-child(even) {
	background: #f2f2f2;
}

/* Buttons */
a {
	text-decoration: none;
	padding: 6px 12px;
	border-radius: 4px;
	color: white;
	font-size: 14px;
}

.update {
	background: #3498db;
}

.delete {
	background: #e74c3c;
}

a:hover {
	opacity: 0.8;
}
</style>

</head>

<body>

	<% 
  HttpSession httpsession=request.getSession();
  if(httpsession.getAttribute("EmployeeLogin")!=null)
  {
%>

	<h3>Employee Details</h3>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>s
			<th>Dob</th>
			<th>Doj</th>
			<th colspan="2">Action</th>
		</tr>

		<%
		EmployeeDao dao = new EmployeeDao();
		List<Employee> employees = dao.getAllEmployeeDao();

		for (Employee employee : employees) {
		%>

		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getDob()%></td>
			<td><%=employee.getDoj()%></td>
			<td><a href="updateEmployee.jsp?id=<%=employee.getId() %>"
				class="update">Update</a></td>
			<td><a href="deleteEmployee?id=<%=employee.getId()%>"
				class="delete">Delete</a></td>
		</tr>

		<% } %>

	</table>

	<%}else{ 
		request.setAttribute("msg","session expired login again.....");
		RequestDispatcher dispacher=request.getRequestDispatcher("loginEmployee.jsp");
		dispacher.include(request,response);
		%>
 
<%} %>
    




</body>
</html>