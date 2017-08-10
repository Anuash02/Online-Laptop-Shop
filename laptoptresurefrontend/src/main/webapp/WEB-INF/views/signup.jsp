
<!-- Container (Contact Section) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	background-color: #ffe6e6;
}
</style>


<div class="container">
	<!-- Start of container class -->



	<div class="row">
		<!-- Start of first row class -->


		<c:if test="${not empty message}">
			<div class="col-xs-12">
				
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>



			</div>
			
		</c:if>






		<%--
	<div class="row">
		<!-- Start of first row class -->
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<!-- Start of col-xs-12 class -->
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
			<!-- End of col-xs-12 class -->
		</c:if>
--%>

		<%--		
		<c:if test="${not empty message}">
			<div class="row">
				<!-- Start of first row class -->
				<div class="col-md-offset-3 col-md-6">
					<!-- start of col-md-3 class (3 and 6 resp) -->
					<div class="alert alert-danger">${message}</div>
				</div>
				<!-- End of first row class -->
			</div>
			<!-- End of col-md-3 class (3 and 6 resp) -->
		</c:if>
--%>

		<div class="col-md-offset-2 col-md-8">
			<!-- Start of col-md-6 class -->

			<div class="panel panel-primary">
				<!-- Start of panel-primary class -->

				<div class="panel-heading">
					<!-- Start of panel-heading class -->

					<h3>Registration Page</h3>

				</div>
				<!-- End of panel-heading class -->

				<div class="panel-body">
					<!-- Start of panel body class -->

					<!-- Start of form class -->
					<form action="${contextRoot}/register/newUser" method="POST"
						class="form-horizontal">

						<!-- For Customer Name : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="custname" class="col-md-4 control-label">
								Customer Name : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<input type="text" name="custname" id="custname"
									class="form-control" />

							</div>
						
						</div>
						
						<!-- For username : -->
						<div class="form-group">
							

							<label for="username" class="col-md-4 control-label">
								UserName : </label>

							<div class="col-md-8">
								

								<input type="text" name="username" id="username"
									class="form-control" />

							</div>
							

						</div>
						


						<!-- For Email Address : -->
						<div class="form-group">
							

							<label for="email" class="col-md-4 control-label">
								Email-Id. : </label>

							<div class="col-md-8">
								
								<input type="text" name="email" id="email" class="form-control"
									required
									pattern="[A-Za-z0-9._%+-]{3,}@[a-zA-Z]{3,}([.]{1}[a-zA-Z]{2,}|[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,})" />

							</div>
							
						</div>
						

						<!-- End of Email Address part -->


						<!-- For Password : -->
						<div class="form-group">
							

							<label for="password" class="col-md-4 control-label">
								Password : </label>

							<div class="col-md-8">
								

								<input type="password" name="password" id="password"
									class="form-control" required /> <em class="help-block">Please
									enter valid password ! </em>

							</div>
							
						</div>
						


						<!-- For Address : -->
						<div class="form-group">
							<!-- Start of first form-group -->

							<label for="address" class="col-md-4 control-label">
								Address : </label>

							<div class="col-md-8">
								<!-- Start of col-md-8 class -->

								<textarea name="address" id="address" rows="3"
									class="form-control">
								</textarea>

							</div>
							

						</div>
						

						<!-- End of Address part -->


						<!-- For Mobile Number : -->
						<div class="form-group">
							

							<label for="mobile" class="col-md-4 control-label">
								Contact Number : </label>

							<div class="col-md-8">
								

								<input type="number" name="mobile" id="mobile"
									pattern="[0-9]{10}" class="form-control" required /> <em
									class="help-block">Please enter valid 10 digit number ! </em>

							</div>
							

						</div>
						

						<!-- For SignUp button : -->
						<div class="form-group">
							
							<div class="col-md-4 col-md-8">
								

								<input type="submit" value="Sign Up"
									class="btn btn-primary" /> <input type="hidden"
									name="${_csrf.parameterName}" value="${_csrf.token}" />


							</div>
							

						</div>
						

					</form>
					

				</div>
				

			</div>
			

		</div>
		

	</div>
	

</div>

