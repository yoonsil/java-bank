package com.bitcamp.domains;

public class AdminBean extends MemberBean{
	private int employeeNum;
	
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	public int getEmployeeNum() {
		return employeeNum;
	}
	
	public String toString() {
		return String.format("[사원정보]\n"
				+"아이디:%s\n"
				+ "비밀번호:%s\n"
				+ "이름:%s\n"
				+ "주민번호앞자리:%s\n"
				+ "사원번호:"
				,getId(),getPw(),getName(),getSsn(),employeeNum);
	}
}
