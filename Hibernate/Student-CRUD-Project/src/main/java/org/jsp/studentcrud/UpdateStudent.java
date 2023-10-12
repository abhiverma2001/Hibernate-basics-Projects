package org.jsp.studentcrud;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter you Student Id to update the details");
	int sid=sc.nextInt();
	System.out.println("Enter the name,course,phone,email and password");
	String name=sc.next();
	String course=sc.next();
	long phone=sc.nextLong();
	String email=sc.next();
	String password=sc.next();
	Student st=new Student();
	st.setId(sid);
	st.setName(name);
	st.setCourse(course);
	st.setPhone(phone);
	st.setEmail(email);
	st.setPassword(password);
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	s.update(st);
	t.commit();
}
}
