package com;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.User;
import util.CustomHibernateInstance;

@Controller
@RequestMapping("/login")
public class LoginController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String showLoginPage() {
	   return "login";
      
   }
   
   
   @RequestMapping(method = RequestMethod.POST)
   public String loginUser(HttpServletRequest request,HttpServletResponse response) {
	   Session session = CustomHibernateInstance.getSession();
	   String findUserHQL = "FROM User U WHERE U.useremail = '"+request.getParameter("email")+"' and U.userpassword='"+request.getParameter("password")+"'";
	   System.out.println(findUserHQL);
	   List<User> userList = session.createQuery(findUserHQL).getResultList();
	   System.out.println(userList);
	   if(userList.isEmpty()) {
		   System.out.println("Forwarding to Login");
		   return "login";
	   }
	   else {
		   System.out.println("Going with Child");
		   return "index";
	   }
      
   }

}