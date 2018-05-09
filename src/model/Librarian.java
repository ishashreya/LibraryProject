package model;

import javax.persistence.*;

@Entity
@Table(name="Librarians")
public class Librarian {
	@Id
	@Column(name="id")
    int id;
	@Column(name="name")
	String Name;
	@Column(name="password")
	String Password;
	@Column(name="email")
	String Email;
	@Column(name="address")
	String Address;
	@Column(name="city")
	String City;
	@Column(name="contact")
	String ContactNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public Librarian(int id, String name, String password, String email, String address, String city,
			String contactNo) {
		super();
		this.id = id;
		Name = name;
		Password = password;
		Email = email;
		Address = address;
		City = city;
		ContactNo = contactNo;
	}
	
	public Librarian(int id,String name, String password) {
		super();
		this.id = id;
		Name = name;
		Password = password;
	}
	public Librarian() {
		super();
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", Name=" + Name + ", Password=" + Password + ", Email=" + Email + ", Address="
				+ Address + ", City=" + City + ", ContactNo=" + ContactNo + "]";
	}
	
	
	
}
