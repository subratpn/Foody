package pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CustomHibernateInstance {
	
	
	public static Session session ;
	public static Transaction transaction ;
	
	
	public static void getSessionTransaction(){
		
				
			   System.out.println("Creating Hibernate Session");
			   StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		       
			   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			  
			   SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			   session = factory.openSession();  
			   transaction = session.beginTransaction();  
			
			
		}
			
	}
	
