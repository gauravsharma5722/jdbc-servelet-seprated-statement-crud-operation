package jdbc_servelet_seprated_statement_crud_operation.servlet.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;
import jdbc_servelet_seprated_statement_crud_operation.dto.Employee;

public class RegisterEmployeeController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
//		String id = req.getParameter("id");
		
	   int originalid = Integer.parseInt(req.getParameter("id"));
	   String name = req.getParameter("name");
	   String email = req.getParameter("email");
	   String password = req.getParameter("password");
	   long phone = Long.parseLong(req.getParameter("phone"));
	   LocalDate doj = LocalDate.parse(req.getParameter("doj"));
	   LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		
		
	   Employee employee = new Employee();
	   
	   employee.setId(originalid);
	   employee.setName(name);
	   employee.setEmail(email);
	   employee.setPassword(password);
	   employee.setPhone(phone);
	   employee.setDob(dob);
	   employee.setDoj(doj);
	   System.out.println(employee);
	   EmployeeDao dao=new EmployeeDao();
	   
	  Employee emp=dao.saveEmployeeDao(employee);
	  
	  PrintWriter printWriter=resp.getWriter();
	  
	  if(emp!=null) {
//		  printWriter.write("you are registered");
		  printWriter.write("<html><body><h3 style='color:green'>you are registered</h3></body></html>");
		  System.out.println("data registered");
	  }else {
//		  printWriter.write("something went wrong");
		  printWriter.write("<html><body><h3 style='color:red;'>something went wrong</h3></body></html>");
		  System.out.println("something went wrong");
	  }
	}
}