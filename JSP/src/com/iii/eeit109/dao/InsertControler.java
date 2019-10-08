package com.iii.eeit109.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.iii.eeit109.bean.EmpBean;

@WebServlet("/InsertControler")
public class InsertControler extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		EmpBean eb = new EmpBean();
		eb.setEmpNo(request.getParameter("empno"));
		eb.setEname(request.getParameter("ename"));
		eb.setHiredate(request.getParameter("hiredate"));
		eb.setSalary(request.getParameter("salary"));
		eb.setDeptno(request.getParameter("deptno"));
		eb.setTitle(request.getParameter("title"));
		
		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		try {
			empdao.add(eb);
			ArrayList<EmpBean> empball = empdao.getall();
			request.setAttribute("emps", empball);
			RequestDispatcher rd = request.getRequestDispatcher("/forward/GetAllEmps1.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn !=null)
				try { conn.close(); } 
			    catch (SQLException e) { e.printStackTrace(); }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
