<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
  text-align: center;
  padding: 8px;
  font-family: 微軟正黑體;
}
tr:nth-child(even) {background-color: #f2f2f2;}
input[type=submit] {
   background-color: #46a3ff;
   color: white;
   font-family: 微軟正黑體;
   font-size: 14px;
   padding: 8px 15px;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}
input[type=submit]:hover {
   background-color: #84c1ff;
}
input[type=button] {
   background-color: #46a3ff;
   color: white;
   font-family: 微軟正黑體;
   font-size: 20px;
   width:100%;
   margin:10px 0px;
   padding: 12px 20px;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}
</style>
</head>
<body>
	<div align="center">
		<h2>會員資料</h2>
		<table border="1">
		<tr><th>會員編號<th>姓名<th>生日<th>地址<th>e-mail<th>電話<th>修改<th>刪除
		<c:forEach items="${mems}" var="mem"  >
			<tr><td>${mem.seqNo}
			<td>${mem.name}
			<td>${mem.birth}
			<td>${mem.address}
			<td>${mem.email}
			<td>${mem.tel}
			<td><form method='post' action='MemberUpdate.jsp'>
			<input type='hidden' name='seqNo' value='${mem.seqNo}'>
			<input type='hidden' name='name' value='${mem.name}'>
			<input type='hidden' name='birth' value='${mem.birth}'>
			<input type='hidden' name='address' value='${mem.address}'>
			<input type='hidden' name='email' value='${mem.email}'>			
			<input type='hidden' name='tel' value='${mem.tel}'>
			<input type='submit' value='修改'></form>
			
			<td><form method='post' action='MemberDelete.jsp'>
			<input type='hidden' name='seqNo' value='${mem.seqNo}'>
			<input type='hidden' name='name' value='${mem.name}'>
			<input type='hidden' name='birth' value='${mem.birth}'>
			<input type='hidden' name='address' value='${mem.address}'>
			<input type='hidden' name='email' value='${mem.email}'>			
			<input type='hidden' name='tel' value='${mem.tel}'>
			<input type='submit' value='刪除'></form>
		</c:forEach>
		</table>
		<input type='button' value='回首頁' onclick="javascript:location.href='http://localhost:8081/SecondProject/Index1.html'">
	</div>
</body>
</html>