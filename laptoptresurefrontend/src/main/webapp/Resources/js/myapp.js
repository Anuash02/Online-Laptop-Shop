$(function()
		
{
	//Solving the active menu problem
	switch(menu)
	{
	case 'About Us':
		$('#AboutUs').addClass('active');
		break;
	case 'Contact Us':
		$('#ContactUs').addClass('active');
		break;
	case 'Category':
		$('#Category').addClass('active');
		break;
	case 'AllProducts':
		$('#listProducts').addClass('active')
		break;
	case 'View Products':
		$('#Products').addClass('active');
		break;
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
		
	case 'Manage Category':
		$('#manageCategory').addClass('active');
		break;
		
	case 'Sign Up':
		$('#signup').addClass('active');
		break;
		
		if(menu=="Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	// Code for jquery datatables
	//create dataset
	
	var $table = $('#productlistTable');
 	if($table.length)
 	{
	       var jsonUrl = '';
	       if(window.catid == ''){
	    	   jsonUrl = window.contextRoot + '/json/data/all/products';
	       }
	       
	       else{
	    	   jsonUrl = window.contextRoot + '/json/data/category/'+ window.catid +'/products';
	       }
	          
 		//console.log('Inside the table!');
 		$table.DataTable({
 			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']],
     	   pageLength: 5,
     	   ajax:   //object 
     		   {
     		     url: jsonUrl,
     		     dataSrc: '' //Collection of objects without any name
     		   },
     		   columns: [
     		             
     		            {
       			        	data: 'code', //string used for Image
       			        	mRender: function(data,type,row){
       			        		
       			        		return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
       			        	}
       			        	},
     			          	
     			        	 {
      			        	  data: 'prodname'
      			          },
      			          
      			        {
    			        	  data: 'quantity',
    			        	  mRender: function(data,type,row)
    			        	  {
    			        		  if(data<1)
    			        			  {
    			        			      return '<span style="color:red">Out Of Stock!</span>';
    			        			  }
    			        	      return data;
    			        	  }
      			          
      			          
    			          },
    			          
    			          {
    			        	  data: 'price',
    			              mRender: function(data, type, row)
    			              {
    			            	return '&#8377; ' + data  //&#8377 is the code for Rupee
    			               }      
    			          },
    			          
    			          
   			         
   			         {
 			        	   data : 'prodid',
 			        	  bSortable: false,
 			              mRender: function(data, type, row){
 			        	   var str = '';
 			        	   str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160;';
 			        	   			        	   
 			        	   return str;
 			        	   
 			        	   }
  			          }
    			          
    			          
   			          ]
    			          
 			});
 	}
 			
		
 	
 	//Dismissing Alert after 3 seconds
 	var $alert=$('.alert');
 	  if($alert.length)
 		  {
 		    setTimeout(function(){
 		    		$alert.fadeOut('slow');
 		    },3000)
 		  
 		  }
	
 	  //--------------------------Data Tables For Admin Product----------------------
 	 var $adminProductsTable = $('#AdminProductsTable');
  	
  	if($adminProductsTable.length)
  		{
  		       var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
  		       
  		          
  	           $adminProductsTable.DataTable( {
  	        	   
  	        	   lengthMenu: [[10,30,50,-1], ['10 Records', '30 Records', '50 Records', 'ALL']],
  	        	   pageLength: 30,
  	        	   ajax:
  	        		   {
  	        		     url:jsonUrl,
  	        		     dataSrc:''
  	        		   },
  	        		   columns: [
  	        			             {
      			        	              data: 'prodid'
      			                     },
  	        			            {
  	        			        	  data : 'code', 
  	        			        	  bSortable : false,
  	        			        	  mRender : function(data,type,row){
  	        			        		  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
  	        			        	 }	  
  	        			           },
  	        			          {
  	        			        	  data: 'prodname'
  	        			          },
  	        			          {
  	        			        	  data: 'quantity',
  	        			        	  mRender : function(data,type,row)
  	        			        	  {
  	        			        		  if(data<1){
  	        			        			  return '<span style="color:red">Out of Stock!</span>';
  	        			        		  }
  	        			        		  return data;
  	        			        	  }
  	        			          },
  	        			          {
  	        			        	  data: 'price',
  	        			              mRender: function(data, type, row){
  	        			            	return '&#8377;' + data  
  	        			                }      
  	        			          }, 
  	        			          {
  	        			        	   data : 'prodid',
  	        			        	   bSortable: false,
  	        			        	   mRender: function(data, type, row){
  	        			        	   var str = '';
  	        			        	// str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-primary btn-xs">';
  	        			        	str += '<a href="'+window.contextRoot+ '/manage/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>&#160;';
	        			        
	        			        	  
	        			        	 str += '<a href="'+window.contextRoot+'/manage/delete/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span></a>&#160;';
	        			        	
	        			        	             
	        			        	   return str;
	        			        	   
	        			        	   } 	        			        
	        			          }
	        			          
	        		            ]
  	         }) ;
  		}
  	        		   
  	        		 //--------------------------Data table ends here----------------------

  	        			
  	        		 	
  	        		 	
  	        		 	//------------------------------Data table for Admin for Category----------
  	        		 	
var $adminCategoryTable = $('#AdminCategoryTable') ;
	
	// execute the following code only where we have this table 
	if($adminCategoryTable.length) {
		
	//	console.log('Inside the table') ;
	
	var jsonUrl = window.contextRoot + '/json/data/admin/all/category' ;
	
		
	$adminCategoryTable.DataTable( {
			
			lengthMenu: [[10,20,50,-1] , ['10 Products' , '20 Products' , '50 Products' , 'ALL Products']], //-1 : display all records else display 10 , 20 and 50 records 
			pageLength: 10 , // no. of records per page
			//data: products
			
			ajax : {
				
				url: jsonUrl ,
				dataSrc: '' //collection of objects without any name 
			} ,
			
			columns : [
				
						{
							
							data: 'catid'
							
						} ,
						
						{
							data: 'catname' 
						} ,
						
						{
							data: 'catdesc'
						} ,
						{
							data : 'catid' ,
							bSortable: false , // removes sorting symbol from the last column
							mRender : function(data, type, row) { // here , data represents the id but row contains information about the entire product 
								
								var str = '' ;
						
								// for editing or updating the category
								str += '<a href = "'+window.contextRoot+'/manage/'+data+'/category" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;&#160; '
								
								// for deleting the category
								str += '<a href = "'+window.contextRoot+'/manage/delete/'+data+'/category" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span></a>'

								
								return str ;
								
							}
						}
										
			]
			
		}) ;
		
	}
	// *****************	Categories End		*****************

  	        			//------------------------------------Data table for Category ends here--------------

	        		   
  		
	        
		
});
		      