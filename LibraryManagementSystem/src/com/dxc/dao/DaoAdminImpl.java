package com.dxc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class DaoAdminImpl implements IDaoAdmin {
	private static Connection conn;
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root","pass");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void addBook(Book b) {
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("insert into books values(?,?,?,?)");
			pstmt.setInt(1, b.getId());
			pstmt.setString(2, b.getBookname());
			pstmt.setString(3, b.getAuthorname());
			pstmt.setInt(4, b.getQuantity());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void removeBook(int id) {
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("delete from books where id = ?");
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Book> seeAllBooks() {
		List<Book> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from books");
				while(rset.next())
				{
					Book b = new Book(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
					list.add(b);
				}
				return list;	
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		 
	}
	@Override
	public List<Integer> userBooks(int id) {
		PreparedStatement pstmt;
		List<Integer> userbooks = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select bookid from userbooks where userid = ?");
			pstmt.setInt(1, id);
			ResultSet rset =pstmt.executeQuery();
			while(rset.next())
			{
				userbooks.add(rset.getInt(1));
			}
			
			return userbooks;
		}
			catch(Exception e)
			{
				System.out.println("User id do not found!!!!!");
				return null;
			}
				
			}
	
	@Override
	public int userAccount(int id) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select account from users where userid = ?");
			pstmt.setInt(1, id);
			ResultSet rset =pstmt.executeQuery();
			rset.next();
			int ac = rset.getInt(1);
			return ac;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("User id not found!!!!!!!!\n");
			return -1;
		}		
	}
	
	
	@Override
	public void addMoney(int id, int amt) 
	{
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select account from users where userid = ?");
			pstmt.setInt(1, id);
			ResultSet rset =pstmt.executeQuery();
			rset.next();
			int ac = rset.getInt(1);
			ac = ac+amt;
			PreparedStatement pstmt1 = conn.prepareStatement("update users set account =? where userid = ?");
			pstmt1.setInt(1, ac);
			pstmt1.setInt(2, id);
			pstmt1.execute();
			System.out.println("User "+id+" new balance is "+ac);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("User id not found!!!!!!!!\n");
		}
	}
	@Override
	public void addUser(User user) {

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("insert into users values(?,?,?,?)");
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getAccount());
			pstmt.execute();
			
			System.out.println("New user created!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteUser(int id) {

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("delete from users where userid = ?");
			pstmt.setInt(1, id);
			pstmt.execute();
			System.out.println("User with id "+id+ " has been deleted....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The user id do not exist");
		}
		
		
	}
	@Override
	public void terminateAdmin() 
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean adminLogin(int id, String password) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select password from adminlogin where adminid=?");
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			String pw = rset.getString(1);
			if((pw.compareTo(password)==0))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("Admin id not found");
		}
		return false;
	}


}
