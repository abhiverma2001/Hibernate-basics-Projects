package org.jsp.EmpDept.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.EmpDept.dto.Department;

public class DepartmentDao {
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction transaction=manager.getTransaction();
public Department saveDepartment(Department d) {
	manager.persist(d);
	transaction.begin();
	transaction.commit();
	return d;
}
public Department updateDepartment(Department d) {
	manager.merge(d);
	transaction.begin();
	transaction.commit();
	return d;
}
public Department findDeptById(int d_id) {
	return manager.find(Department.class,d_id);
}
}

