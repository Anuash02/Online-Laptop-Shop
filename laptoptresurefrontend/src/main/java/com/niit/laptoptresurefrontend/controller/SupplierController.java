package com.niit.laptoptresurefrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.laptoptreasurebackend.dao.SupplierDAO;
import com.niit.laptoptreasurebackend.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/Supplier")
	public String showSupplierPage(Model m)
	{
		System.out.println("---Supplier Page Displaying-----");
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("supDetail",list);
		boolean flag=false;
        m.addAttribute("flag",flag);
		return "Supplier";
	}
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addSupplier(@RequestParam("supname") String supname,@RequestParam("address") String address,Model m)
	{
        System.out.println("---Add Supplier Starting-----");
		
		System.out.println(supname+":::"+address);
		
		Supplier supplier=new Supplier();
		supplier.setSupname(supname);
		supplier.setAddress(address);
		
		supplierDAO.insertUpdateSupplier(supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("supDetail",list);
		
		boolean flag=false;
        m.addAttribute("flag",flag);
		
		System.out.println("---Category Added----");
		return "Category";
	}

}
