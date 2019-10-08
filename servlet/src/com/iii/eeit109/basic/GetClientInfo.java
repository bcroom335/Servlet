package com.iii.eeit109.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetClientInfo")
public class GetClientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetClientInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>Client Information Demo</title></head>");
		out.append("<body><h2>ClientºÝªº¸ê°T</h2>");
		out.append("Scheme:"+request.getScheme()+"<br>");
		out.append("ServerName:"+request.getServerName()+"<br>");
		out.append("ServerPort:"+request.getServerPort()+"<br>");
		out.append("ContextPath:"+request.getContextPath()+"<br>");
		out.append("ServletPath:"+request.getServletPath()+"<br>");
		out.append("Method:"+request.getMethod()+"<br>");
		out.append("Portocol:"+request.getProtocol()+"<br>");
		out.append("URI:"+request.getRequestURI()+"<br>");
		out.append("RemoteHost:"+request.getRemoteHost()+"<br>");
		out.append("RemoteAddr:"+request.getRemoteAddr()+"<br>");
		out.append("ContentType:"+request.getContentType()+"<br>");
		out.append("ContentLength:"+request.getContentLength()+"<p>");
		
		Enumeration<String> names=request.getHeaderNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getHeader(name);
			out.append("headerName="+name+",headerValue="+value+"<br>");
		}
		out.append("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
