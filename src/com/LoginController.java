package com;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.CustomHibernateInstance;
import pojo.User;

@Controller
@RequestMapping("/login")
public class LoginController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
	   
	   
	   CustomHibernateInstance.getSessionTransaction();
	   Session session  = CustomHibernateInstance.session;
	   Transaction transaction = CustomHibernateInstance.transaction;
	   
	   
	   User user =new User();    
	   user.setUserid("1");
	   user.setUseremail("subrat@gmail.com");
	   user.setUserpassword("12345");
	   
	   session.save(user);
	   transaction.commit();
	        
	   
	   System.out.println("successfully saved");     
	   
	   model.addAttribute("message", "User Created!");
	   return "login";
      
   }

}