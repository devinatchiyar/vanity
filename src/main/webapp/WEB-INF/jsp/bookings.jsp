<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <head>
        <style>
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

/* Style the input field inside the navbar */
.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
  width: 150px; /* adjust as needed (as long as it doesn't break the topnav) */
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
	<meta charset="UTF-8">
	<title>Vanity - The Salon</title>
	
	<link href='https://fonts.googleapis.com/css?family=Fauna+One' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="style1.css">
	</head>
	<body >
	<div class="topnav">
  <a  href="/show-home">Home</a>
   <a href="/logout">Logout</a>
</div>
<div class="main">
  <h1>Your Upcoming Bookings</h1>
  <h2 class="sub-heading">We look forward to your visit</h2>
  <center><h3>${futuremessage}</h3></center>

  <section class="shopping-cart">
    <ol class="ui-list shopping-cart--list" id="shopping-cart--list">

      <c:forEach var="item" items="${BookingsList}">
        <li class="_grid shopping-cart--list-item">
          
          <div class="_column product-info">
            <h4 class="product-name">${item.name }</h4>
            <p class="product-desc">${item.date } - ${item.slot }</p>
            <div class="price product-single-price">${item.service }</div>
          </div>
          <div class="_column product-modifiers">
            <button class="_btn entypo-trash product-remove"><a href="remove-booking?bookingService=${item.service}&bookingDate=${item.date}&bookingSlot=${item.slot}">Delete</a></button>
          </div>
        </li>
       </c:forEach>

    </ol>

  </section>
  <hr>
  
  <h1>Your Past Bookings</h1>
  <h2 class="sub-heading">We hope you visit again</h2>
  <center><h3>${pastmessage}</h3></center>

  <section class="shopping-cart">
    <ol class="ui-list shopping-cart--list" id="shopping-cart--list">

      <c:forEach var="item" items="${BookingsList1}">
        <li class="_grid shopping-cart--list-item">
          
          <div class="_column product-info">
            <h4 class="product-name">${item.name }</h4>
            <p class="product-desc">${item.date } - ${item.slot }</p>
            <div class="price product-single-price">${item.service }</div>
          </div>
          
        </li>
       </c:forEach>

    </ol>

  </section>
</div>
</body>