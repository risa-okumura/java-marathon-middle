<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link>
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><td>
プロ野球<br>
セントラルリーグ一覧
</td></tr>
</table>

<c:forEach var="baseballTeam" items="${baseballTeamList}" varStatus="status">
<form action="${pageContext.request.contextPath}/toBaseballTeamList/baseballTeamInfo" method="post">
	<p><a href="/baseballTeam/baseballTeamInfo?id=${baseballTeam.id}"><c:out value="${baseballTeam.teamName}" /></a></p>


</form>
</c:forEach>

</body>
</html>