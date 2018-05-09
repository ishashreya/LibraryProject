package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Librarian;
import model.VendorBookList;

@Repository
public class VendorBookListDao {

	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(VendorBookListDao.class);

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	//VENDOR SUPPLIES BOOKS
	public void addBooks(VendorBookList l) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(l);
		logger.info("Librarian saved successfully, Person Details="+l);
	}



	public List<VendorBookList> listvendorbooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VendorBookList> vbookList = session.createQuery("from VendorBookList").list();
		for(VendorBookList l : vbookList){
			logger.info("Person List::"+l);
		}
		return vbookList;
	}







}