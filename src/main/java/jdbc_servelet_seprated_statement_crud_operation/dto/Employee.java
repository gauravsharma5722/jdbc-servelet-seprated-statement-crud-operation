package jdbc_servelet_seprated_statement_crud_operation.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
/**
 * this is encapsuation class which is used for data transfer from 
 * controller to dao and dao to controller
 * @author Gaurav
 */
public class Employee implements Serializable{
	private int id;
	private String name;
	private String email;
	private String password;
	private long phone;
	private LocalDate dob;
	private LocalDate doj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dob, doj, email, id, name, password, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(doj, other.doj) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& phone == other.phone;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", dob=" + dob + ", doj=" + doj + "]";
	}
	
}
