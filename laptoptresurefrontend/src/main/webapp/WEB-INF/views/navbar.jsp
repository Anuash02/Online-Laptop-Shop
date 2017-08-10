<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Laptop Treasure</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                <security:authorize access="isAnonymous()">
                    <li id="AboutUs">
                        <a href="${contextRoot}/about">About Us</a>
                    </li>
                    
                    
                    
                    <li id="ContactUs">
                        <a href="${contextRoot}/contact">Contact Us</a>
                    </li>
                    </security:authorize>
                                       
                    <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <c:forEach items="${list}" var="category">
                       <li><a href="${contextRoot}/show/category/${category.catid}/products" id="a_${category.catname}">${category.catname}</a></li>
                    </c:forEach>
                  </ul>
                       </li>
                   
                  <li id ="listProducts"><a href="${contextRoot}/show/all/products">Products</a>
                  </li>
                  
                  <li>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<a href="">Welcome ${pageContext.request.userPrincipal.name }</a>
			</c:if>
		</li>
		
		
		<li>
		
		
		
		
		</li>
		<security:authorize access="hasAuthority('USER')">
       <li id="cart"><a href="${contextRoot}/cart/getcart">Cart</a></li> 
      	</security:authorize>
      	


                 <c:if test="${pageContext.request.userPrincipal.name!=null }">
                     <security:authorize access="hasAuthority('ADMIN')">

                <li id ="manageProducts"><a href="${contextRoot}/manage/products">Manage Products</a>
                </li>
                    
                
                <li id ="manageCategory"><a href="${contextRoot}/manage/category">Manage category</a>
                </li>
                 </security:authorize>
                  </c:if>
                
                <ul class="nav navbar-nav navbar-right">
                <c:if test="${pageContext.request.userPrincipal.name==null }">
                    <li><a href="${contextRoot}/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li id=login><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                  </ul>
                  </c:if>
                  
                   <c:if test="${pageContext.request.userPrincipal.name!=null }">
                   <li id=logout><a href="${contextRoot}/j_spring_security_logout">Logout</a></li>
                   </c:if>
	        	   </ul>
	        	 
		
		
		  <!--  
                       <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            
            <li id=login><a href="${contextRoot}/login">Login</a></li>
                </ul>
                -->
		
            </div>
            <!-- /.navbar-collapse -->
        </div>
        
        
      
       
        <!-- /.container -->
    </nav>
    
