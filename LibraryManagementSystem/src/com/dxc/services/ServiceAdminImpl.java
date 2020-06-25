package com.dxc.services;

import java.util.List;

import com.dxc.dao.DaoAdminImpl;
import com.dxc.dao.IDaoAdmin;
import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class ServiceAdminImpl implements IServiceAdmin
{
	
	IDaoAdmin dao = new DaoAdminImpl();

	@Override
	public void addBook(Book b) {
		dao.addBook(b);
		
	}

	@Override
	public void removeBook(int id) {
		dao.removeBook(id);
	}

	@Override
	public List<Book> seeAllBooks() {
		return dao.seeAllBooks();
		
	}

	@Override
	public List<Integer> userBooks(int id) {
		
		return dao.userBooks(id);
	}

	@Override
	public int userAccount(int id) {
		
		return dao.userAccount(id);
	}

	@Override
	public void addMoney(int id, int amt) 
	{
		dao.addMoney(id, amt);
	}

	@Override
	public void addUser(User user) 
	{
		dao.addUser(user);
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}

	@Override
	public void terminateAdmin() {
		dao.terminateAdmin();
	}

	@Override
	public boolean AdminLogIn(int id, String password) {
		
		return dao.adminLogin(id, password);
	}

}
