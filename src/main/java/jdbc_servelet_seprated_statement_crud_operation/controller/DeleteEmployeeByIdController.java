package jdbc_servelet_seprated_statement_crud_operation.controller;
import java.util.Scanner;

import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;
public class DeleteEmployeeByIdController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of employee to be deleted");
		int id=sc.nextInt();
		EmployeeDao dao=new EmployeeDao();
		boolean a=dao.deleteEmployeeByIdDao(id);
		String msg=a?"Data deleted":"Something went wrong";
		System.out.println(msg);
	}
}
