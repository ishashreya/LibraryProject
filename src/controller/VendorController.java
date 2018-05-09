package controller;

import javax.annotation.Resource;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import model.Book;
import model.BookIssue;
import model.Payment;
import model.User;
import model.Vendor;
import model.VendorBookList;
import service.BookService;
import service.VendorService;



@Controller
//@RequestMapping("/vendor")
public class VendorController {

	private static final Logger LOGGER = Logger.getLogger(VendorController.class);
	@Autowired
	private VendorService vs;
	private BookService bookservice;



	//ADD NEW VENDOR TO THE DATABASE
	@RequestMapping(value = "/addnew" ,method = RequestMethod.GET)
	public String addnew(Model model,HttpServletRequest request,HttpSession session) {


		String v= request.getParameter("vendorname");
		String p=request.getParameter("psw");
		//	    Vendor vendor = new Vendor(v,p);
		boolean k=vs.getAllById(v,p);
		System.out.println(k);
		if(k==true)  
			return "forward:/vendorlistbook";
		else{
			//System.out.println("error occured");
			return "invalidadmin";
		}
	}    
    
	
	// forwarding bookname and authorname
	@RequestMapping(value="/Supplybook", method = RequestMethod.GET) //issue/9
	public String Supply( HttpServletRequest request,HttpSession session){
		
		
		String bookName= request.getParameter("bookName");
		String p=request.getParameter("bookAuthor");
		VendorBookList vbl=vs.getbookByName(bookName);
		session.setAttribute("vbl", vbl);

		LOGGER.info("bookname is "+bookName + " Author "+p);

		//  this.userService.issueBook(bookId);
		return "Supplybooks";
	}





	//VENDOR SUPPLIES BOOK
	@RequestMapping(value = "/addbook" ,method = RequestMethod.GET)
	public String addbook(Model model,HttpServletRequest request,HttpSession sess) {


		String p=request.getParameter("bookName");
		String r=request.getParameter("bookAuthor");
		String i=request.getParameter("price");
		Book book = new Book(p,r,i);
		vs.addbook(book);
		vs.deletebook(p);
		LOGGER.info("delete");
		

		return  "requestpayment";
	}
	//VENDOR ASKS FOR PAYMENT
	@RequestMapping(value = "/addbookpay" ,method = RequestMethod.GET)
	public String addbookpay(Model model,HttpServletRequest request) {


		String b=request.getParameter("bookName");
		String q=request.getParameter("quantity");
		String a=request.getParameter("amountDue");
		
		
		Payment payment = new Payment(b,q,a);
		//   LOGGER.info("within getadd Controller");   
		vs.addbookpay(payment);

		return  "Supplybooks";
	}
	//LIBRARIAN REQUESTS BOOK FROM VENDOR
	@RequestMapping(value = "/addtovendor" ,method = RequestMethod.GET)
	public String add(Model model,HttpServletRequest request,HttpSession session) {


		String us= request.getParameter("bookName");
		String p=request.getParameter("bookAuthor");
		String cp=request.getParameter("price");
		int price=Integer.parseInt(cp);
		String n=request.getParameter("quantity");
		int q=Integer.parseInt(n);	    

		VendorBookList vb = new VendorBookList(us,p,price,q);
		vs.addBooks(vb); 
		LOGGER.info(this.getClass().getName()+"trying to add "); 
		VendorBookList vbl=vs.getbookByName(us);
		session.setAttribute("vbl", vbl);

		LOGGER.info(this.getClass().getName()+"Sucessfully added ");
		return "SuucessfulRequest";
	}
	//LIST OF REQUESTS TO SUPPLY BOOK
	@RequestMapping(value = "/vendorlistbook", method = RequestMethod.GET)
	public String listbooks(Model model,HttpServletRequest request,HttpSession session) {
		//model.addAttribute("librarian", new Librarian());
		String bookName=request.getParameter("bookName");
		model.addAttribute("vlistbooks", this.vs.listvendorbooks());
		VendorBookList vbl=vs.getbookByName(bookName);			
		session.setAttribute("vbl", vbl);
		return "vendorlistbook";
	}
}

