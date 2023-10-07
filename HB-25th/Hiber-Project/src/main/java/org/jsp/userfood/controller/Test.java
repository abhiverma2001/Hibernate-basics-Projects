package org.jsp.userfood.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.userfood.dao.FoodOrderDao;
import org.jsp.userfood.dao.UserDao;
import org.jsp.userfood.dto.FoodOrder;
import org.jsp.userfood.dto.User;

public class Test{
	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	static Scanner sc = new Scanner(System.in);
	static FoodOrderDao fdao = new FoodOrderDao();
	static UserDao udao = new UserDao();
	public static void main(String[] args) {
		System.out.println("1-->Save the User");
		System.out.println("2-->Verify the User(Email & Password)");
		System.out.println("3-->Add the FoodOrder");
		System.out.println("4-->Update the User");
		System.out.println("5-->Update the FoodOrder");
		System.out.println("6-->Fetch the FoodOrders by User Id");
		System.out.println("7-->Fetch the FoodOrders By User Email and Password");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			save();
			break;
		case 2:
			varifyUserByEmailAndPassword();
			break;
		case 3:
			addFoodOrder();
			break;
		case 4:
			updateUser();
			break;
		case 5:
			updateFood();
			break;
		case 6:
			fetchFoodbyId();
			break;
		case 7:
			fetchFoodbyEmailAndpassword();
			break;
		
		}
	}
	public static void save()
	{
		System.out.println("Enter name,gender,email,phone,password");
		String name = sc.next();
		String gender = sc.next();
		String email = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u.setEmail(email);
		u.setGender(gender);
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		User uid = udao.saveUser(u);
		System.out.println("User has been saved "+uid.getId());
	}
	public static void varifyUserByEmailAndPassword()
	{
		System.out.println("Email and Password ");
		String email = sc.next();
		String password = sc.next();
		User u = udao.varifyEamilAndPassowrd(email, password);
		System.out.println(u);
	}
	public static void addFoodOrder()
	{
		System.out.println("Enter id to be added");
		int id  = sc.nextInt();
		System.out.println("price,address,itemname");
		int price = sc.nextInt();
		String address = sc.next();
		String itemname = sc.next();
		FoodOrder f = new FoodOrder();
		f.setAddress(address);
		f.setItemname(itemname);
		f.setPrice(price);
		fdao.addFood(f, id);
		System.out.println("Food added successfully");
		
	}
	
public static void updateUser()
{
	System.out.println("Enter id to be updated");
	int id = sc.nextInt();
	System.out.println("name,gender,email,phone,password");
	String name = sc.next();
	String gender = sc.next();
	String email = sc.next();
	long phone = sc.nextLong();
	String password = sc.next();
	User u = manager.find(User.class, id);
	u.setEmail(email);
	u.setGender(gender);
	u.setName(name);
	u.setPassword(password);
	u.setPhone(phone);
	udao.updateUser(u);
	System.out.println("user has been updated ");
}
public static void fetchFoodbyId()
{
	System.out.println("Enter id to be fetched");
	int id = sc.nextInt();
	List<FoodOrder> food=fdao.fetchFoodByUserId(id);
	for(FoodOrder f : food)
	{
		System.out.println(f);
	}
}
public static void fetchFoodbyEmailAndpassword()
{
	System.out.println("Enter Email and Password");
	String email = sc.next();
	String password = sc.next();
	List<FoodOrder> list = fdao.fetchFoodbyUserAndPassword(email, password);
	for(FoodOrder f:list)
	{
		System.out.println(f);
	}
}
public static void updateFood()
{
	System.out.println("Enter id to be updated");
	int id = sc.nextInt();
	System.out.println("Enter price, adress,itemname");
	int price = sc.nextInt();
	String address = sc.next();
	String itemname = sc.next();
	FoodOrder f = manager.find(FoodOrder.class, id);
	f.setAddress(address);
	f.setItemname(itemname);
	f.setPrice(price);
	fdao.updateFoo(f, id);
}

}
