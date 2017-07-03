package com.pubhub100_310814106031_core1.dao;

public class TestBookDAO {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BookDAO  dao=new BookDAO();
		try {
			dao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}

}
