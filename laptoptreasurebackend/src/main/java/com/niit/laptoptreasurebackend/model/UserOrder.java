package com.niit.laptoptreasurebackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserOrder 
{
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	  int orderId;
	  Date purchaseDate;
	  @ManyToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name="cartid")
	  Cart cart;
	  
	@ManyToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name="userid")
	  UserDetails userDetails;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	

}
