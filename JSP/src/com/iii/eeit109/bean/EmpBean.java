package com.iii.eeit109.bean;

import java.io.Serializable;

public class EmpBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String empno,ename,hiredate,salary,deptno,title;
	
	public String getEmpNo() {return empno;}
	public String getEname() {return ename;}
	public String getHiredate() {return hiredate;}
	public String getSalary() {return salary;}
	public String getDeptno() {return deptno;}
	public String getTitle() {return title;}
	
	public void setEmpNo(String empno) {this.empno=empno;}
	public void setEname(String ename) {this.ename=ename;}
	public void setHiredate(String hiredate) {this.hiredate=hiredate;}
	public void setSalary(String salary) {this.salary=salary;}
	public void setDeptno(String deptno) {this.deptno=deptno;}
	public void setTitle(String title) {this.title=title;}

}
