package org.jsp.userproductapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userproductapp.dto.Product;
import org.jsp.userproductapp.dto.User;

public class ProductDao 
{
	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	public static Product AddProduct(Product products,int uid)
	{
		User u = manager.find(User.class, uid);
		if (u!=null)
		{
			u.getProducts().add(products);
			products.setUser(u);
			EntityTransaction t = manager.getTransaction();
			manager.persist(products);
			t.begin();
			t.commit();
		}
		return products;
	}
	
	public static Product ViewById(Product product, int id)
	{
		Query q = manager.createQuery("select p from Product p where user_id=?1");
		q.setParameter(1, id);
		List<Product> p = q.getResultList();
		for(Product pp:p)
		{
			System.out.println(pp);
		}
		return product;
	}
	public static Product ViewByBrand(Product product, String bname)
	{
		Query q = manager.createQuery("select p from Product p where brand=?1");
		q.setParameter(1, bname);
		List<Product> p = q.getResultList();
		for(Product pp:p)
		{
			System.out.println(pp);
		}
		return product;
	}
	public static Product ViewBycat(Product product, String bname)
	{
		Query q = manager.createQuery("select p from Product p where category=?1");
		q.setParameter(1, bname);
		List<Product> p = q.getResultList();
		for(Product pp:p)
		{
			System.out.println(pp);
		}
		return product;
	}

}
