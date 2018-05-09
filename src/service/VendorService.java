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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.LibrarianDao;

import dao.VendorBookListDao;
import model.Book;
import model.BookIssue;
import model.Librarian;
import model.Payment;
import model.User;
import model.Vendor;
import model.VendorBookList;

@Service("vendorService")
public class VendorService {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	private static final Logger LOGGER = Logger.getLogger(VendorService.class);


	@Autowired(required=true)
	private VendorBookListDao vbookDAO;


	@Transactional
	public void add(Vendor vendor) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("print");
		session.save(vendor);
	}
	@Transactional
	public void addbook(Book book)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(book);	
		System.out.println("done");
	}
	@Transactional
	public void deletebook(String bookName)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete FROM VendorBookList b where b.bookName=:bookName");
		query.setParameter("bookName", bookName);
		int result = query.executeUpdate();
		/*if (null != p) {
		session.delete(p);
		}*/

	}

	@Transactional
	public void addbookpay(Payment payment)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(payment);	
		System.out.println("done");
	}

	@Transactional
	public void addbookissue(BookIssue issue)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(issue);	
		System.out.println("done");
	}
	@Transactional
	public List<VendorBookList> listvendorbooks() {
		return this.vbookDAO.listvendorbooks();
	}
	@Transactional
	public void addBooks(VendorBookList l) {
		this.vbookDAO.addBooks(l);
	}
	@Transactional
	public Vendor getVendorByName(String name){
		Session session = sessionFactory.getCurrentSession();
		//	Query q=session.createQuery("from BookIssue b where b.userName=:username");
		//	q.setParameter("username", name);
		Criteria criteria = session.createCriteria(Vendor.class);
		criteria.add(Restrictions.like("vendorname",name));
		Object result = criteria.uniqueResult();
		Vendor vendor = (Vendor) result;

		return vendor;
	}
	@Transactional
	public boolean getAllById(String name, String pass){

		LOGGER.info("starting Service");
		boolean registeredCusttomer=false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Vendor u where u.vendorname= :name and u.password= :pass");
		query.setParameter("name", name);
		query.setParameter("pass", pass);
		List<Vendor> li=query.list();
		System.out.println(li);
		for(int i=0;i<li.size();i++){
			if(name.equals(li.get(i).getVendorname()) && pass.equals(li.get(i).getPassword()))
			{
				registeredCusttomer= true;
				return registeredCusttomer;
			}

		}

		return registeredCusttomer;

	}
	@Transactional
	public VendorBookList getbookByName(String name){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(VendorBookList.class);
		criteria.add(Restrictions.like("bookName",name));
		Object result = criteria.uniqueResult();
		VendorBookList vbl = (VendorBookList) result;
		
		return vbl;
	}
	/*@Transactional
	public VendorBookList getBookbyname(String bookName){
		Session session = sessionFactory.getCurrentSession();
		//	Query q=session.createQuery("from BookIssue b where b.userName=:username");
		//	q.setParameter("username", name);
		Criteria criteria = session.createCriteria(VendorBookList.class);
		criteria.add(Restrictions.like("bookName",bookName));
		Object result = criteria.uniqueResult();
		VendorBookList vbl = (VendorBookList) result;

		return vbl;
	}
*/




}
