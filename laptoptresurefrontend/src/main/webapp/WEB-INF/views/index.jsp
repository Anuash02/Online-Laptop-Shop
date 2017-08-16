<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Laptop Shopping-${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}'
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<!-- Custom CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
body {
	background-color: #A52A2A;
}
</style>

</head>

  


<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="navbar.jsp"%>

		<!-- index page Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickAboutUs == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContactUs == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			


			<!-- Load Only When user Click  All Products or Category Product-->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Load Only When user Click  ShowProduct-->
			<c:if
				test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

         <!-- Load Only When user Click  Manage Product-->
			<c:if
				test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			 <!-- Load Only When user Click  Manage Category-->
			<c:if
				test="${userClickManageCategory == true}">
				<%@include file="manageCategory.jsp"%>
			</c:if>
			
			<!-- Load Only When user Click Signup -->
<c:if test="${userClickSignUp == true}">
   <%@include file="signup.jsp" %>
</c:if>

<!-- Load Only When user Click Cart -->
<c:if test="${userClickCart == true}">
   <%@include file="cart.jsp" %>
</c:if>

<!-- Load Only When user Click for order -->
<c:if test="${userClickOrder == true}">
   <%@include file="Order.jsp" %>
</c:if>

<!-- Load Only When user Click for Checkout confirmation -->
<c:if test="${userClickConfirmOrder == true}">
  <%@include file="thankyou.jsp" %>
</c:if>
			

		</div>

		<!-- Footer comes Here -->
		<%@include file="footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Data tables Plugins -->
        <script src="${js}/jquery.dataTables.js"></script>
        
        <!-- Data tables Bootstrap script-->
        <script src="${js}/dataTables.bootstrap.js"></script>
        
        <!-- BootBox-->
        <script src="${js}/bootbox.min.js"></script>
        
        
		<!-- Self Coded Java Script -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
