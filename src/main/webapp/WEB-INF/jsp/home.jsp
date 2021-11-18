<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <head>
	<meta charset="UTF-8">
	<title>Vanity - The Salon</title>
	<link href='https://fonts.googleapis.com/css?family=Fauna+One' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="styles.css">
	<script src="scripts.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--[if IE]><script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

</head>
<body>
	${message}
		<!-- LANDING PAGE -->
		<section id="home">
			<!-- OVERLAY -->
			<div class="overlay">
				<!-- PRIMARY NAVIGATION -->
				<nav role="navigation">
					<ul class="vertical-list">
						<li><a href="#home">Home</a></li>
						<li><a href="#about">About Us</a></li>
						<li><a href="#services">Services</a></li>
						<li><a href="/show-bookings" >Bookings</a></li>
						<li><a href="/logout" >Logout</a></li>
					</ul>
				</nav>
				<!-- END OF PRIMARY NAVIGATION -->

				<!-- CONTAINER -->
				<div class="container">
					<h1><span class="logo">Vanity</span><br><br><small>The Ultimate Salon Experience</small></h1>
						
				</div>
				<!-- END OF CONTAINER -->
			</div>
			<!-- END OF OVERLAY -->
		</section>
		<!-- END OF LANDING PAGE -->
		<!-- ABOUT -->
<section id="about">
    <!-- CONTAINER -->
    <div class="container">
        <h2 style="margin-left: 20px;">About Us</h2>
        <div class="row info">
            <div class="col-sm-8">
                <p style="margin-left: 20px;">
                    Vanity offers trendy haircuts and color services, complete skin care solutions and bridal packages, at affordable rates. Equipped with the knowledge on a wide variety of professional hair & skin care products, our well trained professional stylists provide friendly service. Conveniently close, we're located right in your neighbourhood. You can also find your favorite world class hair care brands, like L'Oreal, Matrix, Wella, Schwarzkopf and many more at Vanity.
				</p>
			</div>
			<img src="about.jpg" alt="About Us" class="img-responsive img-circle" width="45%" height="50%" style="margin-left: 20px;">

        </div>
        
        <div id="skill-set">
			<h3 style="margin-left: 20px;">  Our Specialities</h3>
			<br>
			<br>
            <ul class="vertical-list" style="align-self: center; margin-left: 20px;">
                <li>
                    <ul class="vertical-list skills" id="web-development-skills">
                        <li>MAKEUP&STYLING</li>
                        <li>MANICURE</li>
                    </ul>
                </li>
                <li>
                    <ul class="vertical-list skills" id="automation-skills">
						<li>HAIR CARE</li>
						<li>DETAN & BLEACH</li>
                    </ul>
                </li>

 
<li>
                    <ul class="vertical-list skills" id="automation-skills">
						<li>HAIR COLOURING</li>
						<li>THREADING</li>
                    </ul>
                </li>

                <li>
                    <ul class="vertical-list skills" id="misc-skills">
						<li>FACIAL</li>
						<li>Pedicure</li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- END OF CONTAINER -->
</section>
<hr>
<!-- END OF ABOUT -->

<!-- PORTFOLIO -->
<section id="services">

<div class="wrapper">
    <h1 style="color: black;font-family:inherit;">Men</h1>
    <br>
    <div class="cols">
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('men-facial.png')">
                          <div class="inner">
                              <p>FACIAL</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-man-facial">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('men-haircut.jpg')">
                          <div class="inner">
                              <p>CUT & STYLE</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-man-haircut">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('men-manicure.jpg')">
                          <div class="inner">
                              <p>ManiPedi</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-man-manipedi">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('styling.jpg')">
                          <div class="inner">
                              <p>ADVANCED STYLING</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-man-advancestyling">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
   </div>
   </div>
   <br>
   <hr>
<!-- END OF ABOUT -->

<!-- PORTFOLIO -->

<div class="wrapper">
    <h1 style="color: black;font-family:inherit;">Women</h1>
    <br>
    <div class="cols">
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('facial.jpg')">
                          <div class="inner">
                              <p>FACIAL</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/women-facial">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('haircut.jpg')">
                          <div class="inner">
                              <p>CUT & STYLE</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-women-haircut">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('manicure.jpg')">
                          <div class="inner">
                              <p>ManiPedi</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-women-manipedi">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="col" ontouchstart="this.classList.toggle('hover');">
                  <div class="container">
                      <div class="front" style="background-image: url('threading.jpeg')">
                          <div class="inner">
                              <p>Threading</p>
                <span></span>
                          </div>
                      </div>
                      <div class="back">
                          <div class="inner">
                            <p><a href="/show-women-threading">CLICK HERE</a></p>
                          </div>
                      </div>
                  </div>
              </div>
   </div>
   </div>
   <br>
   <hr>
   </section>
	
</body>
</html>