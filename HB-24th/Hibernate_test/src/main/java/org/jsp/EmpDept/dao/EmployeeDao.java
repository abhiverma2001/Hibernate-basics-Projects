package org.jsp.EmpDept.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.EmpDept.dto.Department;
import org.jsp.EmpDept.dto.Employee;

public class EmployeeDao {
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction transaction=manager.getTransaction();
public Employee saveEmployee(Employee e,int d_id) {
	Department d=manager.find(Department.class, d_id);
			if(d!=null) {
				d.getEmployees().add(e);
				e.setDepartment(d);
				manager.persist(e);
				transaction.begin();
				transaction.commit();
				return e;
			}
			return null;
} 
public Employee updateEmployee(Employee e,int d_id) {
	Department d=manager.find(Department.class, d_id);
	if(d!=null) {
		d.getEmployees().add(e);
		e.setDepartment(d);
		manager.merge(e);
		transaction.begin();
		transaction.commit();
		return e;
	}
	return null;
}
public List<Employee> findEmployeeDeptId(int d_id){
	Query q=manager.createQuery("select d.employees from Department d where d.id=?1 ");
	q.setParameter(1, d_id);
	return q.getResultList();
}
public List<Employee> findEmpByDeptName(String name){
	Query q=manager.createQuery("select d.employees from Department d where d.name=?1");
	q.setParameter(1, name);
	return q.getResultList();
	}
public void deleteEmp(int d_id,int e_id) {
	Department d=manager.find(Department.class, d_id);
	if(d!=null) {
		Employee e=manager.find(Employee.class, e_id);
		if(e!=null) {
			e.setDepartment(null);
			manager.remove(e);
			transaction.begin();
			transaction.commit();
			System.out.println("employee deleted successfully");
		}
		else {
			System.out.println("department not found");
		}
	}
}
}
