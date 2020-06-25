package com.dxc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.dxc.pojos.Book;

public class DaoUserimpl implements IDaoUser
{
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
	public void takeBook(int bookid,int userid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into userbooks values(?,?)");
			PreparedStatement pstmt1 = conn.prepareStatement("select quantity from books where id =?");
			PreparedStatement pstmt2 = conn.prepareStatement("update books set quantity=? where id =?");
			
			pstmt1.setInt(1, bookid);
			ResultSet rset = pstmt1.executeQuery();
			rset.next();
			int nos = rset.getInt(1);
			if(nos!=0)
			{
			nos--;
			
			pstmt.setInt(1, userid);
			pstmt.setInt(2, bookid);
			pstmt.execute();
			
			pstmt2.setInt(1, nos);
			pstmt2.setInt(2, bookid);
			pstmt2.execute();			
			}
			else
			{
				System.out.println("That book not availaale");
			}
		} catch (SQLException e) {
			System.out.println("Book id not found. Check book id again!!");
		}
	}
	
	
	@Override
	public List<Book> authorBook(String name) {
		
		List<Book> authlist = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from books where authorname =?");
			pstmt.setString(1, name);
			ResultSet rset = pstmt.executeQuery();
				while(rset.next())
				{
					Book b = new Book(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
					authlist.add(b);
				}
				return authlist;	
			} catch (Exception e) {
				System.out.println("Sorry.. We do not have any books by that author..\n Check back later...");
				System.out.println();
				return null;
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
	public int accountBal(int id) {
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("select account from users where userid=?");
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			int bal = rset.getInt(1);
			return bal;
			} 
		
			catch (Exception e) 
			{
				e.printStackTrace();
				return 0;
				}
		
	}
		
	@Override
	public void changePassword(String pass,int uid) 
	{
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("update users set password=? where userid=?");
			
			pstmt.setString(1, pass);
			pstmt.setInt(2, uid);
			pstmt.execute();
		    System.out.println("Password Changed successfully");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		
		
	}
	@Override
	public void terminateuser() {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public boolean userLogin(int id, String password)
	{
		try {
			PreparedStatement pstmt = conn.prepareStatement("select password from users where userid = ?");
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
		
		}
		catch(SQLException e)
		{
			
			System.out.println("User id not found!!");
			return false;
		}
		
		
	}


	@Override
	public void returnBook(int uid, int bookid, int days) {
	
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from userbooks where userid=? AND bookid=? ");
			PreparedStatement pstmt1 = conn.prepareStatement("select quantity from books where id =?");
			PreparedStatement pstmt2 = conn.prepareStatement("update books set quantity=? where id =?");
			PreparedStatement pstmt3 = conn.prepareStatement("select account from users where userid =?");
			PreparedStatement pstmt4 = conn.prepareStatement("update users set account=? where userid =?");
			
			pstmt.setInt(1, uid);
			pstmt.setInt(2, bookid);
			pstmt.execute();
			
			pstmt1.setInt(1, bookid);
			ResultSet rset = pstmt1.executeQuery();
			rset.next();
			int nos = rset.getInt(1);
			nos++;
			
			pstmt2.setInt(1, nos);
			pstmt2.setInt(2, bookid);
			pstmt2.execute();
			
			pstmt3.setInt(1, uid);
			ResultSet rset2 = pstmt3.executeQuery();
			rset2.next();
			int amt = rset2.getInt(1);
			amt = amt-(days*5);
			
			pstmt4.setInt(1, amt);
			pstmt4.setInt(2, uid);
			pstmt4.execute();
			
			System.out.println("Book returned...");
			System.out.println(days*5+" is deducted from account");
			
		} catch (SQLException e) {
			System.out.println("Book id not found. Check book id again!!");
		}
	}
}


