<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<style>


h1{
   text-align:center;
   font-size: 300%;
}

h4{
   text-align:center;
   font-size: 150%;
}

ul{
   text-align:center;
}

li {
   float: left;
   margin: 0 50px;
   font-size: 200%;
}



</style>

</head>
<body>
<h1>하이브피자</h1>
<h4>${loginuser.id}님</h4>
<div id="div1">
<ul> 
	<li><a href="pizza.mc?id=${loginuser.id}&it=it01">고구마피자(18000)</a></li>
	<li><a href="pizza.mc?id=${loginuser.id}&it=it02">콤피네이션피자(15000)</a></li>
	<li><a href="pizza.mc?id=${loginuser.id}&it=it03">포테이토피자(17000)</a></li>
	<li><a href="pizza.mc?id=${loginuser.id}&it=it04">쉬림프피자(20000)</a></li>
</ul>
</div>
</body>
</html>




