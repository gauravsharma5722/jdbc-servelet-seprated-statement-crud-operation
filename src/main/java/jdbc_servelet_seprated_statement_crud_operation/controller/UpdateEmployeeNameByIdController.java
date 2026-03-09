package jdbc_servelet_seprated_statement_crud_operation.controller;

import java.util.Scanner;

import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;
import jdbc_servelet_seprated_statement_crud_operation.dto.Employee;

public class UpdateEmployeeNameByIdController {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of employee whose name must be updated ");
		int id=sc.nextInt();
		System.out.println("enter the name of emplyee ");
		String name=sc.next();
		EmployeeDao dao=new EmployeeDao();
		boolean a=dao.updateEmployeeNameByEmployeeIdDao(name, id);
//		String msg=a?"Data Updated":"Something went wrong !!!";
//		System.out.println(msg);
		if(a)
		{
			System.out.println("Data Updated");
			Employee employee=dao.getEmployeeByIdDao(id);
			System.out.println("updated employee is........");
			System.out.println(employee);
		}
		else
		{
			System.out.println("Something went Wrong");
		}
	}
}
