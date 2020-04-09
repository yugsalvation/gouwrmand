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
<script>function up(max) {
    document.getElementById("myNumber").value = parseInt(document.getElementById("myNumber").value) + 1;
    if (document.getElementById("myNumber").value >= parseInt(max)) {
        document.getElementById("myNumber").value = max;
    }
}
function down(min) {
    document.getElementById("myNumber").value = parseInt(document.getElementById("myNumber").value) - 1;
    if (document.getElementById("myNumber").value <= parseInt(min)) {
        document.getElementById("myNumber").value = min;
    }
}</script>
</head>
<body class="bg-light text-dark">
	<div class="container-fluid">
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
        <th></th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="food" items="${foodItems}">
    <c:url var="add" value="/addToCart">
    	<c:param name="fid" value="${food.food_id}"></c:param>
    	
    </c:url>
     
      <tr class="active">
        <td>${food.food_name.toUpperCase()} </td>
        <td>${food.food_price}</td>
        <td>${100*food.food_discount} %</td>
        <td>${food.food_type}</td>
        
        <td>
        <a href="${add}" onclick="if(confirm('do you want to add?'))return true; return false">Add</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>
</body>
</html>