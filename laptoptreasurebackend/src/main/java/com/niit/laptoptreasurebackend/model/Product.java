package com.niit.laptoptreasurebackend.model;





import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity //
@Table //allows you to specify the details of the table that will be used to persist the entity in the database.
public class Product
{
	@Id //will automatically determine the most appropriate primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
     int prodid;
	
	   
	   String code;
	  
	   @NotBlank(message = "Please enter the Product Name!")//used for checking string blank or not   
	   String prodname;
       
	   @JsonIgnore
	   @NotBlank(message = "Please enter the Description for the Product!..")
      String proddesc;
	  int quantity;
	   
	   @Min(value=1, message = "The Price cannot be less than 1!.")
	   int price;
	  // @Min(value=1, message = "The Price cannot be less than 1!.")
	   
	   
	   @JsonIgnore
	   int catid;
	   @JsonIgnore
	   int supid;
       
       @Transient //For uploading file in product class doesn't require to be saved
      MultipartFile file; //http client constructs request to send file over the server or used by browser & http client
      // to upload files to the server
       
     public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	//defualt Constructor..
       public Product()
       {
          this.code= "PRO" + UUID.randomUUID().toString().substring(26).toUpperCase();	
       }
       
       public String getCode() {
   		return code;
   	}
   	public void setCode(String code) {
   		this.code = code;
   	}

	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
       

}
