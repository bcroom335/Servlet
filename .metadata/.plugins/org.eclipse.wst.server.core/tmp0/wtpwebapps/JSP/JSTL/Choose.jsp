<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="<c:choose/><c:when/><c:otherwise/>的用法"/></title>
</head>
<body>
	<%if(request.getParameter("password").equals("123")){ %>
		<%=request.getParameter("user") %>歡迎光臨!
	<%}else{ %>
		密碼不對，請重新輸入
	<%} %><P>
	
	<c:choose>
	<c:when test="${param.password=='123'}">
		${param.user}歡迎光臨!
	</c:when>
	<c:otherwise>
	密碼錯誤，請重新輸入!!
	</c:otherwise>
	</c:choose>

</body>
</html>