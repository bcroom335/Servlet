<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AㄍHello</title>
</head>
<body>
	<H3>[]的用法</H3>
	主機名:${header["host"]}<br>
	接受的語言:${header["accept-language"]}<br>
	使用的瀏覽器與作業系統:${header["user-agent"]}<br>
	
	<H3>.的用法</H3>
	主機名:${header.host}<br>
	<%--.遇到-無法使用
	接受的語言:${header.accept-language}<br>
	使用的瀏覽器與作業系統:${header.user-agent}<br> --%>
</body>
</html>