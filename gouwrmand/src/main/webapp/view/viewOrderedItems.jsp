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
 <a href="/viewTodayOrders"> <h1 style="text-align:center;">Go Back</h1></a>
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active" align="center">
        <th>Name</th>
       	<th>Quantity</th>
        
      </tr>
    </thead>
    <tbody>

    <c:forEach var="order" items="${itemsname}" varStatus="i">
      <tr class="active" align="center">
        <td>${order} </td>
        <td>${quantity.get(i.count-1)}</td>
        
    
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>
</body>
</html>