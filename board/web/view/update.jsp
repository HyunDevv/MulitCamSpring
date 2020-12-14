<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="../include/menu.jsp" %>
    <h2>board_read 페이지입니다.</h2>
    <a href="writer.mc">글쓰기</a>
    <form name="updateform" method="POST" action="updateimpl.mc">
        <div>글번호</div>
        <div>ID:${datas.bid}</div>
        <div>작성자</div>
        <div><input name="writer" value="${datas.writer}" type="text" readonly="readonly"/></div>
        <div>게시글제목 : </div>
        <div><input name="title" value="${datas.title}" type="text"/></div>
        <div>게시글내용 : </div>
        <div><textarea name="content" rows="5" cols="50">${datas.content}</textarea></div>
        <div>조회수</div>
        <div><input name="cnt" value="${datas.cnt}" type="text" readonly="readonly"/></div>
        <div>작성일자</div>
        <div><fmt:formatDate value="${datas.regdate}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
        <input type="hidden" name="bid" value="${datas.bid }">
        <div>
            <input type="submit" value="글수정"/>
            <input type="reset" value="리셋"/>
        </div>
    </form>
    
</body>
</html>
