package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name="orderId")
	 int orderId;
	
	@Column(name="bookName")
	 String bookName;
	
	@Column(name="quantity")
	 String quantity;
	
	@Column(name="amountDue")
	 String amountDue;
	
	@Column(name="ratings")
	 String ratings;
	
	@Column(name="bookid")
	 int bookid;

	public Payment(int orderId, String bookName, String quantity, String amountDue, String ratings, int bookid) {
		super();
		this.orderId = orderId;
		this.bookName = bookName;
		this.quantity = quantity;
		this.amountDue = amountDue;
		this.ratings = ratings;
		this.bookid = bookid;
	}

	

	public Payment(String bookName, String quantity, String amountDue) {
		super();
		this.bookName = bookName;
		this.quantity = quantity;
		this.amountDue = amountDue;
	}



	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "Payment [orderId=" + orderId + ", bookName=" + bookName + ", quantity=" + quantity + ", amountDue="
				+ amountDue + ", ratings=" + ratings + ", bookid=" + bookid + "]";
	}

	


	
	
}