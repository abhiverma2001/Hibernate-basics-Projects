package org.jsp.userproductapp.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.userproductapp.dto.User;

public class UserDao 
{
	public static  EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	public static User Saveuser(User users)
	{
		EntityTransaction t = manager.getTransaction();
		manager.persist(users);
		t.begin();
		t.commit();
		return users;
	}
	
	public static User updateUser(User upUser,int uid)
	{
		
		EntityTransaction t = manager.getTransaction();
		manager.merge(upUser);
		t.begin();
		t.commit();
		return upUser;
	}
	public static User VerifyByPhoneAndPassword(User userVerifyByPhonePass,long ph, String pass)
	{
		Query q = manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, ph);
		q.setParameter(2, pass);
		
		User u = (User) q.getSingleResult();
		
		try {
			System.out.println(u.getName());
			System.out.println(u.getEmail());
		} catch (NoResultException e) {
			System.out.println("Record Not Found");
		}
		return userVerifyByPhonePass;
	}
	public static User VerifyByEmailAndPassword(User userVerifyByPhonePass,String Em, String pass)
	{
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, Em);
		q.setParameter(2, pass);
		
		User u = (User) q.getSingleResult();
		
		try {
			System.out.println(u.getName());
			System.out.println(u.getEmail());
		} catch (NoResultException e) {
			System.out.println("Record Not Found");
			return null;
		}
		return userVerifyByPhonePass;
	}
	
	
}
