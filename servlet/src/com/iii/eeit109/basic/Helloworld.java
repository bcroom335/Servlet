package com.iii.eeit109.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Helloworld")
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Helloworld() {
        super();        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<html><body><h2>Hello World,¤j®a¦n!!!</h2></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
