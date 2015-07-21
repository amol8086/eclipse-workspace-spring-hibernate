package com.gslab.sample.standalone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.gslab.sample.entity.Message;

public class HibernateStandalone {
	private SessionFactory sessionFactory;
	
	public HibernateStandalone() {
		createSessionFactory();
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private void createSessionFactory() {
		Configuration configuration = new Configuration().
			//addPackage("com.gslab.sample.entity").configure().
			addAnnotatedClass(com.gslab.sample.entity.Message.class).configure();
	
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void closeSessionFactory() {
		getSessionFactory().close();
	}

	public static void main(String[] args) {
		HibernateStandalone standalone = new HibernateStandalone();
		Session session = standalone.getSessionFactory().openSession();
		
		List<Message> messages = session.createCriteria(Message.class).list();
		System.out.println("\nMessages Size : " + messages.size());
	    for (Message message : messages) {
			System.out.println("\nMessage Text: " + message.getPreDefinedMessageText());
			System.out.println("Gender: " + message.getGender());
			System.out.println("Age: " + message.getAge());
			System.out.println("\n");
		}
		session.close();
		standalone.closeSessionFactory();
		
	}
}
