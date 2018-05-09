package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User {
	@Id
	@Column(name="username")
	String username;	

	@Column(name="password")
	String password;
	
	@Column(name="confirmpassword")
	String confirmpassword;

	@Column(name="name")
	String name;	
	
	@Column(name="email")
	String email;

	public User(String username, String password, String confirmpassword, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.name = name;
		this.email = email;
	}
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", name=" + name + ", email=" + email + "]";
	}

	
	
	


}