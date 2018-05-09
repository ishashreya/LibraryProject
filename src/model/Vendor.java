package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendortable")
public class Vendor {
	@Id
	@Column(name="vendorName")
	String vendorname;
	@Column(name="psw")
	String password;
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Vendor(String vendorname, String password) {
		super();
		this.vendorname = vendorname;
		this.password = password;
	}
	public Vendor() {
		super();
	}
	@Override
	public String toString() {
		return "Vendor [vendorname=" + vendorname + ", password=" + password + "]";
	}
	
	
	

}
