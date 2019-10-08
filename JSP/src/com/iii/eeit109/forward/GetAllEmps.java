package com.iii.eeit109.forward;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/GetAllEmps")
public class GetAllEmps extends HttpServlet {
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
		List<com.iii.eeit109.bean.EmpBean> emps= new ArrayList<>();
		try {
			String qrystate="select * from employee";
			PreparedStatement state = conn.prepareStatement(qrystate);
			ResultSet rs = state.executeQuery();
		while(rs.next()) {
			com.iii.eeit109.bean.EmpBean eb=new com.iii.eeit109.bean.EmpBean();
			eb.setEmpNo(rs.getString("empno"));
			eb.setEname(rs.getString("ename"));
			eb.setHiredate(rs.getString("hiredate").substring(0,10));
			eb.setSalary(rs.getString("salary"));
			eb.setDeptno(rs.getString("deptno"));
			eb.setTitle(rs.getString("title"));
			emps.add(eb);
		}
		request.setAttribute("emps", emps);
		state.close();
		RequestDispatcher rd = request.getRequestDispatcher("/forward/GetAllEmps1.jsp");
		rd.forward(request, response);
		}catch(SQLException e) {
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
