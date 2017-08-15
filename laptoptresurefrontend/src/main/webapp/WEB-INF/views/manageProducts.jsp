<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<style>
body {
	background-color: #ffffff;
}
</style>
<div class="container">


	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>
				</div>

				<div class="panel-body">
					<!-- Start of panel-body class -->
					<!-- Form Elements -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">



						<div class="form-group">
							<label class="control-label col-md-4" for="prodname">Enter
								Product Name : </label>

							<div class="col-md-8">
								<sf:input type="text" path="prodname" id="prodname"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="prodname" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="proddesc">Enter
								Product Description : </label>

							<div class="col-md-8">
								<sf:textarea path="proddesc" id="proddesc" rows="2"
									placeholder="Product Description" class="form-control"></sf:textarea>
								<sf:errors path="proddesc" cssClass="help-block" element="em" />

							</div>
						</div>




						<div class="form-group">
							<label class="control-label col-md-4" for="price">Enter
								Product Price : </label>

							<div class="col-md-8">
								<sf:input type="number" path="price" id="price"
									placeholder="Product Price in &#8377; " class="form-control" />
								<sf:errors path="price" cssClass="help-block" element="em" />

							</div>
						</div>
						
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Product Quantity : </label>

							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Product Quantity" class="form-control" />
								<em class="help-block">Please enter available quantity ! </em>
							</div>
						</div>



						<!-- for Category Id. -->
						<div class="form-group">
							<!-- Start of form-group class -->

							<label class="control-label col-md-4" for="catid" class="active">
								Select Category : </label>

							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->

								<sf:select class="form-control" path="catid" id="catid"
									items="${category}" itemLabel="catname" itemValue="catid" />                            
							</div>
						</div>
  
  <!-- for Supplier Id. -->
  
						 <!--<div class="form-group">
							<!-- Start of form-group class -->
							<!-- 
							<label class="control-label col-md-4" for="supid" class="active">
								Select Supplier : </label>
							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->-->
                               <!-- 
								<sf:select class="form-control" path="supid" id="supid"
									items="${supplier}" itemLabel="supname" itemValue="supid" /> --> 
						
									
									
									<!-- for File element to upload image -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image : </label>
							<div class="col-md-8">
								<!-- Start of second col-md-8 class -->
								<input type="file" name="file" id="file"
									class="form-control" />
								
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
							<!-- End of second col-md-8 class -->
						</div>

								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<input type="submit" name="submit" id="submit"
											value="Add Product" class="btn btn-primary" />
									</div>

									<sf:hidden path="supid" />
									<sf:hidden path="prodid" />
								</div>
							</div>
					</sf:form>
				</div>
			</div>
			
			
		</div>
	</div>
	<div class="row">
		<!-- Start of second row class -->

		<div class="col-xs-12">
			<!-- Start of col-xs-12 class in second row class -->







		</div>
		<!-- End of col-xs-12 class in second row class -->


		<div class="col-xs-12">
			<!-- Start of col-xs-12 class again in second row class -->

			<h3>Available Products</h3>
			<hr />

			<div style="overflow: auto">
				<!-- Start of overflow style -->

				<!-- Products table for admin -->
				
				 <table id="AdminProductsTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>Product ID</th>
							<th>&#160;</th>
							<th>Product Name</th>
							<th>Product Quantity Available</th>
							<th>Product Price</th>
							<th>Edit</th>
						</tr>
					</thead>

					

					<tfoot>
						<tr>
							<th>Product ID</th>
							<th>&#160;</th>
							<th>Product Name</th>
							<th>Product Quantity Available</th>
							<th>Product Price</th>
							<th>Edit</th>
						</tr>
					</tfoot>





				</table> 

				
	
</div>
</div>
</div>
</div>




