package org.jsp.studentcrud;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
  public static void main(String[] args) {
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Student ID to delete");
	int sid=sc.nextInt();
	Student st=s.get(Student.class, sid);
	if(st!=null) {
		s.delete(st);
		System.out.println("Your details are deleted Successfully!");
		t.commit();
		}else {
			System.out.println("You have entered an Invalid ID");
		}
}
}
