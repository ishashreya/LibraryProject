package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="booktable")
public class Book {
	

	
		@Id
		@GeneratedValue
		@Column(name="bookId")
	    int bookId;
		@Column(name="bookName")
		String bookname;
		@Column(name="bookAuthor")
		String bookAuthor;
		@Column(name="price")
		String price;
		public Book(int bookId, String bookname, String bookAuthor, String price) {
			super();
			this.bookId = bookId;
			this.bookname = bookname;
			this.bookAuthor = bookAuthor;
			this.price = price;
		}
		public Book() {
			super();
		}
		
		public Book(String bookname, String bookAuthor, String price) {
			super();
			this.bookname = bookname;
			this.bookAuthor = bookAuthor;
			this.price = price;
		}
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", bookname=" + bookname + ", bookAuthor=" + bookAuthor + ", price="
					+ price + "]";
		}
		
		

		
}
