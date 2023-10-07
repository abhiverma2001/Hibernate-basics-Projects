package org.jsp.userfood.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.userfood.dto.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	public User saveUser(User user)
	{
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}
	public User updateUser(User user)
	{
		manager.merge(user);
		transaction.begin();
		transaction.commit();
		return user;
	}
	public User varifyEamilAndPassowrd(String email,String passowrd)
	{
		String query = "select u from User u where u.email=?1 and u.password=?2";
		Query q = manager.createQuery(query);
		q.setParameter(1, email);
		q.setParameter(2, passowrd);
		return (User)q.getSingleResult();
	}
}
