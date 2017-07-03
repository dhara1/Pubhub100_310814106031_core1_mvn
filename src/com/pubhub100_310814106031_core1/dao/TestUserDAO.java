package com.pubhub100_310814106031_core1.dao;

import com.pubhub100_310814106031_core1.dao.UserDAO;
import com.pubhub100_310814106031_core1.model.User;

public class TestUserDAO {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		User user=new User();
	       
	       user.setName("day");
	       user.setEmailId("dh23@gmail.com");
	       user.setPassword("132");
	      
	       UserDAO dao=new UserDAO();
	       dao.register(user);
	}

}
