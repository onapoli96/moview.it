<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Moview</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/blog-home.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://use.fontawesome.com/5ac93d4ca8.js"></script>
<script type="text/javascript" src="js/bootstrap4-rating-input.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>

<body  onload="invioDatiRicerca()">
	<!-- Navigation -->
	<%@include file="parts/nav.jsp"%>
	<!-- Page Content -->
	<div class="container">

		<div class="row">
		<div class="col-md-4 mt-3">
				<%@include file="parts/sidenav.jsp"%>
			</div>
			<!-- Blog Entries Column -->
			<div class="col-md-8 mt-3">

				<div class="row mb-3">
					<div class="col-md-6 " id="filmhome1">
						
					</div>
					<div class="col-md-6" id="filmhome2">
						
					</div>
					<div class="col-md-6" id="filmhome2">
						
					</div>
				</div>

				<!-- Pagination -->
				
			</div>
			
			
		</div>
	</div>
	
</body>

</html>
