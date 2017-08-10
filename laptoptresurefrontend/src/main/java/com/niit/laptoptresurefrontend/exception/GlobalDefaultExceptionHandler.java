package com.niit.laptoptresurefrontend.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice //Detects automatically by path scanning
public class GlobalDefaultExceptionHandler 
{
	public GlobalDefaultExceptionHandler() 
	{
		
		System.out.println("Showing the GlobalDefaultExceptionHandler of frontend Exception Handler .... ");
		System.out.println();
	}
	
	
	// global error handler
	/*@ExceptionHandler(NoHandlerFoundException.class)
	public String handlerNoHandlerFoundException(Model m) 
	{
		
		System.out.println("Redirecting to error.jsp page from Exception Handler section .. ");
		System.out.println();
		
		
		m.addAttribute("errorTitle" , "The page is not constructed ... ! ") ;

		m.addAttribute("errorDescription" , "The page you are looking for is currently not available ... ! ") ;
		
		m.addAttribute("title" , "404 Error Page") ;
		
		return "error" ;
		
	}*/
	
	       // Exception handler only for product search by using integer value only
			@ExceptionHandler(ProductNotFoundException.class)
			public String handlerProductNotFoundException(Model m) 
			{
				
				System.out.println("Redirecting to error.jsp page from Exception Handler section .. ");
				System.out.println();
				
				
				m.addAttribute("errorTitle" , "Product is not available ... ! ") ;

				m.addAttribute("errorDescription" , "The product you are looking for is not  available Right Now ... ! ") ;
				
				m.addAttribute("title" , "Product unavailable") ;
				return "error" ;
				
			}
			//Generalised Exception for Product search by character or other than integer value
			/*@ExceptionHandler(Exception.class)
			public ModelAndView handlerForException(Exception ex)
			{
				ModelAndView mv = new ModelAndView("error");
				mv.addObject("errorTitle", "Contact your Admin!..");
				
				mv.addObject("errorDescription", ex.toString());
		        
				mv.addObject("title","Error");		
				
				return mv;
			}*/

}
