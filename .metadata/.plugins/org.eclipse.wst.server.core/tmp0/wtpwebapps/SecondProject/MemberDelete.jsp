<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
<style>
table {
  border-collapse: collapse;
  width: 40%;
}

th, td {
  text-align: center;
  padding: 8px;
  font-family: 微軟正黑體;
}

tr:nth-child(even) {background-color: #f2f2f2;}
input[type=text] {
  width: 80%;
  padding: 6px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
input[type=submit] {
   background-color: #46a3ff;
   color: white;
   font-family: 微軟正黑體;
   font-size: 14px;
   margin:20px;
   padding: 8px 15px;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}
input[type=submit]:hover {
   background-color: #84c1ff;
}
</style>
</head>
<body>
	<div align="center">
		<h2>會員資料</h2>
		<form method='post' action='MemDeleteC'>
		<table border="1">
			<tr><th>名稱<th>值
			<tr><td>會員編號：<td>${param.seqNo}
			<input type='hidden' name='seqNo' value='${param.seqNo}'>
			<tr><td>名字：<td>${param.name}
			<input type='hidden' name='name' value='${param.name}'>
			<tr><td>出生年月：<td>${param.birth}
			<input type='hidden' name='birth' value='${param.birth}'>
			<tr><td>地址：<td>${param.address}
			<input type='hidden' name='address' value='${param.address}'>
			<tr><td>e-mail：<td>${param.email}
			<input type='hidden' name='email' value='${param.email}'>			
			<tr><td>電話：<td>${param.tel}
			<input type='hidden' name='tel' value='${param.tel}'>			
		</table>
		<input type='submit' value='確定刪除'></form>
	</div>
</body>
</html>