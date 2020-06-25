package com.dxc.pojos;

public class User 
{
	private int userid,account;
	private String name,password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid,int account, String name, String password) {
		super();
		this.userid = userid;
		this.account = account;
		this.name = name;
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
