package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Book;
import model.Librarian;
import model.Payment;
import service.LibrarianService;

@Controller
//@RequestMapping("/lib")

public class LibController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired(required=true)
	private LibrarianService libService;
	@Autowired(required=true)
	private SessionFactory sessionFactory;

	//LIST BOOKS FOR THE ADMIN TO DELETE OR MODIFY
	@RequestMapping(value = "/listadminbook", method = RequestMethod.GET)
	public String listOfBooksForLibrarian(Model model,HttpServletRequest request) {
		//model.addAttribute("librarian", new Librarian());

		request.setAttribute("list", this.libService.listOfBooksForLibrarian());
		return "listadminbook";
	}

	//FOR ADDING A NEW ADMIN
	@RequestMapping(value= "/addlib", method = RequestMethod.GET)
	public String addlibraian( HttpServletRequest request){

		String id1= request.getParameter("id");
		int id=Integer.parseInt(id1);
		String n=request.getParameter("Name");
		String p=request.getParameter("Password");
		String e=request.getParameter("Email");
		String a=request.getParameter("Address");
		String c=request.getParameter("City");
		String co=request.getParameter("ContactNo");
		Librarian lib = new Librarian(id,n,p,e,a,c,co);
		//LOGGER.info("within getadd Controller"+lib);   
		/* libService.addLibrarian(lib);*/
		LOGGER.info(this.getClass().getName()+"trying to add the user"); 
		libService.addLibrarian(lib);
		LOGGER.info(this.getClass().getName()+"Sucessfully added the user");
		return "forward:/listadminbook";

	}

	//ISSUE BOOKS REQUESTS
	@RequestMapping(value = "/RequestIssueList", method = RequestMethod.GET)
	public String listIssue1(Model model,HttpServletRequest request) {
		//model.addAttribute("librarian", new Librarian());

		model.addAttribute("issuelist", this.libService.listIssue());
		LOGGER.info("returning lib reg view");
		return "RequestIssueList";
	}
	//LOGIN VALIDATION
	@RequestMapping(value = "/addadmin" ,method = RequestMethod.GET)
	public String login(Model model,HttpServletRequest request) {
		String id1= request.getParameter("id");
		int id=Integer.parseInt(id1);
		String use= request.getParameter("name");
		String pas=request.getParameter("password");
		System.out.println(id);
		boolean k=libService.getAllId(use,pas);
		System.out.println(k);
		if(k==true)  
			return "forward:/listadminbook";
		else{
			//System.out.println("error occured");
			return "invalidadmin";
		}
	}	
	//DELETE A BOOK FROM LIBRARY
	@RequestMapping(value="/deletebook")
	public String deleteCategory(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		int bookId =Integer.parseInt(request.getParameter("bookId"));

		libService.deleteBook(bookId);

		List<Book> bookList = new ArrayList();
		bookList = libService.listOfBooksForLibrarian();

		LOGGER.info("PRINTING FULL CATEGORY LIST");
		session.setAttribute("lib", bookList);


		return "forward:/listadminbook";

	}
	@RequestMapping(value = "/updateprofile")
	public String saveBook(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	String id1= request.getParameter("bookId");
	int id=Integer.parseInt(id1);
	String bookName = request.getParameter("bookName");
	String bookAuthor = request.getParameter("bookAuthor");
	String price = request.getParameter("price");

	Book obj = new Book();
	obj.setBookId(id);
	obj.setBookname(bookName);
	obj.setBookAuthor(bookAuthor);
	obj.setPrice(price);
/*	libService.updateBook(obj);
*/	session.setAttribute("bid", id);
	session.setAttribute("bookName", bookName);
	session.setAttribute("bookAuthor", bookAuthor);
	LOGGER.info("CustomerController: updated the customer " + obj);
	return "UpdateBook";
	}
	@RequestMapping(value = "/updateNow")
	public String updateNow(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	String id1= request.getParameter("bookId");
	int id=Integer.parseInt(id1);
	String bookName = request.getParameter("bookName");
	String bookAuthor = request.getParameter("bookAuthor");
	String price = request.getParameter("price");

	Book obj = new Book();
	obj.setBookId(id);
	obj.setBookname(bookName);
	obj.setBookAuthor(bookAuthor);;
	obj.setPrice(price);
	libService.updateBook(obj);
	session.setAttribute("bid", id);
	session.setAttribute("bookName", bookName);
	session.setAttribute("bookAuthor", bookAuthor);
	LOGGER.info("CustomerController: updated the customer " + obj);
	return "forward:/listadminbook";
	}
	


}









