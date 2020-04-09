<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="refresh" content="10" />
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
  <h1 style="text-align:center;">ORDERS TODAY</h1>
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active" align="center">
      	<th></th>
        <th>Name</th>
       	<th>Items</th>
       	<th>Total bill</th>
       	<th>Change Status</th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="orders" items="${orders}" varStatus="i">
     <c:url var="view" value="/viewOrderedItems">
    	<c:param name="oid" value="${orders.order_id}"></c:param>
    </c:url>
    <c:url var="ready" value="/viewChangeStatusOrder">
    <c:param name="oid" value="${orders.order_id}"></c:param>
    </c:url>
      <tr class="active" align="center">
       	<td>${i.count} </td>
        <td>${customername.get(i.count-1)}</td>
         
        <td>
        <a href="${view}">View</a>
        </td>
        <td>${orders.order_total} </td>
         <td>
        <a href="${ready}" onclick="if(confirm('Sure! the order is ready?'))return true;return false">Ready</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <br/>

  </div>
</body>
</html>