package com.niit.laptoptreasurebackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.laptoptreasurebackend.model.Cart;
import com.niit.laptoptreasurebackend.model.CartItem;

@Repository("cartItemDAO") // marks specific class as DAO thus clarifying its role
public class CartItemDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void addCartItem(CartItem cartItem)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}
	
	@Transactional
	public void removeCartItem(int cartItemId)
	{
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
	    session.delete(cartItem);
	}
     
	@Transactional
	public void removeAllCartItem(int cartid)
	{
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart) session.get(Cart.class, cartid);
		List<CartItem> cartItems=cart.getCartItems();
		//List<CartItem> cartItems=cart.getCartItems();
		for(CartItem cartItem:cartItems)
		{
			session.delete(cartItem);
		}
	}
    
	@Transactional
	public Cart getCart(int cartid)
	{
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart)session.get(Cart.class,cartid);
		return cart;		
	}

}
