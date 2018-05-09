package dao;

import java.util.List;



import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Librarian;

@Repository
public class LibrarianDaoImp implements LibrarianDao {

	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(LibrarianDaoImp.class);



	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	//ADD NEW LIBRARIAN
	@Override
	public void addLibrarian(Librarian l) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(l);
		logger.info("Librarian saved successfully, Person Details="+l);
	}
	//UPDATE PERSON DETAILS
	@Override
	public void updateLibrarian(Librarian l) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(l);
		logger.info("Person updated successfully, Person Details="+l);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Librarian> listLibrarians() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Librarian> libList = session.createQuery("from Librarian").list();
		for(Librarian l : libList){
			//logger.info("Person List::"+l);
		}
		return libList;
	}

	@Override
	public Librarian getLibrarianById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Librarian l = (Librarian) session.load(Librarian.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+l);
		return l;
	}

	@Override
	public void removeLibrarian(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Librarian l = (Librarian) session.load(Librarian.class, new Integer(id));
		if(null != l){
			session.delete(l);
		}
		logger.info("Person deleted successfully, person details="+l);
	}



}











