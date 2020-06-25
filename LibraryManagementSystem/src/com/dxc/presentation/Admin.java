package com.dxc.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;
import com.dxc.services.IServiceAdmin;
import com.dxc.services.ServiceAdminImpl;

public class Admin 
{
	IServiceAdmin admin = new ServiceAdminImpl();
	Scanner sc = new Scanner(System.in);
	public void Adminoptions(int ch)
	{
		
		switch(ch)
		{
		case 1:
			int id,nos;
			String name;
			String author;
			System.out.print("Enter Book name: ");
			name=sc.nextLine();
			System.out.print("\nEnter Book Author: ");
			author =sc.nextLine();
			System.out.print("\nEnter book id: ");
			id=sc.nextInt();
			System.out.print("\nEnter number of books: ");
			nos = sc.nextInt();
			
			admin.addBook(new Book(id,name,author,nos));
			break;
		case 2:
			System.out.print("Enter the book id to remove: ");
			admin.removeBook(sc.nextInt());
			break;
		case 3:
			List<Book> ls = new ArrayList<>();
			ls=admin.seeAllBooks();
			for(Book b:ls)
			{
				b.display();
			}
			break;
		case 4:
				List<Integer> books = new ArrayList<>();
				System.out.print("Enter user id to show books taken by user: ");
				books=admin.userBooks(sc.nextInt());
				int count = books.size();
				System.out.println("The user has taken "+count+" books");
				if(count!=0)
				{
				System.out.print("id of books taken by user are: ");
				for(int x:books)
				{
					System.out.print(+x+",");
				}
				}
				else
				{
					System.out.println("User has taken no books");
				}
				System.out.println();
				break;
		case 5:
			System.out.print("Enter User ID: ");
			int amount =admin.userAccount(sc.nextInt());
			if(amount !=-1)
			System.out.println("The user has "+amount+ " Rs in his account");
			break;
		case 6:
			System.out.print("Enter User ID: ");
			int id6=sc.nextInt();
			System.out.print("\nEnter Amount to add: ");
			int amt6 = sc.nextInt();
			admin.addMoney(id6, amt6);
			break;
		case 7:
			int userid,amount7;
			String name7,password;
			System.out.print("Enter user name: ");
			name7=sc.nextLine();
			password ="1234";
			System.out.print("\nEnter user id: ");
			userid=sc.nextInt();
			System.out.print("\nEnter amount to be added in account: ");
			amount7 = sc.nextInt();
			admin.addUser(new User(userid,amount7,name7,password));
			break;
			
		case 8:
			System.out.print("Enter the user id to remove: ");
			admin.deleteUser(sc.nextInt());
			break;
		case 9:
			admin.terminateAdmin();
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice choose again!!");
			break;
		}
	}

}
