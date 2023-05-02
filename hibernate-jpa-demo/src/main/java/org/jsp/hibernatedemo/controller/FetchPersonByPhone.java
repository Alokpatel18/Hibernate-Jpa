package org.jsp.hibernatedemo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hibernatejpademo.dto.Person;

public class FetchPersonByPhone {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your phone to print the details");
	long phone = sc.nextLong();
	String qry = "select p from Person p where p.phone=?1";
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1,phone);
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
	else {
		System.out.println("NO users found with the name : " + phone);
	}
}
}
