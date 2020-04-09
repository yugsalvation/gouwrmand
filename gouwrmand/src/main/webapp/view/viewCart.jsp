<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>View Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
function up(max) {
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
}

</script>
</head>
<body class="bg-light text-dark" >
	<div class="container-fluid">
  <h1 style="text-align:center;">View Cart</h1>
 <table class="table" style="margin-top:3%" >
    <thead>
      <tr class="active" align="center">
        <th>Name</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Type</th>
        <th></th>
        <th>Quantity</th>
        <th></th>
      </tr>
    </thead>
    <tbody>

    <c:forEach var="food" items="${foodItems}">
   
   <c:url var="add" value="/addItemQty">
    	<c:param name="fid" value="${food.food_id}"></c:param>
    	<c:param name="qty" value="${l[food.food_id]}"></c:param>
    	<c:param name="cid" value="${cid}"></c:param>
    
    </c:url>
    
     <c:url var="minus" value="/minusItemQty">
    	<c:param name="fid" value="${food.food_id}"></c:param>
    	<c:param name="qty" value="${l[food.food_id]}"></c:param>
    	<c:param name="cid" value="${cid}"></c:param>
    
    </c:url>
     
      <tr class="active" align="center">
        <td>${food.food_name.toUpperCase()} </td>
        <td id="p">${food.food_price}</td>
        <td id="d">${100*food.food_discount} %</td>
        <td>${food.food_type}</td>
        <td >
      <a href="${minus}" style="float: right;font-weight: bold;font-size: 25px;padding-top: 0px" onclick=" down('0')">-</a>
      </td>     
           <td> <input t="text" id="myNumber" style="width: 70px" value="${l[food.food_id]}" /></td>
            
          <td> <a href="${add}" style="float: left;" onclick=" up('10')">+</a>
</td>
  
        <td>
       
        </td>
      </tr>
     
     </c:forEach>
    </tbody>
  
  </table>
  <br/>
  <h4 style="text-align: right;margin-right: 250px;">Total Amount: ${sum}</h4>
  </div>
  <div style="text-align: center;"><a href="/placeOrder?cid=${cid}&sum=${sum}"><button type="button">Place your Order</button></a></div>
</body>
</html>