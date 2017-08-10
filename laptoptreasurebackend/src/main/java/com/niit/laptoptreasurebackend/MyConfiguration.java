package com.niit.laptoptreasurebackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration
{
	@Bean("MyBean")
	   public MyBean getMyBean()
	     {
		System.out.println("---Bean creted and stored in IOC Container----");
		      return new MyBean();
	     }


}
