package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Menu;
import pojo.Order;
import util.CustomHibernateInstance;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView showCartPage(HttpServletRequest request,HttpServletResponse response) {
		   ModelAndView  modelAndView = new ModelAndView();
		   String[] menuArray = request.getParameterValues("menuID");
		   
		   boolean isCartEmpty = false;
		   
		   if(menuArray == null) {
			   System.out.println("Cart Is Null");
			   isCartEmpty = true;
		   }else {
			   
			   HashMap<String, Integer> menuMap = new HashMap<String, Integer>();
			   String queryData="";
			   for(String menuID : menuArray) {
				   System.out.println("Ordered Food : "+menuID);
				   if(menuMap.containsKey(menuID)) {
					   System.out.println("Flow 1");
					   menuMap.put(menuID, menuMap.get(menuID)+1);
				   }else {
					   System.out.println("Flow 2");
					   queryData = queryData+menuID+",";
					   menuMap.put(menuID, 1);
				   }
			   }
			   
			   queryData = queryData.substring(0,queryData.length()-1);
			   System.out.println("New Query Data"+queryData);
			   Session session = CustomHibernateInstance.getSession();
			   List<Menu> orderedMenuData = session.createQuery("From Menu M where M.id in("+queryData+")").getResultList();
			   
			   List<Order> orderList = new ArrayList<Order>();
			   double totalValue = 0.0;
			   
			   for(Menu m : orderedMenuData) {
				   Order order = new Order();
				   int id = m.getId();
				   int quantity = menuMap.get(String.valueOf(id));
				   totalValue += quantity * m.getPrice();
				   order.setMenu(m);
				   order.setQuantity(quantity);
				   orderList.add(order);
			   }
			   
			   
			   System.out.println(orderedMenuData);
			   
			   modelAndView.addObject("menuData",orderList);
			   modelAndView.addObject("totalValue",totalValue);
			   
		   }
		   
		   
		   
		   modelAndView.addObject("isCartEmpty",isCartEmpty);
		   modelAndView.setViewName("cart");
		   return modelAndView;
		   
		   
	   }

}
