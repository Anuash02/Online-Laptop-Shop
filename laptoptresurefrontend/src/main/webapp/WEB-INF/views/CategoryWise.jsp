<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
 <script src="resources/js/bootstrap.min.js"></script>
 <script src="resources/js/jquery.min.js"></script>
 
 <%@include file="index.jsp"%>

 
<body background="Resources/images/bg2.jpg">
	<h2>
		<center>Categorywise Products..!!</center>
	</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<c:forEach items="${prodlist}" var="product">

					<a href="ProDescription/${product.prodid}" class="Thumbnail"> <image
						src="<c:url value="/Resources/images/${product.prodid}.jpg"/>" /></a>
					<div class="caption">
						<h4>${product.prodname}</h4>

						<p>${product.price}</p>
					</div>
				</c:forEach>
				
			</div>
		</div>
	</div>
</body>

</html>