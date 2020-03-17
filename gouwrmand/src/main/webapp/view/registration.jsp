<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Registration Page</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

   <!--Made with love by Mutiullah Samim -->
   
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

  <form:form modelAttribute="customer" method="POST">
<div class="container" style="position: absolute;margin: auto;
  top: 0;right: 0;bottom: 0;left: 0;width: 700px;
  height:fit-content" >
	<div class="d-flex justify-content-center h-100" >
		<div class="card" style="background-color: #a9a9a9;text-align: center" >
			<div class="card-header">
				<h3>Sign In</h3>
			</div>
			<div class="col-sm-12" style="padding-top:10px;width:300px ">
<form:input type="text" class="form-control" path="name" placeholder="First Name" name="firstname" style="border-radius:15px;"></form:input>

<form:input type="email" class="form-control" path="email" placeholder="Email Address" name="email" style="border-radius:15px;margin-top:8px"></form:input>

<form:input type="password" class="form-control" path="password" placeholder="password" name="password" style="border-radius:15px;margin-top:8px"></form:input>

<input type="password" class="form-control" path="confirm_password" placeholder="Confirm Password" name="confirm_password" style="border-radius:15px;margin-top:8px"></input>

<form:input type="date" class="form-control" path="date_of_birth" placeholder="Date of Birth" name="date_of_birth" style="border-radius: 15px; margin-top: 8px"></form:input>
 
<form:input type="text" class="form-control" path="phone_no" placeholder="Phone Number" name="phone_no" style="border-radius:15px;margin-top:8px"></form:input>

<form:input type="text" class="form-control" path="address" placeholder="Address" name="address" style="border-radius:15px;margin-top:8px"></form:input>

<input type="submit" value="submit" path="submit" class="btn float-centre login_btn" style="border-radius:15px;margin-top:8px;margin-bottom:15px"></input>
</div>
			
			
		</div>
	</div>
	
</div>
</form:form>
</body>
</html>