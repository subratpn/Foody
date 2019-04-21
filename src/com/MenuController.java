package com;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Menu;
import util.CustomHibernateInstance;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadRestaurantPage(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		
		//String queryString = httpServletRequest.getQueryString();
		String hotelId = httpServletRequest.getParameter("hotelID");
		String hotelName = httpServletRequest.getParameter("hotelName");
		Session session = CustomHibernateInstance.getSession();
		List<Menu> menuList = session.createQuery("From Menu M where M.rest_id="+hotelId).getResultList();
		System.out.println("Food : "+menuList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menulist", menuList);
		modelAndView.addObject("hotel", hotelName);
		modelAndView.setViewName("menu");
		return modelAndView;
		
	}

}
