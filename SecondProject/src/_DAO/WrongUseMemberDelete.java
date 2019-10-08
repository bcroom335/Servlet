package _DAO;

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

@WebServlet("/MemberDelete")
public class WrongUseMemberDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection conn;
    public void init() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl="jdbc:sqlserver://localhost:1433;databaseName=FirstIndependentStudy";
			conn = DriverManager.getConnection(connUrl,"sa","password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String qryStmt = "Select * From member Where seqNo = ?";
            PreparedStatement stmt = conn.prepareStatement(qryStmt);
            stmt.setInt(1, Integer.parseInt(request.getParameter("seqNo")));
            ResultSet rs = stmt.executeQuery();
            out.write("<html><body>");
            out.write("<div align=center><h2>會員資料</h2>");
            out.write("<form method='post' action='MemDeleteC'>");
            if(rs.next()) {
                out.write("<table>");
                out.write("<tr><td>會員編號："+ rs.getInt("seqNo"));
                out.write("<input type='hidden' name='seqNo' value=" + rs.getInt("seqNo") + "><td>");
                out.write("<tr><td>姓名：" + rs.getString("name"));
                out.write("<tr><td>生日："+ rs.getString("birth"));
                out.write("<tr><td>地址："+ rs.getString("address"));
                out.write("<tr><td>e-mail："+ rs.getString("email"));
                out.write("<tr><td>電話："+ rs.getString("tel"));
                out.write("</table>");           
            }        
            out.write("<input type='submit' value='確定刪除'></form>");   
            out.write("</div></html></body>");            
            stmt.close();
        }catch (SQLException e) {
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
