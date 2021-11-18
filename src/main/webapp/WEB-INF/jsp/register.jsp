<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background: url("register.jpg") no-repeat;
  background-size: cover;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
 /* padding: 16px;
  background: url("gradient.jpg") no-repeat;
  background-size: cover;*/
  width:50%;
 padding: 16px;
height:100%;
  background-color: white;
  opacity:1.0;
}

/* Full-width input fields */
input[type=text], input[type=password], input[type=email] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus, input[type=email]:focus{
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>
<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
  <div class="container">
    <h1>JOIN US....</h1>
    <p>Get signed up to the official VANITY page</p>
    <hr>
    
    <label for="email"><b>UserName</b></label>
    <input type="text" onclick="javascript:alert('Make sure your username contains an uppercase, lowercase and a special character');" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$" placeholder="Enter Username" name="username" id="username" required>
<br>
    <label for="email"><b>Email</b></label>
    <input type="email" pattern="^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$" placeholder="Enter Email" name="email" id="email" required>
<br>
<br>
    <label for="psw"><b>Password</b></label>
    <input type="password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$" onclick="javascript:alert('Make sure your password contains an uppercase, lowercase and a special character');" placeholder="Enter Password" name="password" id="password" required>
    <hr>

   <button type="submit" class="registerbtn" onclick="return myFunction()">YES PLEASE..!!</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="/login">Sign in</a>.</p>
  </div>
   <p>${message }</p>
</form:form>


</body>
</html>

        