package dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Book;
import model.BookIssue;
import model.Librarian;
@Repository
public class Bookdao {


	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(LibrarianDaoImp.class);


	//ADD BOOK TO DATABASE
	public void addBook(BookIssue b) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(b);
		logger.info("BOOK saved successfully, BOOK Details="+b);
	}
	//GET BOOKS BY ID
	public Book getBookById(int bookId) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book=(Book)session.get(Book.class,bookId);
		logger.info("BookDAO:Reading the BOOK Details="+book);
		return book;
	}




}
