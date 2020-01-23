package com.michael;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args ){
    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory=meta.getSessionFactoryBuilder().build();
    	Session session=factory.openSession();
    	Transaction t1=session.beginTransaction();
    	
    	//Address a1= new Address("1126 HighField Ct","Bethel Park","PA","USA");
    	Address a1= new Address("1126 HighField Ct","Bethel Park","PA","USA");
    	Address a2= new Address("1128 HighField Ct","Bethel Park","PA","USA");
    	Address a3= new Address("1129 HighField Ct","Bethel Park","PA","USA");
    	
    
    	Employee e1=new Employee(1001,"Ackkk",a1);
    	Employee e2=new Employee(1002,"Winter",a2);
    	Employee e3=new Employee(1003,"Summer",a3);
    	
    	session.save(e1);session.save(e2);session.save(e3);
    	t1.commit();
    	factory.close();
    	session.close();
    }
}
