<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.loggedIn}">

		<nav class="navbar navbar-inverse">
			<div class="container-fluid">

				<div class="navbar-header">
					<a class="navbar-brand" href="#">E-Kart</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="Admin">Admin</a></li>

					<li><a href="Category">Category</a></li>
					<li><a href="Product">Product</a></li>
					<li><a href="Supplier">Supplier</a></li>
				</ul>


				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">${sessionScope.username}</a></li>

					<li><a href="Login">Log Out</a></li>
				</ul>
			</div>

		</nav>
	</c:if>

	<c:if test="${!sessionScope.loggedIn}">

		<nav class="navbar navbar-inverse">
			<div class="container-fluid">

				<ul class="nav navbar-nav nav navbar-right">
					<li><a href="Admin">Adminhome</a></li>
					<li><a href="Product">Product</a></li>
					<li><a href="Supplier">Supplier</a></li>
					<li><a href="Category">Category</a></li>

				</ul>
			</div>
		</nav>
	</c:if>

</body>
</html>
