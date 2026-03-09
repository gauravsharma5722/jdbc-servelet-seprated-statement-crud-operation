package jdbc_servelet_seprated_statement_crud_operation.controller;

import java.time.LocalDate;

import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;
import jdbc_servelet_seprated_statement_crud_operation.dto.Employee;

public class InsertEmployeeController {

	public static void main(String[] args) {
		EmployeeDao dao=new EmployeeDao();
		Employee employee=new Employee();
		
		employee.setId(4567);
		employee.setName("kamal");
		employee.setEmail("kama;@123");
		employee.setPassword("kamal445");
		employee.setPhone(8742980);
		employee.setDob(LocalDate.parse("2003-11-10"));
		employee.setDoj(LocalDate.parse("2024-06-10"));
		
		Employee employee2=dao.saveEmployeeDao(employee);
		String msg=employee2!=null?"data inserted successfully":"something went wrong";
		System.out.println(msg);
		
	}
}
