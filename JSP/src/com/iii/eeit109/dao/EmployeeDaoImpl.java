package com.iii.eeit109.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.eeit109.bean.EmpBean;

public class EmployeeDaoImpl implements IEmpDao{
	private static final String insert_state=
			"Insert into employee(empno,ename,hiredate,salary,deptno,title)values(?,?,?,?,?,?)";
	private static final String update_state=
			"Update employee Set ename=?, hiredate=?, salary=?, deptno=?, title=? Where empno=?";
	private static final String delete_state=
			"Delete from Where empno=?";
	private static final String getone_state=
			"Select * From employee Where empno=?";
	private static final String getall_state=
			"Select * From employee ";
	
	Connection conn=null;
		
	@Override
	public void add(EmpBean emp) throws SQLException {
		PreparedStatement state = conn.prepareStatement(insert_state);
		state.setString(1, emp.getEmpNo());
		state.setString(2, emp.getEname());
		state.setString(3, emp.getHiredate());
		state.setInt(4, Integer.parseInt(emp.getSalary()));
		state.setString(5, emp.getDeptno());
		state.setString(6, emp.getTitle());
		state.execute();

		state.close();		
	}

	@Override
	public void update(EmpBean emp) throws SQLException {
		PreparedStatement state = conn.prepareStatement(update_state);
		state.setString(1, emp.getEname());
		state.setString(2, emp.getHiredate());
		state.setInt(3, Integer.parseInt(emp.getSalary()));
		state.setString(4, emp.getDeptno());
		state.setString(5, emp.getTitle());
		state.setString(6, emp.getEmpNo());
		state.execute();
		state.close();
		
	}

	@Override
	public void delete(EmpBean emp) throws SQLException {
		PreparedStatement state = conn.prepareStatement(delete_state);
		state.setString(1, emp.getEmpNo());
		state.execute();
		state.close();
	}

	@Override
	public ArrayList<EmpBean> FindById(EmpBean emp) throws SQLException {
		PreparedStatement state = conn.prepareStatement(getone_state);
		state.setString(1, emp.getEmpNo());
		ResultSet rs = state.executeQuery();
		if(rs.next()) {
			EmpBean eb=new EmpBean();
			eb.setEmpNo(rs.getString("empno"));
			eb.setEname(rs.getString("ename"));
			eb.setHiredate(rs.getString("hiredate").substring(0,10));
			eb.setSalary(rs.getString("salary"));
			eb.setDeptno(rs.getString("deptno"));
			eb.setTitle(rs.getString("title"));
		}
		
		state.close();
		return null ;
	}
	
	public  ArrayList<EmpBean> getall() throws SQLException {
		ArrayList<EmpBean> emps = new ArrayList<>();
		PreparedStatement state = conn.prepareStatement(getall_state);
		ResultSet rs = state.executeQuery();
		while(rs.next()) {
			EmpBean eb=new EmpBean();
			eb.setEmpNo(rs.getString("empno"));
			eb.setEname(rs.getString("ename"));
			eb.setHiredate(rs.getString("hiredate").substring(0,10));
			eb.setSalary(rs.getString("salary"));
			eb.setDeptno(rs.getString("deptno"));
			eb.setTitle(rs.getString("title"));
			emps.add(eb);
		}
		
		state.close();
		return emps;
	}

	@Override
	public void creatconn() throws SQLException{
		String connUrl="jdbc:sqlserver://localhost:1433;databaseName=servdb";
		conn = DriverManager.getConnection(connUrl,"sa","password");
		
	}

	@Override
	public void closeconn() throws SQLException {
		conn.close();
		
	}

}
