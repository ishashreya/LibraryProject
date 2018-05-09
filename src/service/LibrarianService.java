package service;

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
@Service
public class LibrarianService{
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	@Autowired(required=true)
	private LibrarianDao libDAO;
	@Autowired(required=true)
	Bookdao bookDAO;
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public void setLibrarianDao(LibrarianDao libDAO) {
		this.libDAO = libDAO;
	}


	@Transactional
	public void addLibrarian(Librarian l) {
		this.libDAO.addLibrarian(l);
	}




	@Transactional
	public List<Librarian> listLibrarians() {
		return this.libDAO.listLibrarians();
	}



	@Transactional
	public void removeLibrarian(int id) {
		this.libDAO.removeLibrarian(id);
	}
	public Librarian getuserByName(String userName){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Librarian.class);
		criteria.add(Restrictions.like("userName",userName));

		Object result = criteria.uniqueResult();
		Librarian user = (Librarian) result;

		return user;
	}

	@Transactional
	public boolean validate(String userName,String password){

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Librarian.class);
		criteria.add(Restrictions.like("userName",userName));

		boolean flag = false;
		Object result = criteria.uniqueResult();
		if(result!=null){
			Librarian lib = (Librarian) result;
			if(lib.getPassword().equalsIgnoreCase(password)){
				flag = true;
			}
		}

		if(flag==true){
			return true;
		}
		else{
			return false;
		}
	}
	@Transactional
	public List<Book> listOfBooksForLibrarian() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = session.createQuery("from Book").list();
		for(Book l : bookList){
			LOGGER.info("Person List::"+l);
		}
		return bookList;
	}
	@Transactional
	public List<BookIssue> listIssue() {
		Session session = this.sessionFactory.getCurrentSession();
		List<BookIssue> issuelist = session.createQuery("from BookIssue").list();
		for(BookIssue l : issuelist){
			LOGGER.info("Person List::"+l);
		}
		return issuelist;
	}

	@Transactional
	public void addadmin(Librarian librarian) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("adding user in Admindatabase");
		session.save(librarian);
	}
	public Book getBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book employee = (Book) session.get(Book.class, new Integer(id));
		return employee;
	}
	@Transactional
	public Librarian getbyId(int id){
		Session session = sessionFactory.getCurrentSession();
		return (Librarian)session.get(Librarian.class,id);
	}
	@Transactional
	public void addbooks(Book book)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(book);	
		System.out.println("done");
	}
			//GET LIBRARIAN BY ID
	@Transactional
	public boolean getAllId(String name, String pass){

		LOGGER.info("starting Service");
		boolean registeredCusttomer=false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Librarian u where u.Name= :name and u.Password= :pass");
		query.setParameter("name", name);
		query.setParameter("pass", pass);
		List<Librarian> li=query.list();
		System.out.println(li);
		for(int i=0;i<li.size();i++){
			if(name.equals(li.get(i).getName()) && pass.equals(li.get(i).getPassword()))
			{
				registeredCusttomer= true;
				return registeredCusttomer;
			}

		}

		return registeredCusttomer;

	}

			//DELETE BOOKS
	@Transactional
	public void deleteBook(int bookId) {
		Session session = this.sessionFactory.getCurrentSession();
		Book p = (Book) session.load(Book.class, new Integer(bookId));
		if (null != p) {
			session.delete(p);
		}
	}
			//GET BOOKS BY ID
		@Transactional
		public Book getBookById(int bookId){
			Book book=bookDAO.getBookById(bookId);
			LOGGER.info("BookService:Reading the BOOK Details="+book);
			return book;
		}
		@Transactional
		public void updateBook(Book book) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(book);
		}
}