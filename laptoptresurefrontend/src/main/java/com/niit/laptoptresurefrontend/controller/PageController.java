package com.niit.laptoptresurefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptoptreasurebackend.dao.CartItemDAO;
import com.niit.laptoptreasurebackend.dao.CategoryDAO;
import com.niit.laptoptreasurebackend.dao.ProductDAO;
import com.niit.laptoptreasurebackend.model.Category;
import com.niit.laptoptreasurebackend.model.Product;
import com.niit.laptoptresurefrontend.exception.ProductNotFoundException;

@Controller
public class PageController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemDAO cartDAO;
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		 ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		//Passing the list of Categories
		mv.addObject("list",categoryDAO.getCategoryDetails());
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		System.out.println("---About us Page Displaying-----");
		 ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","About Us");
		mv.addObject("userClickAboutUs",true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		System.out.println("---Contact us Page Displaying-----");
		 ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContactUs",true);
		return mv;
		
	}
	
	/*@RequestMapping(value="/category")
	public ModelAndView category()
	{
		 ModelAndView mv=new ModelAndView("category");
		mv.addObject("title","Category");
		mv.addObject("userClickCategory",true);
		return mv;
	}*/
	
	/*@RequestMapping(value="/product")
	public ModelAndView product()
	{
		 ModelAndView mv=new ModelAndView("product");
		mv.addObject("title","Product");
		mv.addObject("userClickProduct",true);
		return mv;
	}*/
	
	@RequestMapping(value= "/signup")
	public  ModelAndView showSignUp()
   {
  		ModelAndView mv=new ModelAndView("index");
 	   System.out.println("Signup page displaying..");
 	   mv.addObject("title","Sign Up");
 	   mv.addObject("userClickSignUp",true);
 		return mv;   
   }
	
/*This is for Login*/
  	
  	@RequestMapping(value= "/login")
	public ModelAndView login(@RequestParam(name="error",required = false)String error)
   {
  		ModelAndView mv=new ModelAndView("login");
	   System.out.println("Login page displaying..");
	   
	   if(error!=null)
	   {
		   mv.addObject("message","Invalid Username and Password! Please try again!.");
	   }			   
	   mv.addObject("title","Login");
	   return mv;   
   }
	
	//Methods to load all the products and based on category
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		System.out.println("---Product Page Displaying-----");
		 ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","All Products");
		//mv.addObject("list",categoryDAO.getCategoryDetails());
		mv.addObject("userClickAllProducts",true);
		return mv;
		
	}
	
	//Methods to load all the products and based on category

	@RequestMapping(value="/show/category/{catid}/products")
		public ModelAndView showCategoryProducts(@PathVariable("catid") int catid)
		{
			System.out.println("---Categorywise Product Page Displaying-----");
			 ModelAndView mv=new ModelAndView("index");
	//CategoryDAO to fetch Single Category
	Category category= null;
	category = categoryDAO.getCategory(catid);
	
	mv.addObject("title",category.getCatname());
	
	//Passing the list of categories
	mv.addObject("categories",categoryDAO.list());

	//Passing the single category object
	mv.addObject("category",category);
	mv.addObject("title","All Products");
			mv.addObject("list",categoryDAO.getCategoryDetails());
			mv.addObject("userClickCategoryProducts",true);
			return mv;
			
		}
	
	//Showing Single Product
  	@RequestMapping(value = "/show/{prodid}/product")
  	public ModelAndView showSingleProduct(@PathVariable int prodid) throws ProductNotFoundException
  	{
  		ModelAndView mv=new ModelAndView("index");
		Product product=productDAO.getProduct(prodid);
		
		if(product==null) throw new ProductNotFoundException();
		
		//Update the view count
		//product.setProdname(product.getProdname()+1);
		//productDAO.insertUpdateProduct(product);
		
		
		mv.addObject("title", product.getProdname());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct", true);
  		
  		return mv;
  		
  	}
  /*	@RequestMapping(value="/show/cart/{cartItemid}/product")
	public ModelAndView showCartItems()
	{
		System.out.println("---Cart Displaying-----");
		 ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","Cart Items");
		//mv.addObject("list",categoryDAO.getCategoryDetails());
		mv.addObject("userClickAddtocart",true);
		return mv;
		
	}*/
  	
  	
  	
	
  	
  
  		
  	
  	
  //Access denied page
  	@RequestMapping(value ="/access-denied")
  	public ModelAndView accessDenied()
     {
  		ModelAndView mv=new ModelAndView("error");
  	   mv.addObject("title","403 - Access Denied");
  	   mv.addObject("errorTitle","You are on wrong Page ");
  	   mv.addObject("errorDescription","You are not authorized to view this Page!");
  		return mv;   
     }
    	
	
	

}
