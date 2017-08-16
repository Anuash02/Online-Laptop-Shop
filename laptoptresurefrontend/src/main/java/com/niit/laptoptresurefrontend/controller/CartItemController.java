package com.niit.laptoptresurefrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptoptreasurebackend.dao.CartItemDAO;
import com.niit.laptoptreasurebackend.dao.ProductDAO;
import com.niit.laptoptreasurebackend.dao.UserDetailsDAO;
import com.niit.laptoptreasurebackend.model.Cart;
import com.niit.laptoptreasurebackend.model.CartItem;
import com.niit.laptoptreasurebackend.model.Product;
import com.niit.laptoptreasurebackend.model.UserDetails;

@Controller
public class CartItemController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	 public CartItemController()
	    {
	    	System.out.println("We are in CartItem controller");
	    }
	  
	 @RequestMapping("/cart/getcart")
	 public ModelAndView getCart(Model m)
	 {
		 System.out.println("I am in getCart method of CartItem controller");
		 ModelAndView mv=new ModelAndView("index");
		 mv.addObject("userClickCart", true);
		 mv.addObject("title", "Cart");
		 User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String username=user.getUsername();
		 UserDetails userDetails=userDetailsDAO.getByUsername(username);
		 System.out.println("Check for the method running or not");
		 Cart cart=userDetails.getCart();
		 m.addAttribute("cart", cart);
		 return mv;
		 
	 }
	 
	 @RequestMapping("/cart/add/{prodid}/product")
	 public String addCartItem(@PathVariable int prodid, @RequestParam int units, Model m)
	 {
		  ModelAndView mv=new ModelAndView("index");
		   mv.addObject("userClickCart",true);
	       mv.addObject("title","Cart");
			Product product=productDAO.getProduct(prodid);
			
	   //To get the user details, get the Principal object from securitycontextholder
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			 String username=user.getUsername();
			 UserDetails userDetails=userDetailsDAO.getByUsername(username);
			 System.out.println("checking addCartItem method running or not");
			 Cart cart=userDetails.getCart();
			 System.out.println("Checking whether above line is running or not");
			 List<CartItem> cartItems= cart.getCartItems(); //collection of cart items from CartItem table which is declared in cart model
			 System.out.println("Checking whether above List<CartItem> is running or not");
			 System.out.println(cart.getCartItems().size());
			 
			//check purchased product is already existing in the cartitem table
			 for(CartItem cartItem:cartItems)
			 {
				 //productid in table (productid in the database) == id(input)
						 System.out.println(cartItem.getProduct().getProdid());
						 System.out.println(prodid);
						 if(cartItem.getProduct().getProdid()==prodid)
						  {
							 cartItem.setQuantity(units);
							  cartItem.setTotalPrice(product.getPrice() * units);
							  cartItemDAO.addCartItem(cartItem);//update cartitem units & totalprice addCartItem is given in CartItemDAO
							  return "redirect:/cart/getcart";
						  }
						 
			 }
						CartItem cartItem= new CartItem();
						cartItem.setQuantity(units);
						cartItem.setTotalPrice(product.getPrice() * units);
						cartItem.setProduct(product);//productid column in cartItem table
				         cartItem.setCart(cart);//cartid column in cartitem table
				         cartItemDAO.addCartItem(cartItem);//insert
				         return "redirect:/cart/getcart";
						    
					
					 
	 }
	 
	 @RequestMapping("/cart/removecartitem/{cartItemId}")
	 public String removeCartItem(@PathVariable int cartItemId)
	 {
		 System.out.println("---Single CartItem Deleted----");
		 cartItemDAO.removeCartItem(cartItemId);
		return "redirect:/cart/getcart";		 
	 }
	 
	 @RequestMapping("/cart/clearcart/{cartid}")
		public String removeAllCartItems(@PathVariable("cartid") int cartid)
	  {
	    	System.out.println("---Cart Deleted----");
		 cartItemDAO.removeAllCartItem(cartid);;
		return "redirect:/cart/getcart";
	  }

		
	 
		
	}