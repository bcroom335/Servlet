package com.iii.eeit109.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetAllEmps")
public class GetAllEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    public GetAllEmps() {
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
		PrintWriter out = response.getWriter();
		int count=0;
		try {
				String qrystate="select * from employee";
				PreparedStatement state = conn.prepareStatement(qrystate);
				ResultSet rs = state.executeQuery();
				out.append("<html><body>");
				out.append("<div align=center><h2>員工資料</h2>");
				out.append("<table border=1><tr>");
				out.append("<th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱");
		while(rs.next()) {
			out.append("<tr><td>"+rs.getString("empno"));
			out.append("<td>"+rs.getString("ename"));
			out.append("<td>"+rs.getString("hiredate").substring(0,10));
			out.append("<td>"+rs.getString("salary"));
			out.append("<td>"+rs.getString("deptno"));
			out.append("<td>"+rs.getString("title"));
			count++;
		}
		out.append("</table><h3>共"+count+"筆員工資料</h3></div></body></html>");
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
