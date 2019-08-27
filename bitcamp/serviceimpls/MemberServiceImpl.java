package com.bitcamp.serviceimpls;
import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;
import com.bitcomp.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private AdminBean[] admin;
	private CustomerBean[] customers;
	private int cusCount;
	private int adCount;
	//---------------------------------
	public MemberServiceImpl() {
		customers = new CustomerBean[10];
		cusCount =0;
	}
	//------------------------------------
	public String join(CustomerBean param) {
		String msg = "가입완료";
		customers[cusCount] = param;
		cusCount++;
		return msg;
	}

	public CustomerBean[] findAllCustomers() {
		customers = new CustomerBean[cusCount];
		for(int i=0; i<cusCount; i++) {
			customers[i] = this.customers[i];
		}
		
		return customers;
	}

	public CustomerBean[] findbyName(String name) {
		int num =0;
		for(int i=0; i<cusCount; i++) {
			if(name.equals(this.customers[i].getName())) {
			num ++;	
			}
		}
		CustomerBean[] customers = new CustomerBean[num];
		num =0;
		for(int i=0; i<cusCount; i++) {
			if(name.equals(this.customers[i].getName())) {
				customers[i] = this.customers[i];
				num ++;	
				}if(customers.length==num) {
					break;
				}
		}
		return customers;
	}

	public CustomerBean findbyId(String id) {
		CustomerBean customer = new CustomerBean();
		for(int i=0; i<cusCount; i++) {
			if(id.equals(customers[i].getId())) {
				customer = customers[i];
				break;
			}
		}
		return customer;
	}

	public boolean login(CustomerBean param) {
		boolean flag = false;
		for(int i=0; i<cusCount; i++) {
			if(param.getId().equals(customers[i].getId())&&
				param.getPw().equals(customers[i].getPw())) {
				flag = true;
				break;
			}
			
		}
		return flag;
	}

	public int countCustomers() {
		return cusCount;
	}

	public boolean existId(String id) {
		boolean flag = true;
		for(int i=0; i<cusCount; i++) {
			if(id.equals(customers[i].getId())) {
				flag = false;
			}
		}
		return flag;
	}

	public String updatePw(MemberBean param) {
		String id = param.getId();
		String pw = param.getPw();
		String[] arr = pw.split(",");
		String currPw = arr[0];
		String newPw = arr[1];
		String msg ="변경실패";
		for(int i=0; i<cusCount; i++) {
			if(currPw.equals(customers[i].getId())) {
				customers[i].setPw(newPw);
				msg ="변경완료";
				break;
				}
			}
			return msg;
		}

	public void deleteMember(MemberBean param) {
		
	}

	public AdminBean[] findAllAdmins() {
		admin = new AdminBean[adCount];
		for(int i=0; i<adCount; i++) {
			
		}
		return admin;
	}

	public int countAdmins() {
		return 0;
	}

}
