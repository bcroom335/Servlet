package com.iii.eeit109.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.eeit109.bean.EmpBean;

public interface IEmpDao {
	public void add(EmpBean emp) throws SQLException;
	public void update(EmpBean emp) throws SQLException;
	public void delete(EmpBean emp) throws SQLException;
	public  ArrayList<EmpBean> FindById(EmpBean emp) throws SQLException;
	public void creatconn() throws SQLException;
	public void closeconn() throws SQLException;
}
