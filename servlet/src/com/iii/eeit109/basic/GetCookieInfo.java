package com.iii.eeit109.basic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieInfo")
public class GetCookieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetCookieInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		PrintWriter out = response.getWriter();
//		out.write("<html><body><h2>Cookie資訊</h2>");
		out.write("<html><body><h2>Cookie資訊</h2>");
//		Cookie[] cookies = request.getCookies();
		Cookie[] cookies = request.getCookies();
//		if(cookies != null)
		if(cookies != null)
//			for(Cookie c:cookies)
			for(Cookie c : cookies)
//				out.append(c.getName()+"="+c.getValue()+"<br>");
				out.write(c.getName() + " = " + c.getValue() + "<br>");
//		else
		else
//			out.write("The request has no cookies");
			out.write("The request has no cookies");
//		out.write("</body></html>");
		out.write("</body></html>");
//		
//		String name = request.getParameter("cookieName");
		 String name = request.getParameter("cookieName");
//		if(name != null && name.length()>0) {
		if(name != null & name.length() > 0) {
//			String value=request.getParameter("cookieValue");
			String value =request.getParameter("cookieValue");
//			Cookie c=new Cookie(name, value);
			Cookie c = new Cookie(name, value);
//			response.addCookie(c);
			response.addCookie(c);
	            
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
