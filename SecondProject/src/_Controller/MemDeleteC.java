package _Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.MemberDaoImpl;

@WebServlet("/MemDeleteC")
public class MemDeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MemberDaoImpl memdao;
		try {
			memdao = new MemberDaoImpl();
			memdao.creatconn();
			memdao.delete(Integer.parseInt(request.getParameter("seqNo")));
			memdao.closeconn();
			RequestDispatcher rd = request.getRequestDispatcher("Finish.jsp");
			rd.forward(request, response);
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
