package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.CustomHibernateInstance;
import pojo.User;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	   @RequestMapping(method = RequestMethod.GET)
	   public String showRegistrationPage() {
		 System.out.println("Showing View"); 
		 return "register";
	   }   
	   
	   
	   @RequestMapping(method = RequestMethod.POST)
	   public String registerUser(HttpServletRequest request,HttpServletResponse response) {
		 System.out.println("Do Register"); 
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		
		 CustomHibernateInstance.getSessionTransaction();
		 Session session  = CustomHibernateInstance.session;
		 Transaction transaction = CustomHibernateInstance.transaction;
		 
		 User u = new User(); 
		 u.setUserid("1");
		 u.setUseremail(email);
		 u.setUserpassword(password);
		 u.setUsername(name);
		 session.save(u);
		
		 transaction.commit();
		 
		 return "index";
		 
	   }   
	   
}
