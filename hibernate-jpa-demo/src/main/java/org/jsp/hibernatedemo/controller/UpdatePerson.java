package org.jsp.hibernatedemo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hibernatejpademo.dto.Person;

public class UpdatePerson {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter the exsisting ID");
	int id = sc.nextInt();
	System.out.println("Enter your name,phone ,password to update");
	String name =sc.next();
	long phone = sc.nextLong();
	String password = sc.next();
	Person p = new Person();
	p.setId(id);
	p.setName(name);
	p.setPhone(phone);
	p.setPassword(password);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	manager.merge(p);
	transaction.begin();
	transaction.commit();
}
}
