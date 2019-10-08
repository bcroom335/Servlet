package _Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.MemberBean;
import _DAO.MemberDaoImpl;

@WebServlet("/MemAddC")
public class MemAddC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MemberBean mb1 = new MemberBean();
		mb1.setName(request.getParameter("name"));
		mb1.setBirth(request.getParameter("birth"));
		mb1.setAddress(request.getParameter("address"));
		mb1.setEmail(request.getParameter("mail"));
		mb1.setTel(request.getParameter("tel"));
		
		MemberDaoImpl memdao;
		try {
			memdao = new MemberDaoImpl();
			memdao.creatconn();
			memdao.add(mb1);
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
