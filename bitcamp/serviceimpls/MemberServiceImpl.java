package com.bitcamp.serviceimpls;
import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private AdminBean[] admins;
	private CustomerBean[]customers;
	private int cCount, aCount;
	public MemberServiceImpl() {
		customers = new CustomerBean[10];
		admins = new AdminBean[10];
		cCount =0;
		aCount =0;
	}
	//------------------------------------
	public void join(CustomerBean param) {
		customers[cCount] = param;
		cCount++;
	}
	public void register(AdminBean param) {
		admins[aCount] = param;
		aCount++;
	}
	//-------------------------------------
	public CustomerBean[] findAllCustomers() {
		return customers;
	}
	public AdminBean[] findAllAdmins() {
		return admins;
	}
	//-------------------------------------
	public MemberBean[] findbyName(String name) {
		int num =0, num2=0,num3 =0;
		for(int i=0; i<cCount; i++) {
			if(name.equals(this.customers[i].getName())) {
			num ++;	
			break;
			}
		}
		for(int i=0; i<aCount; i++) {
			if(name.equals(this.admins[i].getName())) {
			num2 ++;
			break;
			}
		}
		num3 = num+num2;
		MemberBean[] members = new MemberBean[num3];
		int j=0;
		for(int i=0; i<cCount; i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;	
				if(num == j) {
					break;
				}
			}
			
		}
		int k =0;
		for(int i =0; i<aCount;i++){
			if(name.equals(admins[i].getName())) {
				members[j] = admins[i];
				k++;
				j++;
				if(num2 == k) {
					break;
				}
			}
		}
		return members;
	}

	public MemberBean findbyId(String id) {
		MemberBean customer = new MemberBean();
		for(int i=0; i<cCount; i++) {
			if(id.equals(customers[i].getId())) {
				customer = customers[i];
				break;
			}
		}
		for(int i=0; i<aCount; i++) {
			if(id.equals(admins[i].getId())) {
				customer = admins[i];
				break;
			}
		}
		return customer;
	}
	
	
	public boolean login(MemberBean param) {
		return findbyId(param.getId())
				.getPw()
				.equals(param.getPw());
	}

	public int countCustomers() {
		return cCount;
	}
	
	public int countAdmins() {
		return aCount;
	}
	
	public boolean existId(String id) {
		boolean flag = false;
		for(int i=0; i<cCount; i++) {
			if(id.equals(customers[i].getId())) {
				flag = true;
				break;
			}
		}
		for(int i=0; i<aCount; i++) {
			if(id.equals(admins[i].getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void updatePw(MemberBean param) {
		String id = param.getId();
		String[]pw = param.getPw().split(",");
		String currPw = pw[0];
		String newPw = pw[1];
		param.setId(currPw);
		if(login(param)) {
			for(int i=0;i< cCount;i++) {
				if(id.equals(customers[i].getId())) {
					customers[i].setPw(currPw);;
					break;
				}
			}
			for(int i=0;i< aCount;i++) {
				if(id.equals(admins[i].getId())) {
					admins[i].setPw(newPw);
					break;
				}
			}
		}
	}
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			for(int i=0; i<cCount; i++) {
				if(param.getId().equals(customers[i].getId())) {
					customers[i] = customers[cCount-1];
					cCount--;
					break;
				}
			}
			//--------------------------------------------
			for(int i=0; i<aCount; i++) {
				if(param.getId().equals(admins[i].getId())) {
					admins[i] = admins[aCount-1];
					admins[aCount-1] = null;
					aCount--;
					break;
				}
			}
		}
	}
		
//		int num =0;
//		MemberBean[] members = null;
//		MemberBean[] temp = null;
//		for(int i=0; i<count; i++) {
//			if(login(param)){
//				temp[i] = customers[i];
//				count--;
//			}
//		}
//			members = new MemberBean[count-1];
//			for(int i=0; i<cCount; i++) {
//				members[i] = temp[i];
//		}
	
	
}
