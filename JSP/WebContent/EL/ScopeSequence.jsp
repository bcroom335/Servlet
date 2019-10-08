<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	session.setAttribute("user","pan");
	pageContext.setAttribute("customer","pan1");
	request.setAttribute("customer","pan2");
	session.setAttribute("customer","pan3");
	application.setAttribute("customer","pan4");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Accessor2</title>
</head>
<body>
	a 屬性的值:${a}<p><%--沒設定的變數呈現空白(null) --%>
	user 屬性的值:${user}<p><%--從有設定的變數找起 --%>
	customer屬性的值:${customer}<p><%--若四種Scope都有設定先從Page範圍找起 --%>
	pageContext.customer=${pageScope.customer}<br>
	request.customer=${requestScope.customer}<br>
	session.customer=${sessionScope.customer }<br>
	application.customer=${applicationScope.customer}
	
</body>
</html>