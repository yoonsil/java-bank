package com.bitcamp.serviceimpls;
import com.bitcamp.domains.*;
import com.bitcamp.services.AccountService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class AccountServiceImpl implements AccountService{
	private AccountBean[] accounts;
	private int acnum;
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		acnum =0;
	}
	//---------------------------------
	
	public void createAccount(int money) {
		//accountNum, transactionDate, money;
		AccountBean acc = new AccountBean();
		acc.setMoney(money+"");
		acc.setAccountNum(createAccountNum());
		acc.setTransactionDate(findDate());		
		accounts[acnum] = acc;
		acnum++;
	}
	
	public String createAccountNum() {
		Random ran = new Random(); //1234-5678
		String a = ran.nextInt(10)+"";
		String result ="";
		for(int i=0;i<9;i++) {
			result += (i==4)?"-":ran.nextInt(10);
			}
		return result;
		}

	public AccountBean[] findAll() {
		return accounts;
	}
	public AccountBean findbyAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for(int i=0; i<acnum; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				account = accounts[i];
				break;
			}
		}
		
		return account;
	}

	
	public int countAccounts() {
		return acnum;
	}

	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(int i=0; i<acnum; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm")
				.format(new Date());
	}

	public void depositMoney(AccountBean param) {
		String accNum = param.getAccountNum();
		String saving = param.getMoney();
		for(int i=0; i<acnum; i++) {
			if(accNum.equals(param.getAccountNum())) {
				String accmoney = String.valueOf(Integer
						.parseInt(accounts[i]
						.getMoney())+Integer
						.parseInt(saving));
				accounts[i].setMoney(accmoney);
				accounts[i].setTransactionDate(findDate());
			}
		}
	}

	public void withdrawMoney(AccountBean param) {
		String accNum = param.getAccountNum();
		String withdraw = param.getMoney();
		for(int i=0; i<acnum; i++) {
			if(accNum.equals(param.getAccountNum())) {
				String accmoney = String.valueOf(Integer
						.parseInt(accounts[i]
						.getMoney())-Integer
						.parseInt(withdraw));
				accounts[i].setMoney(accmoney);
				accounts[i].setTransactionDate(findDate());
			}
		}
		
	}

	public void deleteAccountNum(String accountNum) {
			for(int i=0; i<acnum; i++) {
				if(accountNum.equals(accounts[i].getAccountNum())) {
					accounts[i] = accounts[acnum-1];
					accounts[acnum-1] = null;
					acnum--;
					break;
				}
			}
		}
	}