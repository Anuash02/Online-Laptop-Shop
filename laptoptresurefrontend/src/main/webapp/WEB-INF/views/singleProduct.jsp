<style>
body {
	background-color: #ffffff;
}
</style>

<div class="container">

	<!-- Breadcrumb -->
	<div class="row">


		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">"${product.prodname}</li>


			</ol>


		</div>

	</div>

	<div class="row">

		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img-responsive border"/>

			</div>

		</div>

		<!-- Display the product Description -->
		<div class="col-xs-12 col-sm-8">
			<h2 style="font-size: 20px;">${product.prodname}</h2>
			<hr />
			<p>${product.proddesc}</p>
			<hr />

			<h6 style="font-size: 20px;">
				Price: <strong> &#8377; ${product.price} /-</strong>
				</h4>
				<hr />

				<h6 style="font-size: 20px;">Quantity Available:
					${product.quantity}</h6>
				<hr />

				<c:choose>
					<c:when test="${product.quantity <1}">
						<h6 style="font-size: 20px;">
							Quantity Available <span style="color:red">Out Of Stock!</span>
						</h6>

					</c:when>
					<c:otherwise>
						<h6 style="font-size: 20px;">Quantity Available:${product.quantity}</h6>
					</c:otherwise>
				</c:choose>


                <security:authorize access="hasAuthority('USER')">
				<c:choose>

				<c:when test="${product.quantity<1}">

					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>Add
							to Cart</strike></a>&#160;&#160;&#160;
							
							<a href="${contextRoot}/show/all/products" class="btn btn-info">Back</a>

				</c:when>
				
				


				<c:otherwise>

					<form action="${contextRoot}/cart/add/${product.prodid}/product">
                        <h6 style="font-size:20px;">Enter Units:<input type="text" name="units"></h6><br>
                        <button type="submit" class="btn btn-success">Add to cart</button>
                         </form>
                         
                         

				</c:otherwise>

			</c:choose>
			</security:authorize>
			<security:authorize access="hasAuthority('ADMIN')">
            
                         <a class="btn btn-warning" href="${contextRoot}/manage/${product.prodid}/product">Edit</a>               
         </security:authorize>


			<a href="${contextRoot}/show/all/products" class="btn btn-info">Back</a>






	</div>