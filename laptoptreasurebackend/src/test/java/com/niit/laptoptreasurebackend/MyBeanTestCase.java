package com.niit.laptoptreasurebackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBeanTestCase 
{
	public static void main(String args[])
	{
		System.out.println("---Flow in MyBean Test Case AnnotationConfigApplicationContext object created");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.laptoptreasurebackend");
		context.refresh();
		System.out.println("---MyBean created---");
		MyBean myBean=(MyBean)context.getBean("MyBean");
		myBean.display();
	}

}
