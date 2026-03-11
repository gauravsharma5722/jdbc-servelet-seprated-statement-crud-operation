package jdbc_servelet_seprated_statement_crud_operation.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_servelet_seprated_statement_crud_operation.connection.JdbcEmployeeConnection;

import jdbc_servelet_seprated_statement_crud_operation.dto.Employee;




public class EmployeeDao {

	Connection connection = JdbcEmployeeConnection.createJdbcEmployeeConnection();

	private final String INSERTINTOEMPLOYEEQUERY = "insert into Employee(id,name,email,password,phone,dob,doj) values(?,?,?,?,?,?,?)";
	
	/**
	 * saveEmployeeDao(Employee employee) method
	 * 
	 * @return Employee
	 * 
	 */ // 0x1
	public Employee saveEmployeeDao(Employee employee) {
		// 0x1
		
		try {

			PreparedStatement ps = connection.prepareStatement(INSERTINTOEMPLOYEEQUERY);

			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getPassword());
			ps.setLong(5, employee.getPhone());
			ps.setObject(6, employee.getDob());
			ps.setObject(7, employee.getDoj());

			int a = ps.executeUpdate();
			return a != 0 ? employee : null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param employeeId
	 * @return boolean
	 */
	public boolean deleteEmployeeByIdDao(int employeeId) {

		String deleteEmployeeByIdQuery = "delete from employee where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(deleteEmployeeByIdQuery);
			ps.setInt(1, employeeId);
			int a = ps.executeUpdate();

			return a != 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param name
	 * @param employeeid
	 * @return boolean
	 */
	public boolean updateEmployeeNameByEmployeeIdDao(String name, int employeeid) {

		String updateEmployeeNameByEmployeeIdQuery = "update employee set name=? where id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(updateEmployeeNameByEmployeeIdQuery);

			ps.setString(1, name);
			ps.setInt(2, employeeid);

			return ps.executeUpdate() != 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @return Employee
	 * @param employeeid
	 */
	public Employee getEmployeeByIdDao(int employeeid) {

		String getEmployeeByIdQuery = "select * from employee where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(getEmployeeByIdQuery);

			ps.setInt(1, employeeid);

			ResultSet res = ps.executeQuery();

			if (res.next()) {

				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String password = res.getString("password");
				long phone = res.getLong("phone");

				LocalDate dob = res.getDate("dob").toLocalDate();

				LocalDate doj = res.getDate("doj").toLocalDate();

				Employee employee = new Employee();

				employee.setId(id);
				employee.setName(name);
				employee.setEmail(email);
				employee.setPhone(phone);
				employee.setPassword(password);
				employee.setDob(dob);
				employee.setDoj(doj);

				return employee;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getAllEmployeeDao() {

		String displayAllEmployeeQuery = "select * from employee";

		try {

			PreparedStatement ps =
					connection.prepareStatement(displayAllEmployeeQuery);

			ResultSet res = ps.executeQuery();
                    
			
			List<Employee> employees = new ArrayList<Employee>();
			
			while (res.next()) {

				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String password = res.getString("password");
				long phone = res.getLong("phone");

				LocalDate dob = res.getDate("dob").toLocalDate();

				LocalDate doj = res.getDate("doj").toLocalDate();
				
				
				Employee employee=new Employee();
				
				employee.setId(id);
				employee.setName(name);
				employee.setEmail(email);
				employee.setPhone(phone);
				employee.setPassword(password);
				employee.setDob(dob);
				employee.setDoj(doj);
				
				employees.add(employee);

			}
			
			
			
			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void saveMultipleEmployeeDao(List<Employee> employees) {
		
		try {
			connection.setAutoCommit(false);
			PreparedStatement ps=
					connection.prepareStatement(INSERTINTOEMPLOYEEQUERY);
			
			for (Employee employee : employees) {
				
				
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getEmail());
				ps.setString(4, employee.getPassword());
				ps.setLong(5, employee.getPhone());
				ps.setObject(6, employee.getDob());
				ps.setObject(7, employee.getDoj());
				
				
				
				ps.addBatch();
				
			}
			
			int a[]=ps.executeBatch();
			
			connection.commit();
			
			System.out.println(a.length);
			
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}
			e.printStackTrace();
		}
	}
	
	/**
	 * @return Employee
	 * @param employeeEmail
	 */
	public Employee getEmployeeByEmailDao(String employeeEmail) {

		try {

			CallableStatement cs=connection.prepareCall("select * from employee where email=?");
			
			cs.setString(1, employeeEmail);

			ResultSet res = cs.executeQuery();

			if (res.next()) {

				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String password = res.getString("password");
				long phone = res.getLong("phone");

				LocalDate dob = res.getDate("dob").toLocalDate();

				LocalDate doj = res.getDate("doj").toLocalDate();

				Employee employee = new Employee();

				employee.setId(id);
				employee.setName(name);
				employee.setEmail(email);
				employee.setPhone(phone);
				employee.setPassword(password);
				employee.setDob(dob);
				employee.setDoj(doj);

				return employee;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
		public boolean updateEmployeeByIdDao(Employee employee) {

			String updateEmployeeByIdQuery = "update employee set name=?, email=?,password=?, phone=? ,dob=? ,doj=? where id=?";

			try {
				PreparedStatement ps = connection.prepareStatement(updateEmployeeByIdQuery);

				ps.setString(1, employee.getName());
				ps.setString(2, employee.getEmail());
				ps.setString(3, employee.getPassword());
				ps.setLong(4, employee.getPhone());
				ps.setObject(5, employee.getDob());
				ps.setObject(6, employee.getDoj());
				ps.setInt(7,employee.getId());

				return ps.executeUpdate() != 0 ? true : false;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

	}
