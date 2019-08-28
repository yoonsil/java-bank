package com.bitcamp.services;

import com.bitcamp.domains.*;

public interface MemberService {
	public void join(CustomerBean param);
	public void register(AdminBean param);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public MemberBean[] findbyName(String name);
	public MemberBean findbyId(String id);
	public boolean login(MemberBean param);
	public int countCustomers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePw(MemberBean param);
	public void deleteMember(MemberBean param);
	
}
