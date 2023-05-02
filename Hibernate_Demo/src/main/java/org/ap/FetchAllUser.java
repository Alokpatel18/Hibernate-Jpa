package org.ap;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchAllUser {

		public static void main(String[] args) {
			Scanner sc= new Scanner (System.in);
			Session s = new Configuration().configure().buildSessionFactory().openSession();
		
			Query<User> q = s.createQuery("select u from User u");
			
			List<User> user=q.getResultList();
			for(User u:user)
			{
				System.out.println("ID " + u.getId());
				System.out.println("Name " + u.getName());
				System.out.println("Phone " + u.getPhone());
				System.out.println("Age " + u.getAge());
				System.out.println("Age " + u.getPassword());
				System.out.println("------------------------------------------------");
			}	
		}	
	}

