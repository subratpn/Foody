package com;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Restaurant;
import util.CustomHibernateInstance;

@Controller
@RequestMapping("/")
public class RestaurantController {
	 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadRestaurantPage() {
		
		Session session = CustomHibernateInstance.getSession();
		List<Restaurant> restaurantList = session.createQuery("From Restaurant R").getResultList();
		System.out.println("Restaurants : "+restaurantList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("restaurants", restaurantList);
		modelAndView.setViewName("index");
		return modelAndView;
		
	}
	
	
}
