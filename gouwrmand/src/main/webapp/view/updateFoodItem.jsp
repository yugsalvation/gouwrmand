<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<title>Update Food Item</title>
</head>
<body class="bg-light text-dark">
<div class="container-fluid">
 <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4">
<div class="page-header">

 <h1 style="text-align:center;padding:5%;">update a food Item</h1></div> </div>

  <div class="col-sm-4"></div>
 </div></div>
  <div class="container-fluid" >
  <div class="row">
   <div class="col-sm-4"></div>
 <div class="col-sm-4">
 
<form:form action="processUpdateFoodItem" modelAttribute="fi" style="background-color:rgb(220,220,220,0.8);padding:10%;">
   <div class="form-group">
<label for="foodtype">Food Type:</label><form:input  class="form-control" path="food_type" /> <br/>
<label for="foodname">Food Name:</label><form:input  class="form-control" path="food_name" /> <br/>
<label for="foodprice">Food Price:</label><form:input  class="form-control" path="food_price"/> <br/>
<label for="fooddiscount">Food Discount:</label><form:input  class="form-control" path="food_discount" value="${fi.food_discount*100}"/> <br/>
<label for="fooddescription">Food Description:</label><form:input  class="form-control" path="food_description"/>  <br/>
<form:input  class="form-control" path="food_status" type="hidden" value="1" />
<form:input  class="form-control" path="food_id" type="hidden" />
<div class="row" align="center">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<button type="submit" class="btn btn-dark">Update</button>
</div>
<div class="col-sm-4"></div>
</div></div>
</form:form>

</div>


  <div class="col-sm-4"></div>
</div></div>
</body>
</html>