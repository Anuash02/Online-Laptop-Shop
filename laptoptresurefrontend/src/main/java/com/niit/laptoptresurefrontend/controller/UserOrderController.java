package com.niit.laptoptresurefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptoptreasurebackend.dao.CartItemDAO;
import com.niit.laptoptreasurebackend.dao.UserOrderDAO;
import com.niit.laptoptreasurebackend.model.Cart;
import com.niit.laptoptreasurebackend.model.UserDetails;
import com.niit.laptoptreasurebackend.model.UserOrder;

@Controller
public class UserOrderController 
{
	 @Autowired
	 UserOrderDAO userorderDAO;
	 
	 @Autowired
	 CartItemDAO cartItemDAO;
	 
	 @RequestMapping("/cart/order/{cartid}")
	 public ModelAndView createOrder(@PathVariable int cartid,Model model)
	 {

		 ModelAndView mv=new ModelAndView("index");
		   mv.addObject("userClickOrder", true);
		   mv.addObject("title", "Order");
			Cart cart=cartItemDAO.getCart(cartid);
			UserDetails userdetail=cart.getUserdetails();
			cart.setUserdetails(userdetail);
			UserOrder userorder=userorderDAO.createOrder(cart);
			model.addAttribute("cart",cart);
			model.addAttribute("order",userorder);
			model.addAttribute("cartid",cartid);
		//	return "orderdetails";
			return mv;
		}
	 
	 @RequestMapping("/cart/confirm/{cartid}")
	 public ModelAndView confirm(@ModelAttribute UserOrder order,@PathVariable int cartid,Model model)
		{
			ModelAndView mv=new ModelAndView("index");	
			   mv.addObject("userClickConfirmOrder", true);
			   mv.addObject("title", "Thanks for Shopping!");
			   
			   model.addAttribute("order",order);
			  
			   
			cartItemDAO.removeAllCartItem(cartid);
			//return "thanks";
		   return mv;
		}

}
