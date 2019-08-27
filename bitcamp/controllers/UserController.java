package com.bitcamp.controllers;
import javax.swing.JOptionPane;

import com.bitcamp.domains.CustomerBean;
import com.bitcamp.serviceimpls.AccountServiceImpl;
import com.bitcamp.serviceimpls.MemberServiceImpl;
import com.bitcamp.services.AccountService;
import com.bitcamp.services.MemberService;
public class UserController {
	public static void main(String[] args) {
		AccountService accService = new AccountServiceImpl();
		MemberService memService = new MemberServiceImpl();
		CustomerBean customer;
		String temp="";
		String[] arr = null;
		while(true) {
			switch(JOptionPane.showInputDialog(""
					+ "0.종료\n"
					+ "1.가입\n"
					+ "2.계좌등록\n"
					+ "3.이름찾기\n"
					+ "4.아이디찾기\n"
					+ "5.로그인\n"
					+ "6.고객수\n"
					+ "7.아이디사용여부\n"
					+ "8.비밀번호변경")) {
			case "0": return;
			case "1"://가입
				customer = new CustomerBean();
				temp = JOptionPane.showInputDialog("아이디,비번,이름,주민번호앞자리");
				arr = temp.split(",");
				customer.setId(arr[0]);
				customer.setPw(arr[1]);
				customer.setName(arr[2]);
				customer.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, memService.join(customer));
				break;
			case "2": //계좌등록
				
				break;
			case "3": //이름찾기
				temp = JOptionPane.showInputDialog("이름 입력");
				JOptionPane.showMessageDialog(null,memService.findbyName(temp));
				break;
			case "4": //아이디찾기
				temp =JOptionPane.showInputDialog("ID입력");
				JOptionPane.showMessageDialog(null,memService.findbyId(temp));				
				break;
			case "5": //로그인
				temp =JOptionPane.showInputDialog("아이디, 비번입력");
				arr = temp.split(",");
				customer = new CustomerBean();
				customer.setId(arr[0]);
				customer.setPw(arr[1]);
				JOptionPane.showMessageDialog(null, memService.login(customer));
				break;
			case "6": //고객수
				JOptionPane.showMessageDialog(null, memService.countCustomers());
				break;
			case "7": //아이디사용여부
				temp =JOptionPane.showInputDialog("아이디입력");
				JOptionPane.showMessageDialog(null, memService.existId(temp));
				break;
			case "8": //비번변경
				temp =JOptionPane.showInputDialog("아이디,현재비번입력,새로운비밀번호");
				arr = temp.split(",");
				customer = new CustomerBean();
				customer.setId(arr[0]);
				customer.setPw(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null, memService.updatePw(customer));
				break;
			}
		}
	}
}
