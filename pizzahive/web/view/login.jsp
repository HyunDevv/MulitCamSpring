<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
/*general css*/
* {
   padding: 0;
   margin: 0 auto;
   box-sizing: border-box;
   list-style: none;
}


.gap1 {      /*div사이사이 gap css*/
   height: 15px;
   clear: both;
   overflow: hidden;
   display: block;
}
/*header css*/
header {
   height: 75px;
   line-height: 75px;
   color: #2A0066;
}

header #headerdiv {
   width: 100%;
   margin: 0 auto;
   text-align: center;
}

.mainname {
   font-size: 2em;
   font-weight: 900;
   color: #00FFFF;
   text-shadow: 3px 3px 2px rgba(0, 0, 0, 0.44);
}

/*nav css start*/
nav {
   width: 100%;
   height: 55px;
   background-color: #d8d8d8;
}

.container {
   width: 1080px;
   height: 100%;
   padding: 0 20px;
}

.leftMenu {
   display: flex;
   flex-direction: row;
   margin: 0;
   padding: 0;
   background-color: #d8d8d8;
}

nav .leftMenu>li {
   float: left;
   padding: 15px;
   cursor: pointer;
   font-size: 100%;
   font-weight: BOLD;
}

nav .leftMenu>li>a {
   text-align: center;
   color: inherit;
   text-decoration: none;
   display: inline-block;
}

nav .leftMenu>li.loginbutton {
   float: right;
}

nav .leftMenu>li:hover {
   color: #000000;
   font-weight: 700;
   border-bottom: 3px solid #2478FF;
}

nav .leftMenu>li.active {
   color: #2478FF;
   font-weight: 700;
   border-bottom: 3px solid #2478FF;
}
/*nav css end*/


#cp {
   overflow: auto;
}

/* loginpage div CSS START */
#logindiv {
   width: 30%;
   height: 300px;
   overflow: auto;
   background: white;
}

#logindivin {
   width: 95%;
   hight: auto;
   background: white;
   border: 1px solid #ccc;
   box-sizing: border-box;
   margin: 0 auto;
   text-align: center;
}

h1 {
   text-align: center;
}

.logid, .logpwd {
   width: 50%;
   height: 50px;
   text-align: center;
   font-weight: BOLD;
   font-size: 20px;
}

input[type=text], input[type=password] {
   width: 80%;
   padding: 10px 10px;
   margin: 8px 0;
   display: inline-block;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
   font-weight: BOLD;
   text-align: center;
}

input[type=submit] {
   width: 50%;
   padding: 10px 10px;
   margin: 8px 0;
   display: inline-block;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
   font-weight: BOLD;
   font-size: 20px;
   text-align: center;
}

input[type=button] {
   width: 50%;
   padding: 10px 10px;
   margin: 8px 0;
   display: inline-block;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
   font-weight: BOLD;
   font-size: 20px;
   text-align: center;
}
/* loginpage div CSS END */
</style>
<title>RRS 로그인</title>
<div id="center">
   <header>

   </header>


   
   <section>
      <!-- 로그인 화면 div -->
      <p class="gap1"></p>
      <div id="logindiv">
         <br>
         <div id="logindivin">
            <h1>Login page</h1>
            <form action="loginimpl.mc" method="post">
               <table>
                  <tr>
                     <td class="logid">아이디</td>
                     <td><input type="text" name="id" maxlength="50" value="ID01"></td>
                  </tr>
                  <tr>
                     <td class="logpwd">비밀번호</td>
                     <td><input type="password" name="pwd" maxlength="50" value="PWD01"></td>
                  </tr>                             
               </table>
               <input type="submit" value="로그인" />
               <br>

            </form>
         </div>
      </div>
      <p class="gap1"></p>
   </section>

   <footer>

   </footer>


</div>