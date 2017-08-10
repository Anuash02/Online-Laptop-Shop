package com.niit.laptoptreasurebackend.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cartid;
	
	double grandTotal;
	
	@OneToOne
	@JoinColumn(name="userid")
	 UserDetails userdetails;
	
	//@OneToMany(mappedBy="cart",fetch=FetchType.EAGER)
	 //List<CartItem> cartItems;
	@OneToMany(mappedBy="cart", fetch=FetchType.EAGER)
	List<CartItem> cartItems;
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	
}
