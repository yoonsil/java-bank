package com.bitcamp.domains;

public class AdminBean extends MemberBean{
	private int employeeNum;
	
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	public int getEmployeeNum() {
		return employeeNum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
