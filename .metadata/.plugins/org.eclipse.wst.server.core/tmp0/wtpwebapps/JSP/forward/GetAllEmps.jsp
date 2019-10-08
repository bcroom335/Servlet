<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.iii.eeit109.bean.EmpBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
</head>
<body>
	<div align="center">
		<h2>員工資料</h2>
		<table border="1">
		<tr><th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱
		<%ArrayList<EmpBean> al=(ArrayList<EmpBean>)request.getAttribute("emps");
			for(int i=0;i<al.size();i++){%>
		<tr><td><%=(al.get(i)).getEmpNo() %>
		<td><%=(al.get(i)).getEname() %>
		<td><%=(al.get(i)).getHiredate() %>
		<td><%=(al.get(i)).getSalary() %>
		<td><%=(al.get(i)).getDeptno() %>
		<td><%=(al.get(i)).getTitle() %>
		<%} %>
		</table>
		<h3>共<%=al.size()%>筆員工資料</h3>
	</div>
</body>
</html>