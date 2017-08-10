<%@include file="index.jsp"%>

<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
body {
	background-color: #ac5353;
}
</style>

<form:form action="/laptoptresurefrontend/InsertProduct"
	modelAttribute="product" enctype="multipart/form-data">>
<table align="center">
		<tr>
			<td colspan="2"><center>Product Details</center></td>
		</tr>
		<tr>
			<td>Product ID</td>
			<td><form:input path="prodid" /></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><form:input path="prodname" /></td>
			
			
		
		</tr>

		<tr>
			<td>Category</td>
			<td><form:select path="catid">
					<form:option value="0" label="------Select----" />
					<form:options items="${catlist}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td><form:input path="supid" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><form:input path="quantity" /></td>
		</tr>
		<tr>
			<td>Product Desc</td>
			<td><form:textarea path="proddesc" /></td>
		</tr>


		<tr>
			<td>Product Image</td>
			<td><c:if test="${!flag}">
					<form:input type="file" path="pimage" />
				</c:if> <c:if test="${flag}">
					<form:input type="file" path="pimage" value="${product.pimage}" />
				</c:if></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" /></td>
		</tr>
	</table>
</form:form>

<!-- Displaying the Product data using Table -->
<table cellspacing="2" align="center" border="1">

	<tr bgcolor="pink">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>Category Id</td>
		<td>Supplier Id</td>
		<td>Operation</td>
		<td><b>Image</b></td>
	</tr>
	<c:forEach items="${prodlist}" var="product">
		<tr bgcolor="cyan">
			<td>${product.prodid}</td>
			<td>${product.prodname}</td>
			<td>${product.price}</td>
			<td>${product.quantity}</td>
			<td>${product.catid}</td>
			<td>${product.supid}</td>
			<td><a
				href="<c:url value="/laptoptresurefrontend/deleteProduct/${product.prodid}"/>">Delete</a>
				<a
				href="<c:url value="/laptoptresurefrontend/updateProducts/${product.prodid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Completed Displaying Table -->

</body>
</html>