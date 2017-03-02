package by.zyablov.first.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.zyablov.first.hibernate.dto.UserDetails;

public class HibernateTest {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("Stas");
		user.setAddress("User's address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user");

		SessionFactory sessionFectory = new Configuration().configure().buildSessionFactory();
		sessionFectory.openSession();

		Session session = sessionFectory.openSession();

		session.beginTransaction();
		session.save(user);

		session.getTransaction().commit();

		sessionFectory.close();
	}
}
