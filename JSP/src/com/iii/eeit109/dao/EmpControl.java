package com.iii.eeit109.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.iii.eeit109.bean.EmpBean;

@WebServlet("/EmpControl")
public class EmpControl extends HttpServlet {
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
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		
		List<EmpBean> emps= new ArrayList<>();
		EmpBean eb = new EmpBean();
		eb.setEmpNo(empno);
		eb.setEname(ename);
		eb.setHiredate(hiredate);
		eb.setSalary(salary);
		eb.setDeptno(deptno);
		eb.setTitle(title);
		
		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		try {
			empdao.add(eb);
			empdao.update(eb);
			empdao.delete(eb);
			empdao.FindById(eb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
