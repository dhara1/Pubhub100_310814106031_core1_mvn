package com.pubhub100_310814106031_core1.dao;

import com.pubhub100_310814106031_core1.model.Book;

public class TestBookDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book=new Book();
	       book.setId(1);
	       book.setName("java7"); 
	       book.setPrice(500);
	       System.out.println(book.getId());
	       System.out.println(book.getName());
	       System.out.println(book.getPrice());
	       System.out.println(book);
	}

}
