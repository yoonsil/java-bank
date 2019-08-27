package com.bitcamp.serviceimpls;
import com.bitcamp.domains.AccountBean;
import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;
import com.bitcomp.services.AccountService;
import java.util.Random;
public class AccountServiceImpl implements AccountService{
	
	private AdminBean[] admins;
	private AccountBean[] accounts;
	private int count;
	
	public void createAccount(int money) {
		accounts = new AccountBean[10];
		count =0;
	}

	public String createAccountNum() {
		Random ran = new Random();
		int account = ran.nextInt(3)+1;
		int account1 = ran.nextInt(3)+1;
		String result = account + "-" + account1;
		return result;
	}


	public AccountBean findbyAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for(int i=0; i<count; i++) {
			if(accountNum.equals(this.accounts[i].getAccountNum())) {
				account = this.accounts[i];
				break;
			}
		}
		
		return account;
	}

	public AccountBean[] findAll() {
		return accounts;
	}

	public int countAccounts() {
		return count;
	}

	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(int i=0; i<count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				flag = true;
			}
		}
		return flag;
	}

	public String findDate() {
		return null;
	}

	public void depositMoney(AccountBean param) {
		AccountBean account = new AccountBean();
		int money = param.getMoney();
		for(int i=0; i<count; i++) {
			if(param.equals(accounts[i].getAccountNum())) {
				money += param.getMoney();
			}
		}
		
		
	}

	public void withdrawMoney(AccountBean param) {
		AccountBean account = new AccountBean();
		int money = param.getMoney();
		for(int i=0; i<count; i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				if(param.equals(accounts[i].getAccountNum())) {
					money -= param.getMoney();
				}
			}
		}
	}

	public void deleteAccountNum(String accountNum) {
		
	}

	
}
