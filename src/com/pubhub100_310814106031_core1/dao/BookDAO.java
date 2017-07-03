package com.pubhub100_310814106031_core1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pubhub100_310814106031_core1.model.Book;
import com.pubhub100_310814106031_core1.util.ConnectionUtil;

public class BookDAO {
	public void save(Book book) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst=connection.prepareStatement("INSERT INTO books (NAME,price) VALUES (?,?)");
	pst.setString(1,book.getName());
	pst.setInt(2,book.getPrice());
	pst.executeUpdate();
	}
	public void alterPrice(Book book) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst=connection.prepareStatement("UPDATE books SET price=? WHERE NAME=?");
	pst.setInt(1,book.getPrice());
	pst.setString(2,book.getName());
	pst.executeUpdate();
	}
	public void deleteName(Book book) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst=connection.prepareStatement("DELETE  FROM books WHERE price=? ");
	pst.setInt(1,book.getPrice());
	pst.executeUpdate();
}  
	public List<Book> findByName( Book book ) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst=connection.prepareStatement("SELECT  NAME,price FROM books WHERE NAME=?");
	pst.setString(1,book.getName());
	ResultSet rs=pst.executeQuery();
	List<Book> lists =new ArrayList<Book>();
	
	while(rs.next()){
		Book book1=new Book();
		book1.setName(rs.getString(1));
		book1.setPrice(rs.getInt(2));
		lists.add(book1);
	}
	return lists;
	
}  
	public List<Book> findAll() throws Exception{
		Connection connection=ConnectionUtil.getConnection();
    	PreparedStatement pst=connection.prepareStatement("SELECT NAME,price FROM books");
    	ResultSet rs=pst.executeQuery();
    	
    	List<Book> list =new ArrayList<Book>();
    	
    	while(rs.next()){
    		Book book2=new Book();
    		book2.setName(rs.getString(1));
    		book2.setPrice(rs.getInt(2));
    		list.add(book2);
    	}
		return list;
    		
    	}
}
