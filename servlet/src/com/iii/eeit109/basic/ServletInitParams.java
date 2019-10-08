package com.iii.eeit109.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/ServletInitParams",
			initParams= {@WebInitParam(name="greeting",value="Have a nice day!"),
						 @WebInitParam(name="count",value="3")})
public class ServletInitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String servletName;
	String greeting;
	int count;
	
//    public SerletInitParams() {
//        super();
//    }
    
//    public void init() {
//    	servletName = getServletConfig().getServletName();
//    	greeting =getServletConfig().getInitParameter("greeting");
//    	count = Integer.parseInt(getServletConfig().getInitParameter("count"));
//    }
    public void init(ServletConfig config) {
    	servletName = config.getServletName();
    	greeting = config.getInitParameter("greeting");
    	count =Integer.parseInt(config.getInitParameter("count"));
    }
//    public void init() {
//    	servletName = getServletName();
//    	greeting =getInitParameter("greeting");
//    	count = Integer.parseInt(getInitParameter("count"));
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("<html><body><h3>"+servletName+"</h3>");
		for(int i=0;i<count;i++)
		out.append(greeting+"<br>");
		out.append("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
