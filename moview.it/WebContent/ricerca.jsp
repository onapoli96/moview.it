<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.Film"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/blog-home.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://use.fontawesome.com/5ac93d4ca8.js"></script>
<script type="text/javascript" src="js/bootstrap4-rating-input.js"></script>
<meta charset="ISO-8859-1">
<title>Ricerca</title>
</head>
<body>
	<%@include file="parts/nav.jsp"%>
	<!-- Page Content -->
	<div class="container">

		<div class="row">
		<div class="col-md-4 mt-3">
				<%@include file="parts/sidenav.jsp"%>
			</div>			
			<%@include file="parts/risultati.jsp"%>	
		</div>
	</div>

</body>
</html>