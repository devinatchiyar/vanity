
        
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background: url("login.jpg") no-repeat;
  background-size: cover;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
width:50%;
 padding: 16px;
height:100%;
  background-color: white;
  opacity:1.0;
  /*background-size: cover;*/
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 50px 22px 0;
  display: inline-block;
  border: none;
  background-color: #ddd;
}

input[type=text]:focus, input[type=password]:focus {
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

<form:form id="regForm" modelAttribute="login" action="loginProcess" method="post">
  <div class="container">
    <h1>Login</h1>
 

    
    <label for="text"><b>UserName</b></label>
    <br>
    <input type="text" placeholder="Enter Username" name="username" id="username" required>

<br>
    <label for="psw"><b>Password</b></label>
    <br>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>

    <br>

    <button type="submit" class="registerbtn">Login</button>
  </div>
  
  <div class="container signin">
    <p>New Here? <a href="/register">Sign up</a>.</p>
  </div>
  <p>${message }</p>
</form:form>

</body>
</html>

        