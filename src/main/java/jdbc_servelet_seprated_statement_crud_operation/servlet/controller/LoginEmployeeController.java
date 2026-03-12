package jdbc_servelet_seprated_statement_crud_operation.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;
import jdbc_servelet_seprated_statement_crud_operation.dto.Employee;

public class LoginEmployeeController  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		EmployeeDao dao=new EmployeeDao();
		Employee employee=dao.getEmployeeByEmailDao(email);
		 PrintWriter writer=resp.getWriter();
		 
				
		if(employee!=null)
		{
			if(employee.getPassword().equals(password))
			{
			RequestDispatcher dispatcher= req.getRequestDispatcher("display.jsp");
			 HttpSession session=req.getSession();
			session.setAttribute("EmployeeLogin", employee.getEmail());
			dispatcher.forward(req, resp);
			}
			else
			{
			  RequestDispatcher dispatcher=req.getRequestDispatcher("loginEmployee.jsp");
			  req.setAttribute("msg", "something went wrong check your password");
//			  writer.write("<html><body><h4 style='color:red;'>Given Password is Incorrect</h4></body></html>");
			  dispatcher.include(req, resp);
			}
		}
		else
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("loginEmployee.jsp");
			 req.setAttribute("msg", "something went wrong check your email");
//			  writer.write("<html><body><h4 style='color:red;'>Given Email is Incorrect</h4></body></html>");
			  dispatcher.include(req, resp);
		}
	}
}
