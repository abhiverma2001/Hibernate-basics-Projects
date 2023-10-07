package org.jsp.userfood.dao;
import java.util.List;
import javax.persistence.*;
import org.jsp.userfood.dto.FoodOrder;
import org.jsp.userfood.dto.User;

public class FoodOrderDao {
EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction transaction = manager.getTransaction();
public FoodOrder addFood(FoodOrder foodorder,int id)
{
	User u = manager.find(User.class,id);
	if(u!=null)
	{
		u.getFoodorders().add(foodorder);
		foodorder.setUsers(u);
		manager.persist(foodorder);
		transaction.begin();
		transaction.commit();
		return foodorder;
	}
	else {
		return null;
	}
}
public FoodOrder updateFoo(FoodOrder foodorder, int id)
{
	FoodOrder f = manager.find(FoodOrder.class, id);
	if(f!=null)
	{
		manager.merge(foodorder);
		transaction.begin();
		transaction.commit();
		return foodorder;
	}
	return null;
}
public List<FoodOrder> fetchFoodByUserId(int id)
{
	String query = "select u.foodorders from User u where u.id=?1";
	Query q = manager.createQuery(query);
	q.setParameter(1, id);
	return q.getResultList();
}
public List<FoodOrder> fetchFoodbyUserAndPassword(String email,String password)
{
	String query = "select u.foodorders from User u where u.email=?1 and u.password=?2";
	Query q = manager.createQuery(query);
	q.setParameter(1, email);
	q.setParameter(2, password);
	return q.getResultList();
}

}
