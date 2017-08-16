package com.niit.laptoptresurefrontend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility 
{
	private static  final String ABS_PATH = "D:\\Anushri Devops\\Github\\Online Laptop Shop\\Online-Laptop-Shop\\laptoptresurefrontend\\src\\main\\webapp\\Resources\\images/";
    private static String REAL_PATH = "";
    
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		 REAL_PATH = request.getSession().getServletContext().getRealPath("/Resources/images/");
		 
		 //to check all directory exist
		 
		 if(!new File(ABS_PATH).exists())
		 {
			 new File(ABS_PATH).mkdirs();
		 }
	
		 if(!new File(REAL_PATH).exists())
		 {
			 new File(REAL_PATH).mkdirs();
		 }
	 
		 
		 try
		 {
			 //Server Upload
			 file.transferTo(new File(REAL_PATH + code + ".jpg"));
			 
			 //Project Directory
			 file.transferTo(new File(ABS_PATH + code + ".jpg"));
		 }
		 
		 catch(IOException e)
		 {
		 }
	
		 
	}

}
