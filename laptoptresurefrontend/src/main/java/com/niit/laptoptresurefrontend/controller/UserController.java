package com.niit.laptoptresurefrontend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptoptreasurebackend.dao.UserDetailsDAO;
import com.niit.laptoptreasurebackend.model.UserDetails;

@Controller
@RequestMapping("/register")
public class UserController 
{
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	

	
	@RequestMapping(value = "/newUser",method=RequestMethod.GET)
	 public ModelAndView showUser(@RequestParam(name="operation",required=false)String operation)
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("userClickSignup", true);
		mv.addObject("title", "Registration");
		UserDetails userDetails = new UserDetails();
		//Set the few fields
		//userdetail.setRole("User");
		
		
		if(operation!=null)
		{
			if(operation.equals("userDetails"))
			{
				mv.addObject("message", "All details are submitted successfully!You can login now!");
			}
		}
		
		return mv;
	}

	@RequestMapping(value = "/newUser", method=RequestMethod.POST)
	public String addUser(@RequestParam("username") String username, @RequestParam("custname") String custname,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("mobile") String mobile,@RequestParam("address") String address,UserDetails muserdetail, Model m) {
		System.out.println("---Add User Starting-----");
		
		muserdetail.setUsername(username);
		muserdetail.setCustname(custname);
		muserdetail.setAddress(address);
		muserdetail.setEmail(email);
		muserdetail.setMobile(mobile);
		muserdetail.setPassword(password);
				
		userDetailsDAO.validateUsername(username);
		if(muserdetail!=null)
		{
			m.addAttribute("duplicateUsername","Username already exists!Please try with new one!");
		}
		
		
		userDetailsDAO.validateEmail(email);
		if(muserdetail!=null)
		{
			m.addAttribute("duplicateEmail","Email already exists!Please enter different Email Id!");
		}

	    
		userDetailsDAO.validateCustomername(custname);
		if(muserdetail!=null)
		{
		    m.addAttribute("duplicateCustomername","Customername already exists!Please enter different Customername");	
		}
		
		
		userDetailsDAO.insertUpdateUserDetail(muserdetail);
		//List<UserDetail> list = userdetailDAO.getUserDetailDetails();
		//m.addAttribute("UserDetail", list);

		System.out.println("---User Added----");
		return "redirect:/register/newUser?operation=userDetails";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session,Model m) {
		System.out.println("loded successfully");
		boolean loggedIn = true;
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", username);
		session.setAttribute("loggedIn", loggedIn);
		System.out.println(username);
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority Role : authorities) {
			System.out.println("Role:" + Role.getAuthority() + "username" + username);
			if (Role.getAuthority().equals("ROLE_ADMIN")) {
				return "Admin";
			} else {
				
				return "Index";
			}
		}
		return "Home";
	}
	*/
	

}

	