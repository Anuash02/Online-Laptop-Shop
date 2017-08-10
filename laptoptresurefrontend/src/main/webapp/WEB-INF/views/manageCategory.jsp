<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<style>
body {
	background-color: #ac5353;
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
					

					<h3 align="center">Manage Category</h3>

				</div>
				

				<div class="panel-body">
					
					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST">
						<!-- modelAttribute name same as in m.addAttribute name in CategoryController.java -->
						
						<!-- for category name -->
						<div class="form-group">
							
							<label class="control-label col-md-4" for="catname">Enter
								Category Name : </label>

							<div class="col-md-8">
								
								<sf:input type="text" path="catname" id="catname"
									placeholder="Category Name" class="form-control" />
								<%--  	<em class="help-block">Please enter Category Name ! </em> --%>

								<sf:errors path="catname" cssClass="help-block" element="em" />

							</div>
							

						</div>
						

						<!-- for category description -->
						<div class="form-group">
							
							<label class="control-label col-md-4" for="catdesc">Enter
								Category Description : </label>

							<div class="col-md-8">
								

								<sf:textarea path="catdesc" id="catdesc" rows="2"
									placeholder="Category Description" class="form-control"></sf:textarea>
								<%-- 	<em class="help-block">Please enter Category Description ! </em>  --%>

								<sf:errors path="catdesc" cssClass="help-block" element="em" />

							</div>
							


						</div>
						
						<!-- for submit button -->
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-8">
								

								<input type="submit" name="submit" id="submit"
									value="Add Category" class="btn btn-primary" />
							</div>


							<!-- Hidden field -->
							<sf:hidden path="catid" />


							


						</div>
						



					</sf:form>
					
				</div>
				

			</div>
			

		</div>
		


	</div>
	
	<!--  Start of Data Table for Admin -->

	<div class="row">
		

		<div class="col-xs-12">
			

			<h3>Available Categories</h3>
			<hr />

		</div>
		

		<div class="col-xs-12">
			

			<div style="overflow: auto">
				

				<!-- Category table for admin -->
				<table id="AdminCategoryTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>ID</th>
							<th>Category Name</th>
							<th>Category Description</th>
							<th>Edit</th>
							
						</tr>

					</thead>

					<tfoot>
						<tr>
							<th>ID</th>
							<th>Category Name</th>
							<th>Category Description</th>
							<th>Edit</th>
							
						</tr>
					</tfoot>

				</table>

			</div>
			

		</div>
		
	</div>
	
	<!--  End of data table for Admin -->
</div>
