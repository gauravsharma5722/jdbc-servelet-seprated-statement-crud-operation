<%@page
	import="jdbc_servelet_seprated_statement_crud_operation.dto.Employee"%>
<%@page
	import="jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background: linear-gradient(135deg, #4facfe, #00f2fe);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background: white;
	padding: 40px;
	width: 400px;
	border-radius: 10px;
	box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.3);
}

h2 {
	text-align: center;
	margin-bottom: 25px;
	color: #333;
}

form label {
	display: block;
	margin-top: 12px;
	font-weight: bold;
	color: #444;
}

form input {
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.submit-btn {
	margin-top: 20px;
	background: #3498db;
	color: white;
	border: none;
	padding: 10px;
	width: 100%;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

.submit-btn:hover {
	background: #2980b9;
}
</style>

</head>
<body>

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Employee employee = new EmployeeDao().getEmployeeByIdDao(id);
	%>
	<div class="container">

		<h2>Update Employee</h2>

		<form action="updateEmployee" method="post">

			<label>Id</label> <input type="number" name="id"
				value="<%=employee.getId()%>" readonly="readonly"> <label>Name</label>
			<input type="text" name="name" value="<%=employee.getName()%>">

			<label>Email</label> <input type="email" name="email"
				value="<%=employee.getEmail()%>"> <label>Password</label>
			<input type="password" name="password"
				value="<%=employee.getPassword()%>>"> <label>Phone</label>
			<input type="tel" name="phone" value="<%=employee.getPhone()%>">

			<label>Date of Birth</label> <input type="date" name="dob"
				value="<%=employee.getDob()%>"> <label>Date of
				Joining</label> <input type="date" name="doj"
				value="<%=employee.getDoj()%>"> <input type="submit"
				value="Update Employee" class="submit-btn">

		</form>

	</div>

</body>
</html>
