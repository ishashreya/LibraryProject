package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="vendorbooktable")
public class VendorBookList {

	@Id
	@GeneratedValue
	@Column(name="bookId")
    int bookId;
	@Column(name="bookName")
    String bookName;
	@Column(name="bookAuthor")
    String bookAuthor;
	@Column(name="bookPrice")
    int price;
	@Column(name="quantity")
    int quantity;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public VendorBookList() {
		super();
	}
	public VendorBookList(String bookName, String bookAuthor, int price, int quantity) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "VendorBookList [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
}