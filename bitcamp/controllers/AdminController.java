package com.bitcamp.controllers;
import javax.swing.JOptionPane;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.serviceimpls.AccountServiceImpl;
import com.bitcamp.services.AccountService;
public class AdminController {
	public static void main(String[] args) {
		String temp ="";
		AccountBean account = null;
		AccountService service = new AccountServiceImpl(); 
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료"
					+ "\n-------관리자 기능---------\n"
					+ "1. 계좌 생성 \n"
					+ "2. 계좌 정보 보기 \n"
					+ "3. 계좌번호 조회하기 \n"
					+ "4. 계좌 수 확인 \n"
					+ "5. 존재하는 계좌 확인 \n"
					+ "6. 예금 \n"
					+ "7. 인출 \n"
					+ "8. 계좌 삭제 ")) {
			case "0": return;
			case "1": 
				service.createAccount(Integer
						.parseInt(JOptionPane
						.showInputDialog("개설할 계좌에 금액을 입력")));
				break;
			case "2": 
				JOptionPane.showMessageDialog(null,
						service.findAll());
				break;
			case "3": 
				JOptionPane.showMessageDialog(null,
						service.createAccountNum());
				break;
			case "4": 
				JOptionPane.showMessageDialog(null,
						service.countAccounts());
				break;
			case "5": 
				service.existAccountNum(
						JOptionPane.showInputDialog("계좌확인"));
						JOptionPane.showMessageDialog(null,
							(service.existAccountNum
							(JOptionPane.showInputDialog
							("계좌확인")))?"존재":"없음");	
				break;
			case "6":
				String[] arr = JOptionPane.showInputDialog("예금입력").split(",");
				account = new AccountBean();
				account.setAccountNum(arr[0]);
				account.setMoney(arr[1]);
				service.depositMoney(account);
				break;
			case "7":
				arr = JOptionPane.showInputDialog("출금입력").split(",");
				account = new AccountBean();
				account.setAccountNum(arr[0]);
				account.setMoney(arr[1]);
				service.withdrawMoney(account);
				break;
			case "8":
				temp = JOptionPane.showInputDialog("계좌번호입력");
				service.deleteAccountNum(temp);
				break;
			
			}
		}
	}
}
