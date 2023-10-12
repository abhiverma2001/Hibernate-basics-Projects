package org.jsp.studentcrud;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchStudent {
 public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your ID to display the details");
	int id=sc.nextInt();
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Student st=s.get(Student.class, id);
	if(st!=null) {
		System.out.println("ID:"+st.getId());
		System.out.println("Name:"+st.getName());
        System.out.println("Course:"+st.getCourse());
        System.out.println("Phone:"+st.getPhone());
       System.out.println("Email:"+st.getEmail());
		System.out.println("Password:"+st.getPassword());
    }else {
		System.out.println("You have entered Invalid ID");
	}
}
}
