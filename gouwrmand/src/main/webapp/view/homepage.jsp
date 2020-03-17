<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>goUWrmand</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
function loadFrame (url){
    var frame1 = document.getElementById('frame1');
    frame1.src = url;
}
function resizeIframe(iframeID) 
{       
    var iframe = window.parent.document.getElementById(iframeID);
    var container = document.getElementById('content');
    iframe.style.height = container.offsetHeight + 'px';            
}
</script>
<style>
body{
 background-repeat:no-repeat;
  background-size:cover;
  
}
.center {
    right: 50%;
    bottom: 50%;
    transform: translate(50%,50%);
    position: absolute;
   
}
</style>
</head>
<body class="bg-light text-dark">
<div class="row">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
  <a class="navbar-brand" href="#">goUWrmand</a>
   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="javascript:loadFrame('index')">Menu</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="javascript:loadFrame('addFoodItem')">Add Food Item</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">View Orders</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Reports</a>
    </li>
    
  </ul>
  <ul class="navbar-nav ml-auto">
    <li class="nav-item">
      <a class="nav-link">Logout</a>
    </li></ul>
    </div>
</nav></div>

<div class="container-fluid center" >
<div class="row">
<div class="col-sm-1"> </div>
<div class="col-sm-10">
<div class="embed-responsive embed-responsive-16by9">
  
 <iframe id="frame1" class="embed-responsive-item" scrolling="yes" frameborder="3"
   allowfullscreen ></iframe></div>
</div>
<div class="col-sm-1"> </div></div>
</div>


</body>
</html>