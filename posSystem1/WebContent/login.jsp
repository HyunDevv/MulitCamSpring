<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<style>

</style>
<script>
function register(){
   var id = $('#register_form>input[name="id"]').val();
   var pwd = $('#register_form>input[name="pwd"]').val();
   if(id=='' || id == null){
      alert('ID is Madatory..');
       $('#register_form>input[name="id"]').focus();
       return;
   }
   if(pwd==null || pwd ==''){
      alert('PWD is Madatory..');
      $('#register_form>input[name="pwd"]').focus();
      return;
   }
   $('#register_form').attr({
      'action':'login',
      'method':'GET'
   }).submit();
};

$(document).ready(function(){
   $('#register_form>a').click(function(){
      register();   
   });
});
</script>
</head>
<body>
<h1>POS SYSTEM</h1>
<form action="loginimpl.mc" method="POST" id="register_form">
ID<input type="text" name="id" value="id01"><br>
PWD<input type="password" name="pwd" value="pwd01"><br>
<input type="submit" value="Login">


</form>
</body>
</html>