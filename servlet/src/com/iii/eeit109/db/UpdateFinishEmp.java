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

@WebServlet("/UpdateFinishEmp")
public class UpdateFinishEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public UpdateFinishEmp() {
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
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String deptno = request.getParameter("deptno");
		String title = request.getParameter("title");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String qrystate = "Update employee Set ename=?,hiredate=?,salary=?,deptno=?,title=? Where empno=?";
			PreparedStatement state = conn.prepareStatement(qrystate);
			state.setString(1, ename);
			state.setString(2, hiredate);
			state.setString(3, salary);
			state.setString(4, deptno);
			state.setString(5, title);
			state.setString(6, empno);
			state.executeUpdate();
			out.append("<h2>修改資料成功</h2>");
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			String qryStmt = "Select * From employee Where empno = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empno);
			ResultSet rs = stmt.executeQuery();
			out.write("<html><body>");
			out.write("<div align=center><h2>員工資料</h2>");
			if (rs.next()) {
				out.write("<table>");
				out.write("<tr><td>員工編號<td>" + rs.getString("empno"));
				out.write("<tr><td>姓名<td>" + rs.getString("ename"));
				out.write("<tr><td>到職日<td>" + rs.getString("hiredate").substring(0, 10));
				out.write("<tr><td>薪水<td>" + rs.getString("salary"));
				out.write("<tr><td>部門編號<td>" + rs.getString("deptno"));
				out.write("<tr><td>職稱<td>" + rs.getString("title"));
				out.write("</table></div>");
			} else {
				out.write("<h2>查無此員工資料</h3>");
			}
			out.write("</html></body>");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
