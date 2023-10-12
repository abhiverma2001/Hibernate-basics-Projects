package org.jsp.studentcrud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveStudent {
  public static void main(String[] args) {
	Student s=new Student();

	s.setName("Ramesh");
	s.setCourse("B.Tech");
	s.setPhone(63922022);
	s.setEmail("ram12@gmail.com");
	s.setPassword("ram12");
	Configuration cfg=new Configuration().configure();
	SessionFactory factory=cfg.buildSessionFactory();
	Session se=factory.openSession();
	se.save(s);
	Transaction t=se.beginTransaction();
	t.commit();
	System.out.println("Student saved with id:"+s.getId());
}
}
