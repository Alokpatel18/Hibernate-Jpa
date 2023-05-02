package org.ap;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;



public class FetchUser {
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter your Id for print the details");
		int id =sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		User u = s.find(User.class, id);
		if(u!=null)
		{
			System.out.println("ID " + u.getId());
			System.out.println("Name " + u.getName());
			System.out.println("Phone " + u.getPhone());
			System.out.println("Age " + u.getAge());
		}
		else
		{
			System.err.println("You hav entered Invalid id");
		}
			
	}	
}