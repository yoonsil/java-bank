package com.bitcamp.domains;

public class AccountBean extends MemberBean{
	private String accountNum, transactionDate, money;
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMoney() {
		return money;
	}
	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accountNum + ", 거래일자=" + transactionDate + ", 금액 =" + money
				+ "]";
	}
	
	
	
	
	
}
