<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

球団名<br>
<c:out value="${baseballTeam.teamName}" />
<br><br>
本拠地<br>
<c:out value="${baseballTeam.headquarters}" />
<br><br>
発足<br>
<c:out value="${baseballTeam.inauguration}" />
<br><br>
歴史<br>
<pre><c:out value="${baseballTeam.history}" /></pre>

<a href="/baseballTeam/toBaseballTeamList">戻る</a>

</body>
</html>