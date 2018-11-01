<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>洋服shop</h2>
	好きな色を選択してください
	<br>
	<form action="${pageContext.request.contextPath}/clothes/clothesInfo"
		method="post">
		<input type="radio" name="gender" value="1">Man<br> <input
			type="radio" name="gender" value="0">Woman<br> <select
			name="color">
			<option value="赤">赤</option>
			<option value="青">青</option>
			<option value="黄色">黄色</option>
			<option value="白">白</option>
		</select> <input type="submit" value="検索">

	</form>
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