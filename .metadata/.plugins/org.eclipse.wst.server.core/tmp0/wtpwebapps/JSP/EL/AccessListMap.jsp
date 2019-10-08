<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<%
	ArrayList<String> greetings=new ArrayList<>();
	greetings.add("Hello World");
	greetings.add("Have a nice Day");
	pageContext.setAttribute("Greetings",greetings);
	
	HashMap<String,String> tel=new HashMap<>();
	tel.put("John","0987654321");
	tel.put("Mary","0912345678");
	pageContext.setAttribute("mobile",tel);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Accessor3</title>
</head>
<body>
	${Greetings[x]}<br>
	${Greetings[1]}<br>
	${Greetings[2]}<p>
	The mobile of John:${mobile-789}<br>
	The mobile of Mary:${mobile["Mary"]}<br>
	The mobile of John:${mobile['John']}
		
</body>
</html>