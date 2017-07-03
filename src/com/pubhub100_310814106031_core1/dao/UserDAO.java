package com.pubhub100_310814106031_core1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pubhub100_310814106031_core1.model.User;
import com.pubhub100_310814106031_core1.util.ConnectionUtil;

public class UserDAO {
	public void register(User user) throws Exception{
    	Connection connection=ConnectionUtil.getConnection();
    	PreparedStatement pst=connection.prepareStatement("INSERT INTO users (NAME,email_id,PASSWORD,confirm_password) VALUES (?,?,?,?)");
    	pst.setString(1,user.getName());
    	pst.setString(2,user.getEmailId());
    	pst.setString(3,user.getPassword());
    	pst.setString(4,user.getConfirmPassword());
    	pst.executeUpdate();
		
    }  
	public boolean login(User user) throws Exception{
	Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst=connection.prepareStatement("SELECT id, NAME,email_Id FROM users WHERE email_id='?' AND PASSWORD='?'");
	pst.setString(1,user.getEmailId());
	pst.setString(2,user.getPassword());
	ResultSet rs=pst.executeQuery();
	boolean flag=false;
	if(rs.next()){
		flag=true;
	}
	return flag;
	}
	
}
