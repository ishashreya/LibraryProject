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

import controller.UserController;
import dao.LibrarianDao;
import model.Book;
import model.BookIssue;
import model.Feedback;
import model.Librarian;
import model.User;


@Service("userService")
public class UserService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class);

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired(required=true)
	private LibrarianDao libDAO;


	@Transactional
	public User getuserByName(String name){
		Session session = sessionFactory.getCurrentSession();
		//	Query q=session.createQuery("from BookIssue b where b.userName=:username");
		//	q.setParameter("username", name);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("username",name));
		Object result = criteria.uniqueResult();
		User user = (User) result;

		return user;
	}

	@Transactional
	public void add(User user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("adding user in UserSerice");
		session.save(user);
	}
	//LIST OF BOOKS IN THE DATABASE
	@Transactional
	public List<Book> listBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = session.createQuery("from Book").list();
		for(Book l : bookList){
			LOGGER.info("Person List::"+l);
		}
		return bookList;
	}

	//USER CAN ISSUE A BOOK
	@Transactional
	public void issueBook(int bookId) {
		Session session = this.sessionFactory.getCurrentSession();
		Book l = (Book) session.load(Book.class, new Integer(bookId));
		if(null != l){
			session.delete(l);
		}


	}		
	//USER LOGIN FUNC.
	@Transactional
	public void adduserlogin(User user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("adding user in UserSerice");
		session.save(user);
	}
	//ADD FEEDBACK
	@Transactional
	public void addfeedback(Feedback feed) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("adding user in UserSerice");
		session.save(feed);
	}
	//GET ALL FROM ID
	@Transactional
	public boolean getAllId(String user, String pass){

		LOGGER.info("starting Service");
		boolean registeredCusttomer=false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username= :user and u.password= :pass");
		query.setParameter("user", user);
		query.setParameter("pass", pass);
		List<User> li=query.list();
		System.out.println(li);
		for(int i=0;i<li.size();i++){
			if(user.equals(li.get(i).getUsername()) && pass.equals(li.get(i).getPassword()))
			{
				registeredCusttomer= true;
				return registeredCusttomer;
			}

		}

		return registeredCusttomer;

	}
	//LIST OF LIBRARIAN BY ID
	public Librarian getLibrarianById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Librarian l = (Librarian) session.load(Librarian.class, new Integer(id));
		//logger.info("Person loaded successfully, Person details="+l);
		return l;
	}
	//GET LIST OF ISSUED BOOKS
	@Transactional
	public List<BookIssue> getlistbyId(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BookIssue b where b.userName=:userName ");
		q.setParameter("userName", userName);
		System.err.println(q.list());
		List<BookIssue> issueList=q.list();
		LOGGER.info(userName + " Selected the books "+issueList);
		return issueList;
	}



}







