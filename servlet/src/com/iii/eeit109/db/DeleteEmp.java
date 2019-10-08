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


@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    public DeleteEmp() {
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
			String qrystate="delete from employee where empno=?";
			PreparedStatement state = conn.prepareStatement(qrystate);
			state.setString(1, request.getParameter("empno"));
			state.execute();
			out.append("<h3>員工編號"+request.getParameter("empno")+"資料已刪除</h3>");
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
