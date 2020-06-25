package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public interface IDaoAdmin {
	public boolean adminLogin(int id,String password);
	public void addBook(Book b);
	public void removeBook(int id);
	public List<Book> seeAllBooks();
	public List<Integer> userBooks(int id);
	public int userAccount(int id);
	public void addMoney(int id,int amt);
	public void addUser(User user);
	public void deleteUser(int id);	
	public void terminateAdmin();

}
