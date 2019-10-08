<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% session.setAttribute("user","pan"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="<c:out/>用法"/></title>
</head>
<body>
	<c:out value="${user }" default="Guest"/><br>
	<c:out value="${user1 }" default="Guest"/><p>

</body>
</html>