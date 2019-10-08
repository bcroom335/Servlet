package _Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.MemberBean;
import _DAO.MemberDaoImpl;

@WebServlet("/MemSearchC")
public class MemSearchC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MemberBean mb1 = new MemberBean();
		mb1.setName(request.getParameter("name"));	
		MemberDaoImpl memdao;
		try {
			memdao = new MemberDaoImpl();
			memdao.creatconn();
			List<MemberBean> memnber_all = memdao.select(mb1);
			request.setAttribute("mems", memnber_all);
			memdao.closeconn();
			RequestDispatcher rd = request.getRequestDispatcher("GetMember.jsp");
			rd.forward(request, response);		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
