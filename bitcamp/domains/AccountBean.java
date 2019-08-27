package com.bitcamp.domains;

public class AccountBean extends MemberBean{
	private String accountNum, transactionDate; 
	private int money;
	
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
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	
	public String toString() {
		return String.format("계좌번호:%s\n"
				+ "거래일:%s\n"
				+ "잔금:%d\n", accountNum, transactionDate , money);
	}
	
	
	
}
