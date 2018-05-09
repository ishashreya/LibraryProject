package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Bookdao;
import dao.LibrarianDao;
import model.Book;
import model.BookIssue;
import model.Librarian;
import model.User;




@Service("bookservice")
public class BookService {

	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	@Autowired(required=true)
	Bookdao bookDAO;
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

		//ADD BOOK TO DATABSE
	@Transactional
	public void addBook(BookIssue b) {
		this.bookDAO.addBook(b);
	}
		//GET BOOKS BY ID
	@Transactional
	public Book getBookById(int bookId){
		Book book=bookDAO.getBookById(bookId);
		LOGGER.info("BookService:Reading the BOOK Details="+book);
		return book;
	}
	@Transactional
	public Book getBookbyname(String bookName){
		Session session = sessionFactory.getCurrentSession();
		//	Query q=session.createQuery("from BookIssue b where b.userName=:username");
		//	q.setParameter("username", name);
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.like("bookName",bookName));
		Object result = criteria.uniqueResult();
		Book book = (Book) result;

		return book;
	}


}
