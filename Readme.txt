4 sql tables are required to implement this project..

books(id int pk,bookname,authorname,quantity)

adminlogin(adminid int pk,name,password)

users(userid int pk,name,password,account)

userbooks(userid int fk,bookid)
