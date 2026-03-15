<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>User Information</title>

<style>

body{
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg,#667eea,#764ba2,#ff6a00);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.box{
    background:white;
    padding:40px;
    border-radius:15px;
    box-shadow:0 10px 30px rgba(0,0,0,0.3);
    width:350px;
    text-align:center;
    transition:0.3s;
}

.box:hover{
    transform:scale(1.05);
}

h2{
    color:#333;
    margin-bottom:20px;
}

.info{
    text-align:left;
    margin-top:20px;
}

.info p{
    background:#f4f4f4;
    padding:10px;
    border-radius:8px;
    margin:10px 0;
}

span{
    font-weight:bold;
    color:#2575fc;
}

.logout{
    margin-top:20px;
}

.logout a{
    text-decoration:none;
    background:#2575fc;
    color:white;
    padding:10px 20px;
    border-radius:8px;
    transition:0.3s;
}

.logout a:hover{
    background:#6a11cb;
}

</style>
</head>

<body>

<div class="box">

<h2>Welcome User 🎉</h2>

<div class="info">

<p><span>User ID :</span> ${id}</p>

<p><span>Name :</span> ${name}</p>

<p><span>Email :</span> ${email}</p>

<p><span>Phone :</span> ${phone}</p>

</div>

<div class="logout">
<a href="Login.html">Logout</a>
</div>

</div>

</body>
</html>