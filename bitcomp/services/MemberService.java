package com.bitcomp.services;

import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;

public interface MemberService {
	public String join(CustomerBean param);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public MemberBean[] findbyName(String name);
	public MemberBean findbyId(String id);
	public boolean login(CustomerBean param);
	public int countCustomers();
	public int countAdmins();
	public boolean existId(String id);
	public String updatePw(MemberBean param);
	public void deleteMember(MemberBean param);
	
}
