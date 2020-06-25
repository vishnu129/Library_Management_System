package com.dxc.services;

import java.util.List;

import com.dxc.dao.DaoUserimpl;
import com.dxc.dao.IDaoUser;
import com.dxc.pojos.Book;

public class ServiceUserImpl implements IServiceUser
{
	IDaoUser udao = new DaoUserimpl();

	@Override
	public void takeBook(int bookid,int userid) {
		udao.takeBook(bookid,userid);
		
	}

	@Override
	public List<Book> authorBook(String name) {
		return udao.authorBook(name);
	}

	@Override
	public List<Book> seeAllBooks() 
	{
		return udao.seeAllBooks();
	}

	@Override
	public int accountBal(int id) {

		return udao.accountBal(id);
	}

	@Override
	public void changePassword(String pass,int uid) {
		udao.changePassword(pass,uid);
	}

	@Override
	public void terminateuser() {
		udao.terminateuser();
		
	}

	@Override
	public boolean userLogin(int id, String password) {
		return udao.userLogin(id, password);
	}

	@Override
	public void returnBook(int uid, int bookid, int days) {
		udao.returnBook(uid, bookid, days);
		
	}

}
