package jdbc_servelet_seprated_statement_crud_operation.servlet.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc_servelet_seprated_statement_crud_operation.dao.EmployeeDao;

@WebServlet(value="/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));

		boolean b=new EmployeeDao().deleteEmployeeByIdDao(id);
		if(b)
		{
			resp.sendRedirect("display.jsp");
			System.out.println("deleted employe....."+id);
		}
		
	    
	}

}
