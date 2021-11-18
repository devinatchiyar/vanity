<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: cursive;
  background: url("book.jpg") no-repeat;
  background-size: cover;
  font-size: 23px;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
 margin-left: 25%;
  width:50%;
  padding: 20px;
  height:100%;
  background-color: white;
  opacity:1.0;
  float: center;
  
}

/* Full-width input fields */
input[type=text], input[type=password], input[type=date], select  {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
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

/* Style the navbar */
.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

/* Navbar links */
.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Navbar links on mouse-over */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
  width: 150px; 
}

.topnav a, .topnav input[type=text]{
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
}

.topnav input[type=text] {
    border: 1px solid #ccc; 
  }
}

</style>
</head>

<body>
<div class="topnav">
  <a  href="/show-home">Home</a>
   <a href="/logout">Logout</a>
</div>
<form:form id="regForm" modelAttribute="booking" action="/CompleteBooking" method="post">
  <div class="container">
    <h1>Book A Slot</h1>
    
    <hr>
    
    <label for="text"><b>Name</b></label>
    <input type="text" placeholder="Enter Username" name="name" id="name" required>

    <label for="text"><b>Phone</b></label>
    <input type="text" pattern="^(7|8|9)\d{9}$" title="enter 10 digit no" placeholder="Enter PhoneNumber" name="phoneNumber" id="phoneNumber" required>

    <label for="date"><b>Date</b></label>
    <input type="date" placeholder="Enter Date" name="date" id="date" required>
    
    <label for="slot"><b>Slot</b></label>
    <select name="slot">
	<option value="10.30 AM to 11.00 AM">10.30 AM to 11 AM</option>
	<option value="11.00 AM to 11.30 AM">11.00 AM to 11.30 AM</option>
	</select>

    <hr>

    <button type="submit" class="registerbtn">Book Now</button>
  </div>
  <div class="container signin">
    <p>${message}</p>
  </div>
</form:form>


</body>
</html>

        