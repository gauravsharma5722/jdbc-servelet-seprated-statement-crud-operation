<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Management System</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial, Helvetica, sans-serif;
}

body{
background:#f5f7fb;
}

/* Header */

header{
background:linear-gradient(90deg,#1e3c72,#2a5298);
color:white;
padding:20px;
text-align:center;
font-size:26px;
letter-spacing:1px;
}

/* Navbar */

nav{
background:#ffffff;
padding:15px;
box-shadow:0px 2px 10px rgba(0,0,0,0.1);
text-align:center;
}

nav a{
text-decoration:none;
color:#333;
margin:0 20px;
font-size:18px;
font-weight:bold;
transition:0.3s;
}

nav a:hover{
color:#2a5298;
}

/* Hero Section */

.hero{
height:350px;
background:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),
url("https://images.unsplash.com/photo-1521737604893-d14cc237f11d");
background-size:cover;
background-position:center;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
color:white;
text-align:center;
}

.hero h1{
font-size:45px;
margin-bottom:15px;
}

.hero p{
font-size:20px;
margin-bottom:25px;
}

/* Buttons */

.btn{
padding:12px 25px;
background:#ff7b00;
color:white;
border:none;
border-radius:6px;
font-size:18px;
cursor:pointer;
text-decoration:none;
margin:10px;
transition:0.3s;
}

.btn:hover{
background:#e66900;
}

/* Features Section */

.features{
display:flex;
justify-content:center;
gap:30px;
margin:50px;
flex-wrap:wrap;
}

.card{
background:white;
padding:30px;
width:260px;
border-radius:10px;
box-shadow:0 5px 15px rgba(0,0,0,0.1);
text-align:center;
transition:0.3s;
}

.card:hover{
transform:translateY(-8px);
}

.card h3{
margin-bottom:15px;
color:#2a5298;
}

.card p{
color:#555;
}

/* Footer */

footer{
background:#1e3c72;
color:white;
text-align:center;
padding:15px;
margin-top:40px;
}

</style>
</head>

<body>

<header>
Employee Management System
</header>

<nav>
<a href="index.jsp">Home</a>
<a href="addEmployee.jsp">Add Employee</a>
<a href="loginEmployee.jsp">Login Employees</a>
<a href="updateEmployee.jsp">Update</a>
<a href="deleteEmployee.jsp">Delete</a>
</nav>

<section class="hero">
<h1>Manage Your Employees Easily</h1>
<p>Simple and powerful system to manage employee records</p>

<a href="addEmployee.jsp" class="btn">Add Employee</a>
<a href="loginEmployee.jsp" class="btn">Login Employees</a>
</section>

<section class="features">

<div class="card">
<h3>Add Employee</h3>
<p>Insert new employee records quickly into the system.</p>
</div>

<div class="card">
<h3>Login Employees</h3>
<p>Display all employee information in an organized way.</p>
</div>

<div class="card">
<h3>Update Details</h3>
<p>Modify employee information whenever required.</p>
</div>

<div class="card">
<h3>Delete Records</h3>
<p>Remove employee data safely from the database.</p>
</div>

</section>

<footer>
© 2026 Employee Management System | Developed for Learning
</footer>

</body>
</html>