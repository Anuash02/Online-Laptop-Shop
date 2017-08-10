<%@include file="index.jsp"%>

<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="navbar.jsp"%>

<h2> hello user</h2>
<div id="container">
   <div class="row">
       
   <div class="col-md-12">
						<c:forEach items="${prodlist}" var="product">
						<a href="ProDescription/${product.prodid }" class="Thumbnail">
						<img src="<c:url value="/Resources/productImage/${product.prodid}.jpg"/>"/></a>
							<div class="caption">
							<p>${product.prodname}</p>
							
							<p>${product.price}</p>
							</div>
						</c:forEach>
					
				</div>
			</div>
		</div>
	
	<!-- Completed Displaying Table -->

</body>

</html>