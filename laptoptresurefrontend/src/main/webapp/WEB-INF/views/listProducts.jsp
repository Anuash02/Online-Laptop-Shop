<style>
body {
	background-color: #ffffff;
}
</style>
<div class="container">

	<div class="row">

				
		<!-- To display the actual products -->

		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">


				<div class="col-lg-12">

					<!-- for All Products -->
					<c:if test="${userClickAllProducts == true }">

						<script>
							window.catid = '';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>

							<li class="active">All Products</li>

						</ol>
					</c:if>




					<!-- for Category Products -->

					<c:if test="${userClickCategoryProducts == true }">

						<script>
							window.catid = '${category.catid}';
						</script>



						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.catname}</li>

						</ol>
					</c:if>

				</div>
				<!-- End of col-lg-12 class -->

				<div class="row">
					<!-- start of row 2 -->

					<div class="col-xs-12">

						<table id="productlistTable"
							class="table table-striped table-bordered">

							<thead>

								<tr>

									<%-- 	<th>ID</th>	  --%>
									
									<th></th>
									<th>Name</th>
									<th>Quantity</th>
									<th>Price</th>
									<th></th>
										
								</tr>

							</thead>

							
                            
                              
							<tfoot>

								<tr>

									<%-- 	<th>ID</th>	  --%>
									<th></th>
									<th>Name</th>
									<th>Quantity</th>
									<th>Price</th>
									<th></th>
								 		
								</tr>
 
							</tfoot>  



						</table>


					</div>
					<!-- End of col-xs-12 class -->






				</div>
				<!-- End of row 2 -->




			</div>
			<!-- End of row in col-md-9 -->

		</div>
		<!-- End of col-md-9 class -->

	</div>
	<!-- End of row -->

</div>
<!-- End of container class -->