package com.pubhub100_310814106031_core1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pubhub100_310814106031_core1.model.Book;
import com.pubhub100_310814106031_core1.util.ConnectionUtil;

public class BookDAO {
	public void save(Book book) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement("INSERT INTO books (NAME,price) VALUES (?,?)");
			pst.setString(1,book.getName());
			pst.setInt(2,book.getPrice());
			pst.executeUpdate();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
	}
	@SuppressWarnings("null")
	public void alterPrice(Book book) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
		    connection.prepareStatement("UPDATE books SET price=? WHERE NAME=?");
			pst.setInt(1,book.getPrice());
			pst.setString(2,book.getName());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
				
				pst.close();
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	
	}
	public void deleteName(Book book) {
		Connection connection = null;
		
	PreparedStatement pst = null;
	try {
		connection = ConnectionUtil.getConnection();
		pst = connection.prepareStatement("DELETE  FROM books WHERE price=? ");
		pst.setInt(1,book.getPrice());
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			pst.close();
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}  
	@SuppressWarnings("finally")
	public List<Book> findByName( Book book ) {
		Connection connection = null;
		
	PreparedStatement pst = null;
	ResultSet rs = null;
	try {
		connection = ConnectionUtil.getConnection();
		pst = connection.prepareStatement("SELECT  NAME,price FROM books WHERE NAME=?");
		pst.setString(1,book.getName());
		rs = pst.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			pst.close();
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	List<Book> lists =new ArrayList<Book>();
	
	try {
		while(rs.next()){
			Book book1=new Book();
			try {
				book1.setName(rs.getString(1));
				book1.setPrice(rs.getInt(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lists.add(book1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			pst.close();
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return lists;
	}
}  
	public List<Book> findAll() {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement("SELECT NAME,price FROM books");
			rs = pst.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
		    	
    	List<Book> list =new ArrayList<Book>();
    	
    	try {
			while(rs.next()){
				Book book2=new Book();
				book2.setName(rs.getString(1));
				book2.setPrice(rs.getInt(2));
				list.add(book2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
    	
		}
	
		
		List<Book> list = null;
		return list;
	
    	}
	}


