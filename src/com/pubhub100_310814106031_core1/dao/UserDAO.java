package com.pubhub100_310814106031_core1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pubhub100_310814106031_core1.model.User;
import com.pubhub100_310814106031_core1.util.ConnectionUtil;

public class UserDAO {
	public void register(User user){
    	Connection connection=ConnectionUtil.getConnection();
    	PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("INSERT INTO users (NAME,email_id,PASSWORD,confirm_password) VALUES (?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst.setString(1,user.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst.setString(2,user.getEmailId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst.setString(3,user.getPassword());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			pst.setString(4,user.getConfirmPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }  
	public boolean login(User user) {
	Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst = null;
	try {
		pst = connection.prepareStatement("SELECT id, NAME,email_Id FROM users WHERE email_id='?' AND PASSWORD='?'");
		pst.setString(1,user.getEmailId());
		pst.setString(2,user.getPassword());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ResultSet rs = null;
	try {
		rs = pst.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	boolean flag=false;
	try {
		if(rs.next()){
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
	}
	
}
