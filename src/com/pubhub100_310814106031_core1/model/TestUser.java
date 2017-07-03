package com.pubhub100_310814106031_core1.model;

import com.pubhub100_310814106031_core1.model.User;

public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
	       user.setId(1);
	       user.setName("day");
	       user.setEmailId("dh13@gmail.com");
	       user.setPassword("12");
	       user.setConfirmPassword("12");
	       
	       System.out.println(user.getId());
	       System.out.println(user.getName());
	       System.out.println(user.getEmailId());
	       System.out.println(user.getPassword());
	       System.out.println(user.getConfirmPassword());
	      
	       System.out.println(user);
	}

}
