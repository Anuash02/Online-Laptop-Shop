<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<%-- <form action="${pageContext.request.contextPath}/addToCart" method="get"> --%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">

					<table id="productTable" class="table table-bordered">

						<tr bgcolor="">
							<center><h2><b>Product Description</b></h2></center>
						</tr>
						<tr>
							<td>
							<img src="<c:url value="/Resources/image/${product.prodid}.jpg"/>"/></td>
						</tr>
						<tr>
							<td>Prodcut ID</td>
							<td>${product.proid}</td>
						</tr>
						<tr>
							<td>Prodcut Name</td>
							<td>${product.prodname}</td>
						</tr>
						<tr>
							<td>Supplier</td>
							<td>${product.supid}</td>
						</tr>
						<tr>
							<td>Prodcut Desc</td>
							<td>${product.proddesc}</td>
						</tr>
						<tr>
							<td>Price</td>
							<td>${product.price}</td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td>${product.quantity}</td>
						</tr>
						<tr>
							<td>
								<form action="<c:url value="/addToCart/${proInfo.proid}"/>">Quantity
									<input type="text" name="quantity" onclick="myFunction" class="form-control btn-block"/>
									 <input type="submit" value="addToCart"/>
								</form>
							</td>

						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>