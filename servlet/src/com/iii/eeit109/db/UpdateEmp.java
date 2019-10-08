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


@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    public UpdateEmp() {
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
			String qrystate="select * from employee where empno= ?";
			PreparedStatement state = conn.prepareStatement(qrystate);
			state.setString(1, request.getParameter("empno"));
			ResultSet rs = state.executeQuery();
			out.append("<html><body>");
			out.append("<div align=center><h2>員工資料</h2>");
			out.append("<table border=1><tr>");
			out.append("<form method=\"post\" action=\"UpdateFinishEmp\">");
			if (rs.next()) {
				out.append("<tr><td>員工編號<td><input type='text' name='empno' value="+rs.getString("empno")+">");
				out.append("<tr><td>姓名<td><input type='text' name='ename' value="+rs.getString("ename")+">");
				out.append("<tr><td>到職日<td><input type='text' name='hiredate' value="+rs.getString("hiredate")+">");
				out.append("<tr><td>薪水<td><input type='text' name='salary' value="+rs.getString("salary")+">");
				out.append("<tr><td>部門編號<td><input type='text' name='deptno' value="+rs.getString("deptno")+">");
				out.append("<tr><td>職稱<td><input type='text' name='title' value=" + rs.getString("title")+">");
			}else {
				out.append("<h2>編號"+request.getParameter("empno")+"員工不存在</h2>");
			}
			out.append("</table><input type='submit' value='確定修改'>");
			out.append("</form></div></body></html>");
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
