package org.jsp.userproductapp.controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.userproductapp.dao.ProductDao;
import org.jsp.userproductapp.dao.UserDao;
import org.jsp.userproductapp.dto.Product;
import org.jsp.userproductapp.dto.User;

public class UserController 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("1.Register");
		System.out.println("2.Update the user");
		System.out.println("3.Verify user By Phone and password");
		System.out.println("4.Verify user By email and password");
		System.out.println("5.Add product");
		System.out.println("6.View Products By User id");
		System.out.println("7.View Products By Category");
		System.out.println("8.View Products By Brand");
		int uin = sc.nextInt();
		switch (uin) 
		{
		case 1:
				saveUser();
				break;
		case 2:
				updateUser();
			break;
		case 3:
				VerifyUserByPhPass();
			break;
		case 4:
				VerifyUserByEMPass();
			break;
		case 5:
				AddProduct();
			break;
		case 6:
				ViewProdByUserId();
			break;
		case 7:
			ViewProdBycat();
		break;
		case 8:
			ViewProdByBrand();
		break;
		default:
			break;
		}
	}
	
	
	public static void saveUser()
	{
		User u = new User();
		System.out.println("Enter Name,Email,Phone and Password");
		u.setName(sc.next());
		u.setEmail(sc.next());
		u.setPhone(sc.nextInt());
		u.setPassword(sc.next());
		u = UserDao.Saveuser(u);
		System.out.println("User Save Sucessfull with user Id : "+ u.getId());
	}

	public static void updateUser()
	{
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Id to edit the user :");
		int uid = sc.nextInt();
		User u = manager.find(User.class, uid);
		if (u!=null)
		{
			System.out.println("Enter Name,Email,Phone,Password For Modification");
			u.setId(uid);
			u.setName(sc.next());
			u.setEmail(sc.next());
			u.setPhone(sc.nextInt());
			u.setPassword(sc.next());
			u = UserDao.updateUser(u,uid);
			System.out.println("Modification Sucessfully.");
		}
		else
		{
			System.err.println("Invalid User Id ");
		}
	}
	
	public static void VerifyUserByPhPass()
	{
		System.out.println("Enter Phone And Password");
		User u = new User();
		u = UserDao.VerifyByPhoneAndPassword(u, sc.nextLong(), sc.next());
	}
	public static void VerifyUserByEMPass()
	{
		System.out.println("Enter Email And Password");
		User u = new User();
		u = UserDao.VerifyByEmailAndPassword(u, sc.next(), sc.next());
	}
	public static void AddProduct()
	{
		System.out.println("Enter User Id");
		int uid = sc.nextInt();
		System.out.println("Enter name,brand,category,price");
		Product p = new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setPrice(sc.nextInt());
		p = ProductDao.AddProduct(p,uid);
		System.out.println("Product Save Sucessfully. Id Is : "+ p.getName());
	}

	public static void ViewProdByUserId()
	{
		System.out.println("Enter User Id to Show Product :");
		Product p = new Product();
		p = ProductDao.ViewById(p, sc.nextInt());
	}
	public static void ViewProdBycat()
	{
		System.out.println("Enter Category to Show Product :");
		Product p = new Product();
		p = ProductDao.ViewBycat(p, sc.next());
	}
	public static void ViewProdByBrand()
	{
		System.out.println("Enter Brand to Show Product :");
		Product p = new Product();
		p = ProductDao.ViewByBrand(p, sc.next());
	}

}
