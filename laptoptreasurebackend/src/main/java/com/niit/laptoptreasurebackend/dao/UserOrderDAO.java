package com.niit.laptoptreasurebackend.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.laptoptreasurebackend.model.Cart;
import com.niit.laptoptreasurebackend.model.CartItem;
import com.niit.laptoptreasurebackend.model.UserDetails;
import com.niit.laptoptreasurebackend.model.UserOrder;

@Repository("userOrderDAO")
public class UserOrderDAO 
{
	@Autowired
    SessionFactory sessionFactory;
	 
	   @Autowired
      CartItemDAO cartItemDAO;
	
	public UserOrderDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public UserOrder createOrder(Cart cart)
	{
		Session session=sessionFactory.getCurrentSession();
		//Cart cart=(Cart)session.get(Cart.class,cartid);
		List<CartItem> cartItems=cart.getCartItems();
		double grandTotal=0;
		for(CartItem cartItem:cartItems){
			grandTotal=cartItem.getTotalPrice()+grandTotal;
		}
		cart.setGrandTotal(grandTotal);
		UserDetails userdetail=cart.getUserdetails();
		UserOrder userorder=new UserOrder();
		userorder.setPurchaseDate(new Date());
		userorder.setCart(cart);
		userorder.setUserDetails(userdetail);
		session.save(userorder);//insert, also execute update queries for other tables
		  return userorder;
	}
	
}