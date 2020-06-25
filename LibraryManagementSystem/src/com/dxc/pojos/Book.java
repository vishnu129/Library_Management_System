package com.dxc.pojos;

public class Book {

	private int id,quantity;
	private String bookname;
	private String authorname;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String bookname, String authorname, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.bookname = bookname;
		this.authorname = authorname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public void display()
	{   
		System.out.println("------------------------------------------------------------");
		System.out.println("Book Id: "+id);
		System.out.println(" "+bookname+" |Authored by:- "+authorname+"| number of copies available: "+quantity +" nos" );
		System.out.println();
	}
	
}
