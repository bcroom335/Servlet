package com.iii.eeit109.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.iii.eeit109.bean.EmpBean;

@WebServlet("/GetControler")
public class GetControler extends HttpServlet {
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
		
		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		try {
			empdao.FindById(eb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
