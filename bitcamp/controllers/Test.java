package com.bitcamp.controllers;

import com.bitcamp.serviceimpls.AccountServiceImpl;
import com.bitcamp.services.AccountService;

public class Test {
	public static void main(String[] args) {
		AccountService s = new AccountServiceImpl();
		s.createAccountNum();
		
	}
}
