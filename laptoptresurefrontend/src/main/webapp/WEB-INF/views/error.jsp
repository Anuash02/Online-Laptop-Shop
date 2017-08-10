<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

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

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->



</head>
<!-- 
<style>
body {
	background-color: #A52A2A;
}
</style> --> 


<body>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Return to Home</a>
            </div>
            </div>
            </nav>
            
                        
            <!-- End of Navigation  -->
            
            <!--My Page Content -->

		<div class="content">
			<!-- start of Content class  -->

			<div class="container">
				<!-- start of Container class  -->

				<div class="row">
					<!-- start of first row class  -->

					<div class="col-xs-12">
						<!-- start of Col-xs-12 class  -->



						<!-- Display errorTitle and errorDescription  -->
						<div class="jumbotron">
							<!-- start of jumbotron class  -->


							<h2>${errorTitle}</h2>
							<hr />


							<blockquote style="word-wrap: break-word">
								<!-- To bring StackTrace error inside the container - no need of horizontal scroll -->

								${errorDescription}

							</blockquote>




						</div>
						<!-- end of jumbotron class  -->



					</div>
					<!-- end of col-xs-12 class  -->



				</div>
				<!-- end of first row class  -->





			</div>
			<!-- end of Container class  -->

            
            
            
		<!-- index page Content -->

		<!--<div class="content">
		
		

			<!-- Load Only When user Click  All Products or Category Product-->
					

		<!-- Footer comes Here -->
		<%@include file="footer.jsp"%>

		</div>
		</div>
		
</body>

</html>
