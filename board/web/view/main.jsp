<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- fmt를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%@ include file="../include/menu.jsp" %>
    <h2>board_list 페이지입니다.</h2>
    <a href="writer.mc">글쓰기</a>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성일자</th>
            <th>조회수</th>
        </tr>
        <!-- forEach 문은 리스트 객체 타입을 꺼낼때 많이 활용된다. -->
        <c:forEach var="b" items="${boardlist}">
        <tr>
            <!-- 컨트롤러에서 넘겨준 list 모델 객체를 쓰는 방법을 잘 익혀두자 -->
            <td>${b.bid}</td>
            <td><a href="read.mc?bid=${b.bid}">${b.title}</a></td>
            <td>${b.writer}</td>
            <td>
                <!-- 데이터 타입을 사용하는 방법 -->
                <fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
            </td>
            <td>${b.cnt}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
