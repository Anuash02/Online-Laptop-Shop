package com.niit.laptoptreasurebackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptoptreasurebackend.dao.UserDetailsDAO;
import com.niit.laptoptreasurebackend.model.UserDetails;

public class UserDetailsTestCase
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.laptoptreasurebackend");
		context.refresh();
		
		//Inserting a Supplier object
		 UserDetailsDAO userDetailsDAO=(UserDetailsDAO)context.getBean("userDetailsDAO");
		 
		//Inserting UserDetails test cases
			/*UserDetails userDetails=new UserDetails();
			 userDetails.setUsername("Anushree");
			 userDetails.setPassword("anuash02");
			 userDetails.setCustname("anu@74");
			 userDetails.setRole("ADMIN");
			 userDetails.setEmail("anushree.74@gmail.com");
			 userDetails.setAddress("Mumbai");
			 userDetails.setMobile("9167495279");
			 userDetailsDAO.insertUpdateUserDetail(userDetails);
			 System.out.println("UserDetails Created");
			 */
			 
			//Inserting UserDetails test cases
				UserDetails userDetails=new UserDetails();
				 userDetails.setUsername("Sanddep");
				 userDetails.setPassword("12345");
				 userDetails.setCustname("Sandy");
				 userDetails.setRole("USER");
				 userDetails.setEmail("sandy@gmail.com");
				 userDetails.setAddress("Ratnagiri");
				 userDetails.setMobile("9422152788");
				 userDetailsDAO.insertUpdateUserDetail(userDetails);
				 System.out.println("UserDetails Created");
		 
		//Retrieval TestCase
			
			/*UserDetails userDetails=userDetailsDAO.getUserDetails("Pooja");
			System.out.println("UserDetails Password:"+userDetails.getPassword());
			System.out.println("UserDetails CustName:"+userDetails.getCustname());
			System.out.println("UserDetails Role:"+userDetails.getRole());
			System.out.println("UserDetails Email:"+userDetails.getEmail());
			System.out.println("UserDetails Address:"+userDetails.getAddress());
			System.out.println("UserDetails Mobile:"+userDetails.getMobile());*/
	}
		 

}
