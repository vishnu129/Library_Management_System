package com.dxc.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Book;
import com.dxc.services.IServiceUser;
import com.dxc.services.ServiceUserImpl;

public class Useroptions 
{
	IServiceUser user   = new ServiceUserImpl();
	Scanner sc = new Scanner(System.in);
	public void useroptions(int ch,int uid)
	{
		switch(ch)
		{
		case 1:
			List<Book> books = new ArrayList<>();
			books=user.seeAllBooks();
			for(Book b:books)
			{
				b.display();
			}
			System.out.print("Enter book Id to issue book: ");
			user.takeBook(sc.nextInt(),uid);
			System.out.println();
			break;
			
		case 2:
				List<Book> author = new ArrayList<>();
				System.out.print("Enter the author name to search for books:");
				
				author=user.authorBook(sc.nextLine());
				for(Book b:author)
				{
					b.display();
				}
				
				break;
		case 3:
			List<Book> allbooks = new ArrayList<>();
			allbooks=user.seeAllBooks();
			for(Book b:allbooks)
			{
				b.display();
			}
			break;
			
		case 4:
				int bal=user.accountBal(uid);
				System.out.println("Your Account Balance is: "+bal+" Rs");
				System.out.println();
				break;
			
		case 5:
				System.out.print("Enter new password: ");
				user.changePassword(sc.next(),uid);
				break;
		case 6:
				System.out.print("Enter bookid to return: ");
				int bid=sc.nextInt();
				System.out.print("\nEnter number of days: ");
				int days=sc.nextInt();
				user.returnBook(uid, bid, days);
				break;
			
		case 7:
				user.terminateuser();
				System.exit(0);
				break;
		default:
			System.out.println("Wrong option. Choose again!!!");
			break;
		
		}
	}
}
