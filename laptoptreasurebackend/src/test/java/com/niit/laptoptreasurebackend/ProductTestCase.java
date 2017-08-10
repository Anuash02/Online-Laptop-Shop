package com.niit.laptoptreasurebackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptoptreasurebackend.dao.ProductDAO;
import com.niit.laptoptreasurebackend.model.Product;

public class ProductTestCase
{
	public static void main(String args[])
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.laptoptreasurebackend");
		context.refresh();
		
		//Inserting Product Object
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		
		//Inserting Product Case
		Product product=new Product();
		product.setProdname("DELL");
		product.setProddesc("Laptop meant for  as Professional users");
		product.setQuantity(2);
		product.setPrice(50000);
		product.setCatid(3);
		product.setSupid(2);
		
		productDAO.insertUpdateProduct(product);
		System.out.println("Product Created");
		
		//Retrieval of Test Cases
		
		/*Product product= productDAO.getProduct(3);
		System.out.println("ProductName:"+product.getProdname());
		System.out.println("Product Description:"+product.getProddesc());
		System.out.println("Product Quantity:"+product.getQuantity());
		System.out.println("Product Price:"+product.getPrice());
		System.out.println("Category Id:"+product.getCatid());
		System.out.println("Supplier Id:"+product.getSupid());*/
		
		//Deletion of Test Cases
		/*Product product=productDAO.getProduct(2);
		productDAO.deleteProduct(product);
		System.out.println("The Product Deleted");*/
		
		//Retrieval of Data
		/*List<Product> list= productDAO.getProductDetails();
		for(Product product:list)
		{

			System.out.println(product.getProdname()+":" +product.getProddesc()+":" +product.getQuantity()+":"+ product.getPrice()+":" +product.getCatid()+":" +product.getSupid());
		}*/
		
		//Update the Category
		/*Product product=productDAO.getProduct(2);
		product.setProdname("Dell with 1TB HardDisc ");
		productDAO.insertUpdateProduct(product);
		System.out.println("The Product Updated");*/
		
		
	}

}
