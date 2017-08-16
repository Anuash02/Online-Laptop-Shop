package com.niit.laptoptresurefrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.niit.laptoptreasurebackend.dao.ProductDAO;
import com.niit.laptoptreasurebackend.dao.SupplierDAO;
import com.niit.laptoptreasurebackend.model.Category;
import com.niit.laptoptreasurebackend.model.Product;
import com.niit.laptoptresurefrontend.util.FileUploadUtility;
import com.niit.laptoptresurefrontend.valiadtor.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	// shows products to be managed
	@RequestMapping(value="/products", method=RequestMethod.GET)
public String showManageProducts(@RequestParam(name = "operation" , required = false ) String operation , Model m ) 
	{
		
		System.out.println("showManageProducts method going to manageProducts.jsp from from this controller");
		
		
		m.addAttribute("userClickManageProducts" , true) ;
		
		m.addAttribute("title" , "Manage Products Page") ;
	
		Product newProduct = new Product() ;
		
		// set few of the fields
		newProduct.setSupid(0);
		
		m.addAttribute("product" , newProduct) ; // manageProducts.jsp ka modelAttribute name 
		
		if(operation != null) {
			
			if(operation.equals("product")) {
				
				m.addAttribute("message" , "Product submitted successfully !") ;
			}
		}
		
		return "index" ;
	}
	
	//Upadating the product 
	@RequestMapping(value="/{prodid}/product", method=RequestMethod.GET)
	public String showEditProducts(@PathVariable int prodid , Model m ) {
		
		System.out.println("showManageProducts method going to manageProducts.jsp from from this controller");
		
		
		System.out.println("Edit and update the product");
		
		
		m.addAttribute("userClickManageProducts" , true) ;
			
		m.addAttribute("title" , "Manage Products Page") ;
		
		// fetch product from the database
		Product newProduct = productDAO.getProduct(prodid) ;
			
		m.addAttribute("product" , newProduct) ; //  this is the attribute given in manageProducts.jsp 
			
		return "index" ;
	}
	
	//For the Deleting the Product

	@RequestMapping(value="/delete/{prodid}/product", method=RequestMethod.GET)
	//@RequestMapping(value="/delete/{prodid}/product", method=RequestMethod.GET)
	public String showDeleteProducts(@PathVariable int prodid , Model m) 
	{

		System.out.println("---Product Deleted----");
		Product product=productDAO.getProduct(prodid);
		productDAO.deleteProduct(product);
                                               
		return "redirect:/manage/products";
    
	}
	
	//handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, 
    		HttpServletRequest request)
	
    {
		//If there are any errors
		if(results.hasErrors())
    	{
    		
            model.addAttribute("userClickManageProducts", true);
            model.addAttribute("title", "Manage Products");
    		model.addAttribute("message", "Validation failed for Product Submission");
            return "index";
    	}
		//handle image validation for new Products
    	if(mProduct.getProdid()==0) {
    	new ProductValidator().validate(mProduct,results);
    	}
    	else
    	{
    		if(!mProduct.getFile().getOriginalFilename().equals(""))
    		{
    			new ProductValidator().validate(mProduct,results);
    		}
    	}
		
		//create a new Product Record
    	if(mProduct.getProdid()==0)
    	{	
    	productDAO.insertUpdateProduct(mProduct);
    	}
    	else
    	{ 
    		//update the Product if id is not 0
    		productDAO.insertUpdateProduct(mProduct);
    	}
    	if(!mProduct.getFile().getOriginalFilename().equals(""))
    	{
    		FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
    	}
    	
    	
    	return "redirect:/manage/products?operation=product"; 
    
    
    }
	// Returning Categories For All the Products
    @ModelAttribute("category")
    public List<Category> getCategory()
    {
		return categoryDAO.getCategoryDetails();
    }
    
   /* @ModelAttribute("supplier") // links with manageProducts.jsp ka items value
	public List<Supplier> getSupplier() {

		System.out.println("Redirecting to manageProducts.jsp from Product Controller section (getSupplier method) .... ");
		System.out.println();
		
		return supplierDAO.getSupplierDetails(); 
	}*/
}
	
	
	
	
	

	