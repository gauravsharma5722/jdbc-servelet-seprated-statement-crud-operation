package jdbc_servelet_seprated_statement_crud_operation.controller;
import java.util.Scanner;

import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;
import jdbc_servelet_seprated_statement_crud_operation.dto.Employee;
public class GetEmployeeByIdController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of employee ");
		int id=sc.nextInt();
		EmployeeDao dao=new EmployeeDao();
		Employee employee=dao.getEmployeeByIdDao(id);
		
	}
}
