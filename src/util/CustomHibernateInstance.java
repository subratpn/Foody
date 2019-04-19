package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CustomHibernateInstance {
	
	private static Session session;
	
	public static Session getSession(){
		
				
		if(session == null) {
			   System.out.println("Creating Hibernate Session");
			   StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
			   System.out.println("Creating Hibernate Session 1");  
			   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			   System.out.println("Creating Hibernate Session 2"); 
			   SessionFactory factory = meta.getSessionFactoryBuilder().build(); 
			   System.out.println("Creating Hibernate Session 3"); 
			   session = factory.openSession();
		}
		
		return session;
			     
			
			
	}
	
	
			
	}
	
