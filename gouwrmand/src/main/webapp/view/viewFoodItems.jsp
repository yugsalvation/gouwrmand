<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>View FoodItems</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body class="bg-light text-dark">
	<div class="container-fluid">
	<br/>
  <h1 style="text-align:center;">FOOD ITEMS</h1>
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active">
        <th>Name</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Type</th>
       
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="food" items="${foodItems}">
    <c:url var="edit" value="/updateFoodItem">
    	<c:param name="fid" value="${food.food_id}"></c:param>
    </c:url>
     <c:url var="delete" value="/deleteFoodItems">
    	<c:param name="fid" value="${food.food_id}"></c:param>
    	<c:param name="category" value="${food.food_type}"></c:param>
    </c:url>
      <tr class="active">
        <td>${food.food_name.toUpperCase()} </td>
        <td>${food.food_price}</td>
        <td>${100*food.food_discount} %</td>
        <td>${food.food_type}</td>
        
        <td>
        <a href="${edit}" onclick="if(confirm('do you want to edit?'))return true; return false">Edit</a>
        </td>
         <td>
        <a href="${delete}" onclick="if(confirm('do you want to delete?'))return true; return false">Delete</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>
</body>
</html>