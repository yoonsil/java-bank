package com.bitcamp.domains;

public class CustomerBean extends MemberBean{
	private String credit;
	
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCredit() {
		return credit;
	}
	
	public String toString() {
		return String.format("아이디:%s\n"
				+ "비밀번호:%s\n"
				+ "이름:%s\n"
				+ "주민번호앞자리:%s\n"
				+ "신용등급: %s"
				,super.getId(),super.getPw(),super.getName(),super.getSsn(), credit);
	}
}
