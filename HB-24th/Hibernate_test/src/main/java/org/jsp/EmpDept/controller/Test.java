package org.jsp.EmpDept.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.EmpDept.dao.DepartmentDao;
import org.jsp.EmpDept.dao.EmployeeDao;
import org.jsp.EmpDept.dto.Department;
import org.jsp.EmpDept.dto.Employee;

public class Test {
static Scanner sc=new Scanner(System.in);
static EmployeeDao edo=new EmployeeDao();
static DepartmentDao ddao=new DepartmentDao();
static EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
static EntityTransaction transaction=manager.getTransaction();
public static void main(String[] args) {
	System.out.println("1:>Save the Department");
	System.out.println("2:>Add the Employee for the Department");
	System.out.println("3:>Update the Department");
	System.out.println("4:>Update the Employee in the Department");
	System.out.println("5:>View the Employee present in the Department by Department Id");
	System.out.println("6:>View the Employee present in the Department by Department Name");
	System.out.println("7:>Delete the Employee in the Department");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
	{
		saveDept();
		break;
	}
	case 2:
	{
		addEmp();
		break;
	}
	case 3:
	{
		updateDept();
		break;
	}
	case 4:
	{
		updateEmp();
		break;
	}
	case 5:
	{
		findEmpByD_id();
		break;
	}
	case 6:
	{
		findEmpByD_name();
		break;
	}
	case 7:
	{
		deleteEmp();
		break;
	}
	}
}
public static void addEmp() {
	System.out.println("Enter Employee id to find");
	int id=sc.nextInt();
	Department d=manager.find(Department.class, id);
	if(d!=null) {
		System.out.println("Enter Employee name,designation and salary");
		String name=sc.next();
		String designation=sc.next();
		double salary=sc.nextDouble();
		Employee e=new Employee();
		e.setName(name);
		e.setDesignation(designation);
		e.setSalary(salary);
		Employee emp=edo.saveEmployee(e, id);
		if(emp!=null)
			System.out.println("Employee saved with id:"+emp.getId()+"with dept id:"+d.getId());
		else
			System.out.println("Employee not saved");
	}
}
public static void saveDept() {
System.out.println("Enter Department name and location");
String name=sc.next();
String location=sc.next();
Department d=new Department();
d.setName(name);
d.setLocation(location);
d=ddao.saveDepartment(d);
System.out.println("Department saved with id:"+d.getId());
}
public static void updateDept() {
System.out.println("Enter Department id,name and location");
int id=sc.nextInt();
String name=sc.next();
String location=sc.next();
Department d=new Department();
d.setId(id);
d.setName(name);
d.setLocation(location);
d=ddao.updateDepartment(d);
System.out.println("Department updated enter id:"+d.getId());
}
public static void updateEmp() {
System.out.println("Enter department id to find");
int id=sc.nextInt();
Department d=manager.find(Department.class, id);
Department di=ddao.findDeptById(id);
if(d!=null)
	System.out.println("Enter Employee id,name,designation and salary");
int eid=sc.nextInt();
String name=sc.next();
String designation=sc.next();
double salary=sc.nextDouble();
Employee e=new Employee();
e.setId(eid);
e.setName(name);
e.setDesignation(designation);
e.setSalary(salary);
Employee emp=edo.updateEmployee(e, id);
if(emp!=null)
	System.out.println("Employee updated id"+emp.getId()+"where dept id"+d.getId());
else
	System.out.println("Employee not updated");
}
public static void findEmpByD_name() {
	System.out.println("Enter deptname to find Employees");
	String name=sc.next();
	List<Employee> list=edo.findEmpByDeptName(name);
	if(list.size()>0) {
		for(Employee e:list)
			System.out.println(e.getName());
	}
	else {
		System.out.println("Employee not found");
	}
}
public static void findEmpByD_id() {
	System.out.println("Enter dept_id to find Employees");
	int id=sc.nextInt();
	List<Employee> list=edo.findEmployeeDeptId(id);
	if(list.size()>0) {
		for(Employee e:list)
			System.out.println(e.getName());
	}
	else {
		System.out.println("Employee not found");
	}
}
public static void deleteEmp() {
	System.out.println("Enter the Employee id to delete Employee");
	int did=sc.nextInt();
	System.out.println("Enter the Employee id to delete the Employee");
	int eid=sc.nextInt();
	edo.deleteEmp(did,eid);
}
}
