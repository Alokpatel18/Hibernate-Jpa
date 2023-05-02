package org.jsp.hibernatedemo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hibernatejpademo.dto.Person;

public class FetchRecordByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name to print the details");
		String name = sc.next();
		String qry = "select p from Person p where p.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Person> persons = q.getResultList();
		if (persons.size() > 0) {
			for (Person p : persons) {
				System.out.println("ID" + p.getId());
				System.out.println("Name" + p.getName());
				System.out.println("Phone" + p.getPhone());
				System.out.println("-------------------------------");
			}
		} else {
			System.out.println("NO users found with the name : " + name);
		}
	}

}
