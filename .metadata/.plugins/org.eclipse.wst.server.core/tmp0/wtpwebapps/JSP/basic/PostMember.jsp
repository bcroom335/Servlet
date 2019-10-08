<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Parameters Demo</title>
</head>
<body>
	<div align=center>
		<h2>會員資料</h2>
		<table border=1><tr><th>名稱<th>值
		<% request.setCharacterEncoding("UTF-8");
		   Enumeration<String> paramNames =request.getParameterNames();
			while(paramNames.hasMoreElements()) {
				String paramName=paramNames.nextElement();%>
			<tr><td><%=paramName %><td>
				<% String[] paramValues=request.getParameterValues(paramName);
				 if(paramValues.length==1) {
					String paramValue=paramValues[0];
					if(paramValue.length()==0){%>
						<I>NO VALUE</I>
						<%}else %>
							<%=paramValue %>
					<%}else 
						for(int i=0;i<paramValues.length;i++){%>
						<%=paramValues[i] %>
					<%} %>
				<%} %>			
		</table>
	</div>
</body>
</html>