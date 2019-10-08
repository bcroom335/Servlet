<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="emp" class="com.iii.eeit109.bean.EmpBean" scope="request"/>
<jsp:setProperty name="emp" property="ename" value="pan"/>
<jsp:setProperty name="emp" property="salary" value="56000"/>
<html>
<head>
<meta charset="UTF-8">
<title>Accessor4</title>
</head>
<body>
	<h3>.寫法</h3>
	姓名:${emp.ename}<br>
	薪水:${emp.salary}<br>
	<h3>[]寫法</h3>
	姓名:${emp["ename"]}<br>
	薪水:${emp["salary"]}
		
</body>
</html>