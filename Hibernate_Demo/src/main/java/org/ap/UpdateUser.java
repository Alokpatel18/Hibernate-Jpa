package org.ap;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your existing id to update");
	int id = sc.nextInt();
	System.out.println("enter your name,age,Phone,and password to update ");
	String name = sc.next();
	int age =sc.nextInt();
	long phone = sc.nextLong();
	String password = sc.next();
	User u =new User();
	u.setId(id);
	u.setName(name);
	u.setAge(age);
	u.setPhone(phone);
	u.setPassword(password);
	Session s =new Configuration().configure().buildSessionFactory().openSession();
	s.update(u);
	Transaction t = s.beginTransaction();
	t.commit();
	System.out.println("user detail are updated");	
}
}
