package com.niit.laptoptreasurebackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.laptoptreasurebackend.model.Cart;
import com.niit.laptoptreasurebackend.model.UserDetails;

@Repository("userDetailsDAO")
public class UserDetailsDAO 
{
	@Autowired
	SessionFactory sessionFactory;
     
	public UserDetailsDAO(SessionFactory sessionFactory)
	{
       this.sessionFactory=sessionFactory;
	}
	
    @Transactional
	public void insertUpdateUserDetail(UserDetails userdetails)
	{
    	
		Session session=sessionFactory.getCurrentSession();
		userdetails.setEnabled(true);
		userdetails.setRole("USER");
		Cart cart=new Cart();
		cart.setUserdetails(userdetails);
		userdetails.setCart(cart);
		session.saveOrUpdate(userdetails);
	}
   
    @Transactional
    public UserDetails getUserDetail(String username)
    {

    	Session session= sessionFactory.openSession();
    	UserDetails userdetail=(UserDetails)session.get(UserDetails.class,username);
    	session.close();
    	return userdetail;
    }
    
    @Transactional
    public UserDetails getByUsername(String username)
    {
    	String selectQuery = "FROM UserDetails WHERE username = :username";
    	 try{
    		return sessionFactory.getCurrentSession()
    				.createQuery(selectQuery,UserDetails.class)
    				.setParameter("username", username)
    				.getSingleResult();
    	 }
    	catch(Exception ex)
    	 {
    		return null;
    	 }
    }
    
	@Transactional
	public UserDetails validateUsername(String username)
    {
		 Session session=sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from UserDetails where username=?");
		  query.setString(0,username);
		 UserDetails userdetail=(UserDetails) query.uniqueResult();   
         return userdetail;	
    }   
	
    @Transactional
	public UserDetails validateEmail(String email)
    {
		 Session session=sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from UserDetails where email=?");
		 query.setString(0,email);
		 UserDetails userdetail=(UserDetails) query.uniqueResult();   
         return userdetail;	
    }
    
    @Transactional
	public UserDetails validateCustomername(String custname)
    {
		 Session session=sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from UserDetails where custname=?");
		 query.setString(0,custname);
		 UserDetails userdetail=(UserDetails) query.uniqueResult();   
         return userdetail;	
    }
              
       
       /* //Adding Address
       public boolean addAddress(Address address)
       {
   		try{
   			Session session=sessionFactory.getCurrentSession();
   			session.saveOrUpdate(address);
   			return true;
   		  }
   		
   		catch(Exception e)
   		{
   			 e.printStackTrace();
       	     return false;
   		}
      	 
       }
       
      
       //Adding Cart
      public boolean addCart(Cart cart)
      {
  		try{
  			Session session=sessionFactory.getCurrentSession();
  			session.saveOrUpdate(cart);
  			return true;
  		  }
  		
  		catch(Exception e)
  		{
  			 e.printStackTrace();
      	     return false;
  		}
      }
      
      
      
      */

      
    
	public List<UserDetails> getUserDetailsDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetails");
		List<UserDetails> list=query.list();
		session.close();
		return list;
	}
}