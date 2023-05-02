package org.jsp.hibernatedemo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsp.hibernatejpademo.dto.Person;

public class FetchPersonById {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your id to print the Details");
	int id =sc.nextInt();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	Person p = manager.find(Person.class, id  );
	if(p != null)
	{
		System.out.println("ID " + p.getId());
		System.out.println("Name " + p.getName());
		System.out.println("Phone Number " + p.getPhone());
		
	}else
	{
		System.out.println("Invalid ID");
	}
	
}
}
