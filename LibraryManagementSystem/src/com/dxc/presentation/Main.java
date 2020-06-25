package com.dxc.presentation;

import java.util.Scanner;

import com.dxc.services.IServiceAdmin;
import com.dxc.services.IServiceUser;
import com.dxc.services.ServiceAdminImpl;
import com.dxc.services.ServiceUserImpl;

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int choice;
		IServiceAdmin admin = new ServiceAdminImpl();
		IServiceUser user   = new ServiceUserImpl();
		
		
		while(true)
		{
			System.out.println("1.Administrator Login\n2.User Login\n3.To end Session ");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter admin id:");
				int aid=sc.nextInt();
				System.out.println("Enter password");
				String apass =sc.next();
				boolean login = false;
				login=admin.AdminLogIn(aid, apass);
				if(login)
				{
				int ch;
				while(true)
				{
				Admin Ad = new Admin();
				System.out.println("----------------------------------------------------------------");
				System.out.println("1.Add Book");
				System.out.println("2.Remove book");
				System.out.println("3.See all books");
				System.out.println("4.Books taken by user");
				System.out.println("5.Account of particular user");
				System.out.println("6.Add Money to user account");
				System.out.println("7.Add user");
				System.out.println("8.Delete user");
				System.out.println("9.Terminate Session");
				ch=sc.nextInt();
				Ad.Adminoptions(ch);
				}
				}
				else
				{
					System.out.println("Wrong Credentials!!!");
					break;
				}
				
			case 2:
				System.out.println("Enter user id:");
				int uid=sc.nextInt();
				System.out.println("Enter password");
				String upass =sc.next();
				boolean ulogin = false;
				ulogin= user.userLogin(uid, upass);
				if(ulogin)
				{
				while(true)
				{
				int ch1;
				Useroptions us = new Useroptions();
				System.out.println("------------------------------------------------------------------");
				System.out.println("1.Issue Book");
				System.out.println("2.See book by Author");
				System.out.println("3.See all books");
				System.out.println("4.See Account balance");
				System.out.println("5.Change Password");
				System.out.println("6.Return book");
				System.out.println("7.Terminate Session");
				ch1=sc.nextInt();
				us.useroptions(ch1,uid);
				}
				}
				else
				{
					System.out.println("Wrong Credentials");
					break;
				}
				
			case 3:
				  admin.terminateAdmin();
				  user.terminateuser();
				  System.exit(0);
				  
				
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

}
