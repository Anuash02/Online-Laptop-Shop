package com.niit.laptoptresurefrontend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.laptoptreasurebackend.dao.CategoryDAO;
import com.niit.laptoptreasurebackend.model.Category;

@Controller
@RequestMapping("/manage")
public class CategoryController 
{
	
	@Autowired
	CategoryDAO categoryDAO ;
	
	
	
	// show categories to be managed
	@RequestMapping(value = "/category" , method = RequestMethod.GET)
	public String showManageCategory (@RequestParam(name = "operation" , required = false) String operation , Model m) {
		
		System.out.println("showManageCategory method going to manageCategory.jsp from from this controller");
		
		
		m.addAttribute("userClickManageCategory" , true) ;
		m.addAttribute("title" , "Manage Categories Page") ;
		
		Category newCategory = new Category() ;
		
		m.addAttribute("category" , newCategory) ; // manageCategory.jsp ka modelAttribute name
		
		if(operation != null) {
			
			if(operation.equals("category")) {
				
				m.addAttribute("message" , "Category details submitted successfully !") ;
			}
		}
		
		return "index" ;
	}

	
	
	// Handling Category submission
	@RequestMapping(value = "/category" , method = RequestMethod.POST)
	public String handleCategorySubmission(@Valid @ModelAttribute("category") Category mCategory , BindingResult result , Model m) {
	
		System.out.println("handleCategory method going to manageCategory.jsp from from this controller");
		
		// check if there are any errors 
		if(result.hasErrors()) {
			
			m.addAttribute("userClickManageCategory" , true) ;
			m.addAttribute("title" , "Manage Categories Page") ;
			m.addAttribute("message" , "Validation failed for supplier submission !") ;
					
			return "index" ; // incase redirect method is used then error message will not be displayed .
		}		
		
		// create a new supplier record to store these categories
		categoryDAO.insertUpdateCategory(mCategory);
						
		return "redirect:/manage/category?operation=category" ; // passes message (in the form of query string ) from one url to another url
	}
	
	// Edit or update the category
	@RequestMapping(value = "/{catid}/category" , method = RequestMethod.GET) 
	public String showEditCategory(@PathVariable int catid , Model m ) {
			
		System.out.println("showEditCategory method going to manageCategory.jsp from from this controller");
		
		System.out.println("Editing the Category");
	
		
		m.addAttribute("userClickManageCategory" , true) ;
			
		m.addAttribute("title" , "Manage Categories Page") ;
		
		// fetch category from the database
		Category newCategory = categoryDAO.getCategory(catid) ;
			
		m.addAttribute("category" , newCategory) ; // manageSupplier.jsp ka modelAttribute name 
			
		return "index" ;
	}

	
	
	// Deleting the Category
	@RequestMapping(value = "/delete/{catid}/category" , method = RequestMethod.GET)
//	public String showDeleteCategory(@PathVariable int catid , Model m , @RequestParam(name = "operation" , required = false ) String operation) {
	public String showDeleteCategory(@PathVariable int catid , Model m) {	 
		
		System.out.println("showDeleteCategory method going to manageCategory.jsp from from this controller");
		
		System.out.println("Deleting the category ... ");
		
		
		/*
		//m.addAttribute("userClickManageCategory" , true) ;
			
		//m.addAttribute("title" , "Manage Categories Page") ;
		
		// fetch category from the database
		
			
		//m.addAttribute("category" , newCategory) ; // manageCategory.jsp ka modelAttribute name 
		*/
		
		Category category = categoryDAO.getCategory(catid) ;
		
		categoryDAO.deleteCategory(category) ;
		
		/*  /// Not Working 
		if(operation != null) {
			
			if(operation.equals("/delete/{catid}/category")) {
				
				m.addAttribute("message" , "Category deleted successfully !!") ;
			}
		}
		*/
		
	//	m.addAttribute("message" , "Category deleted successfully !!") ; // displays on address bar
		//return "redirect:/manage/category" ; // doesnt work
		
		return "redirect:/manage/category?operation=category" ; // passes message (in the form of query string ) from one url to another url
	}
	

}