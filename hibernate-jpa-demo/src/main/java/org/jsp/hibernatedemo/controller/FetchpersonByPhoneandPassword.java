package org.jsp.hibernatedemo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hibernatejpademo.dto.Person;

public class FetchpersonByPhoneandPassword {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your phone to print the details");
	long phone = sc.nextLong();
	System.out.println("Enter your password to print the details");
	String password= sc.next();
	String qry = "select p from Person p where p.phone=?1 and p.password=?2";
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1,phone);
	q.setParameter(2, password);
	List<Person> persons = q.getResultList();
	if(persons.size()>0)
	{
		for(Person p:persons)
		{
			System.out.println("ID" + p.getId());
			System.out.println("Name" + p.getName());
			System.out.println("Phone" + p.getPhone());
			System.out.println("-------------------------------");
		}
	}
	else
	{
		System.out.println("No user found with the name :" +phone + password);
	}	
}
}
