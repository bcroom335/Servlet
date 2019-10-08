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

@WebServlet("/GetEmp")
public class GetEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public GetEmp() {
		super();
	}

	public void init() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=servdb";
			conn = DriverManager.getConnection(connUrl, "sa", "password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		;
		String empno = request.getParameter("empno");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String qrystate = "select * from employee where empno= ?";
			PreparedStatement state = conn.prepareStatement(qrystate);
			state.setString(1, empno);
			ResultSet rs = state.executeQuery();
			out.append("<html><body>");
			out.append("<div align=center><h2>員工資料</h2>");
			if (rs.next()) {
				out.append("<table width=60%>");
				out.append("<tr><td width=30%>員工編號<td>" + rs.getString("empno"));
				out.append("<tr><td>姓名<td>" + rs.getString("ename"));
				out.append("<tr><td>到職日<td>" + rs.getString("hiredate").substring(0, 10));
				out.append("<tr><td>薪水<td>" + rs.getString("salary"));
				out.append("<tr><td>部門編號<td>" + rs.getString("deptno"));
				out.append("<tr><td>職稱<td>" + rs.getString("title"));
				out.append("</table></div>");
			}else {
				out.append("<h2>編號"+empno+"員工不存在</h2>");
			}
			out.append("</body></html>");
			state.close();
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
