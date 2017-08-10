package com.niit.laptoptreasurebackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptoptreasurebackend.dao.SupplierDAO;
import com.niit.laptoptreasurebackend.model.Supplier;

public class SupplierTestCase
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.laptoptreasurebackend");
		context.refresh();
		
		
		//Inserting a Supplier object
		 SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		 
		 //Inserting Supplier test cases
		Supplier supplier=new Supplier();
		 supplier.setSupname("DELL");
		 supplier.setAddress("Pune");
		 
		 supplierDAO.insertUpdateSupplier(supplier);
		 System.out.println("Supplier Created");
		 
		 
		//Retrieval TestCase
			
			/*Supplier supplier=supplierDAO.getSupplier(2);
			System.out.println("Supplier Name:"+supplier.getSupname());
			System.out.println("Supplier Address:"+supplier.getAddress());*/
			
			//Deletion TestCase
			/*Supplier supplier=supplierDAO.getSupplier(2);
			supplierDAO.deleteSupplier(supplier);
			System.out.println("The Supplier Deleted");*/
			
			//Retrieving the Data
			
			/*List<Supplier> list=supplierDAO.getSupplierDetails();
			
			for(Supplier supplier:list)
			{
				System.out.println(supplier.getSupid()+":"+supplier.getSupname()+":"+supplier.getAddress());
			}*/
	
	//Update the Supplier
			/*Supplier supplier=supplierDAO.getSupplier(3);
			supplier.setSupname("Dell with 1TB HardDisc ");
			supplierDAO.insertUpdateSupplier(supplier);
			System.out.println("The Supplier Updated");*/
			
	
	
	
	}

}
