package org.jsp.hibernatedemo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hibernatejpademo.dto.Person;

public class FindAllJPQL {
public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery("Sselect p from Person p");
	List<Person> persons = q.getResultList();
	for(Person p: persons)
	{
     System.out.println(p);
	}	
}
}
