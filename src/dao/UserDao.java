package dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Book;
import model.Librarian;
@Repository
public class UserDao {



	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(LibrarianDaoImp.class);

	public void removeLibrarian(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Librarian l = (Librarian) session.load(Book.class, new Integer(id));
		logger.info("ENTERING THE DAO");
		if(null != l){
			session.delete(l);
			
		}

	}
}
