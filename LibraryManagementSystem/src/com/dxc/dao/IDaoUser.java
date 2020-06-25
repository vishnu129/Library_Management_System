package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Book;

public interface IDaoUser {
	
	public boolean userLogin(int id, String password);
	public void takeBook(int bookid,int userid);
	public List<Book> authorBook(String name);
	public List<Book> seeAllBooks();
	public int accountBal(int id);
	public void changePassword(String pass,int uid);
	public void terminateuser();
	public void returnBook(int uid,int bookid,int days);

}
