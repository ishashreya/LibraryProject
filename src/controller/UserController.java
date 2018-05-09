package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Book;
import model.BookIssue;
import model.Feedback;
import model.User;
import service.BookService;
import service.LibrarianService;
import service.UserService;


@Controller
//@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired(required=true)
	UserService userService;

	@Autowired(required=true)
	BookService bookservice;

	@Autowired(required=true)
	private LibrarianService libService;


	//ADD NEW USERS TO THE DATABASE
	@RequestMapping(value = "/add" ,method = RequestMethod.GET)
	public String add(Model model,HttpServletRequest request) {


		String us= request.getParameter("username");
		String p=request.getParameter("password");
		String cp=request.getParameter("confirmpassword");
		String n=request.getParameter("name");
		String e=request.getParameter("email");
		User user = new User(us,p,cp,n,e);

		LOGGER.info(this.getClass().getName()+"trying to add the user"); 
		userService.add(user);
		LOGGER.info(this.getClass().getName()+"Sucessfully added the user");
		return "forward:/listbook";
	}

	//LIST OF BOOKS IN THE DATABASE
	@RequestMapping(value = "/listbook", method = RequestMethod.GET)
	public String listbooks(Model model,HttpServletRequest request) {
		//model.addAttribute("librarian", new Librarian());
		model.addAttribute("listbooks", this.userService.listBooks());
		return "listBook";
	}

	//TO TRANSFER THE REQUEST TO ISSUE PAGE 
	@RequestMapping(value="/issue", method = RequestMethod.GET) //issue/9
	public String issueBook( HttpServletRequest request,HttpSession sess){
		int bid=Integer.parseInt(request.getParameter("bid"));
		String username=request.getParameter("username");
		Book book=bookservice.getBookById(bid);
		User user=userService.getuserByName(username);
		sess.setAttribute("book", book);
		sess.setAttribute("user", user);
		LOGGER.info("added the book to session "+book + " with Id "+bid+ "for the user"+ user);

		//  this.userService.issueBook(bookId);
		return "IssueBook";
	}
	//USER CAN REQUEST A BOOK
	@RequestMapping(value = "/addbookissue" ,method = RequestMethod.GET)
	public String addBookissue(Model model,HttpServletRequest request) {

		String i=request.getParameter("bookId");
		int c=Integer.parseInt(i);
		String u=request.getParameter("username");
		String b=request.getParameter("bookname");

		String q=request.getParameter("startDate");
		String a=request.getParameter("endDate");

		String[] selectedStudentIds = request.getParameterValues("selected");


		BookIssue issue = new BookIssue(c,u,b,q,a);

		bookservice.addBook(issue);

		return  "forward:/issuesucess";
	}
	//ADD FEEDBACK
	@RequestMapping(value = "/addfeed" ,method = RequestMethod.GET)
	public String addfeed(Model model,HttpServletRequest request) {

		String ui= request.getParameter("userId");
		int id=Integer.parseInt(ui);
		/*String un = request.getParameter("userName");*/
		String f= request.getParameter("feedback");
		Feedback feed = new Feedback(id,f);

		userService.addfeedback(feed);

		return  "feedback"; 

	}
	//USER LOGIN FUNCTION AND CHECKS VALIDATION
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public String login(Model model,HttpServletRequest request,HttpSession session) {

		String use= request.getParameter("username");
		String pas=request.getParameter("password");
		User user=userService.getuserByName(use);

		if(user!=null && user.getPassword().equals(pas)){
			session.setAttribute("user", user);
			LOGGER.info("Added "+user +"to the session");
			return "forward:/listbook";
		}
		else{
			return "error";
		}
	}

	//VIEW PREVIOUS LOGS FOR USER
	@RequestMapping(value="/listuser", method = RequestMethod.GET)
	public String getAccList(Model model,HttpServletRequest request,HttpSession session) {
		User user=(User)session.getAttribute("user");
		List<BookIssue> bookIssuedList= userService.getlistbyId(user.getUsername());
		model.addAttribute("issuelist",bookIssuedList);
		LOGGER.info(user.getUsername()+" reading previous logs "+bookIssuedList);
		return "Issuedlist";

	}
}