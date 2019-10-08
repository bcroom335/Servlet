<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBean With JSP</title>
</head>
<body>
	<div align="center">
		<h3>Using JavaBeans with JSP</h3>
		<jsp:useBean id="order" class="com.iii.eeit109.bean.OrderBean" />
		<jsp:setProperty name="order" property="*"/>
		<table border="1">
		<tr><th>book no.<th>unit price<th>quantity<th>subTotal
			<tr align="right">
				<td><jsp:getProperty property="bookno" name="order"/>
				<td>$<jsp:getProperty property="price" name="order"/>
				<td><jsp:getProperty property="quantity" name="order"/>
			<%	NumberFormat f=NumberFormat.getInstance();
				if(f instanceof DecimalFormat)
					((DecimalFormat)f).applyPattern("#0.0");
				out.write("<td>$"+f.format(order.getSubTotal()));%>
		</table>
	</div>
</body>
</html>