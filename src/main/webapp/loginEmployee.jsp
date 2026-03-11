<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login</title>

<style>
body{
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg,#667eea,#764ba2);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.login-container{
    background:white;
    padding:30px;
    width:350px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    margin-bottom:20px;
}

input{
    width:100%;
    padding:10px;
    margin:10px 0;
    border-radius:5px;
    border:1px solid #ccc;
}

button{
    width:100%;
    padding:10px;
    background:#667eea;
    border:none;
    color:white;
    font-size:16px;
    border-radius:5px;
    cursor:pointer;
}

button:hover{
    background:#5563d1;
}

</style>
</head>

<body>

<div class="login-container">

<h2>Employee Login</h2>

<form action="EmployeeLogin" method="post">


<% if(request.getAttribute("msg")!=null){ %>
<h3>
<%=request.getAttribute("msg")%>
</h3>

<%} %>

<label>Email</label>
<input type="email" name="email" placeholder="Enter your email" required>

<label>Password</label>
<input type="password" name="password" placeholder="Enter your password" required>

<button type="submit">Login</button>

</form>

</div>

</body>
</html>