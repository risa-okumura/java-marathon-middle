<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>zu
</head>
<body>
	<h2>洋服shop</h2>
	好きな色を選択してください
	<br>
	
	<form:form action="${pageContext.request.contextPath}/clothes/clothesInfo" modelAttribute="clothesForm">
		<form:radiobutton path="gender" value="1" label="Man"/><br> 
		<form:radiobutton path="gender" value="0" label="Woman"/><br> 
		<form:select path="color" items="${colorMap}"/>
		<input type="submit" value="検索">
	</form:form>
	<hr>

	<c:forEach var="clothes" items="${clothesList}">
		ジャンル：<c:out value="${clothes.genre}" />
		<br>
		サイズ：<c:out value="${clothes.size}" />
		<br>
		価格：<fmt:formatNumber value="${clothes.price}" pattern="###,###"/>
		<br>

	</c:forEach>




</body>
</html>