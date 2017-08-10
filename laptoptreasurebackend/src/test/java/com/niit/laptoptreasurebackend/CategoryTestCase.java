package com.niit.laptoptreasurebackend;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptoptreasurebackend.dao.CategoryDAO;
import com.niit.laptoptreasurebackend.model.Category;

public class CategoryTestCase 
{
	public static void main(String args[])
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.laptoptreasurebackend");
		context.refresh();
		
		
		//Inserting a Category object
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		//Inserting Test Case
		Category category=new Category();
		category.setCatname("Tablet");
		category.setCatdesc("This laptop is enabled with 2GB RAM with i7 Processor");
		
		categoryDAO.insertUpdateCategory(category);
		System.out.println("Category Inserted");
		
		//Retrieval TestCase
		
				/*Category category=categoryDAO.getCategory(2);
				System.out.println("Category Name:"+category.getCatname());
				System.out.println("Category Description:"+category.getCatdesc());*/
		
		//Deletion TestCase
				/*Category category=categoryDAO.getCategory(2);
				categoryDAO.deleteCategory(category);
				System.out.println("The Category Deleted");*/
		
		//Retrieving the Data
		
			 /* List<Category> list=categoryDAO.getCategoryDetails();
				
				for(Category category:list)
				{
					System.out.println(category.getCatid()+":"+category.getCatname()+":"+category.getCatdesc());
				}*/
		
		//Update the Category
				/*Category category=categoryDAO.getCategory(3);
				category.setCatname("Dell with 1TB HardDisc ");
				categoryDAO.insertUpdateCategory(category);
				System.out.println("The Category Updated");*/
				
		
				
		
	}

}
