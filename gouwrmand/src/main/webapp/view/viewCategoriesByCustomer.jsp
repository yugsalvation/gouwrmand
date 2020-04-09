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
  <br/><br/><br/>
  <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4">
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active" align="center">
      
        <th>Select the Category</th>
       
      </tr>
    </thead>
    <tbody>

    <c:forEach var="food" items="${foodItems}">
    

      <tr class="active">
       
        <td align="center">
        <a href="/viewFoodItemsByCustomer?category=${food}">
        ${food} </a>
        </td>
        
        
        
      </tr>
     </c:forEach>
    </tbody>
  </table>
  </div>
  <div class="col-sm-4"></div>

  </div>
  </div>
</body>
</html>