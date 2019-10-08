package com.iii.eeit109.forward;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/GetEmpEL")
public class GetEmpEL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/servdb")
	private DataSource ds;
	Connection conn;
    
    public void init() {
    	try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String empno = request.getParameter("empno");
		try {
			String qrystate = "select * from employee where empno= ?";
			PreparedStatement state = conn.prepareStatement(qrystate);
			state.setString(1, empno);
			ResultSet rs = state.executeQuery();
			com.iii.eeit109.bean.EmpBean emp=new com.iii.eeit109.bean.EmpBean();

			if (rs.next()) {
				emp.setEmpNo(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate").substring(0, 10));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
			}
			request.setAttribute("emp", emp);
			state.close();
			RequestDispatcher rd = request.getRequestDispatcher("/EL/GetEmpEL.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn !=null)
				try { conn.close(); } 
			    catch (SQLException e) { e.printStackTrace(); }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
