package com.iii.eeit109.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertnewEmp")
public class InsertnewEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    public InsertnewEmp() {
        super();
    }
    
    public void init() {
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl="jdbc:sqlserver://localhost:1433;databaseName=servdb";
			conn = DriverManager.getConnection(connUrl,"sa","password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String qrystate="Insert into employee(empno,ename,hiredate,salary,deptno,title)values(?,?,?,?,?,?)";
			PreparedStatement state = conn.prepareStatement(qrystate);
			state.setString(1, request.getParameter("empno"));
			state.setString(2, request.getParameter("ename"));
			state.setString(3, request.getParameter("hiredate"));
			state.setInt(4, Integer.parseInt(request.getParameter("salary")));
			state.setString(5, request.getParameter("deptno"));
			state.setString(6, request.getParameter("title"));
			state.execute();
			out.append("<h3>資料輸入完成</h3>");
			state.close();
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
