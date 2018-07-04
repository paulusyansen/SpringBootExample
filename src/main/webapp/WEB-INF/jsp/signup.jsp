<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this, Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>

<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="/"><c:out value="${title}" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		    <ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href="/">Home</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/chart">Chart</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/form">Data</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link active" href="/sign-up">Sign up</a>
		      </li>    
		    </ul>
		 </div>
	</nav>


		
	<div class="container-fluid">
<!-- 		<div class="alert alert-warning" role="alert"> -->
<!-- 		  This is a <strong>average</strong> score! -->
<!-- 		</div> -->
		<div class="card position-relative">
			<div class="card-header"><strong>4G - Average Load Time</strong></div>
			<div class="card-body">
				<form>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputDate">Date</label> 
							<input type="text" class="form-control" id="inputDate" placeholder="Date">
						</div>
						<div class="form-group col-md-2">
							<label for="inputSite">Site</label> 
							<select id="inputSite" class="form-control">
								<option selected>Choose...</option>
								<option value="elevenia">elevenia</option>
								<option value="tokopedia">tokopedia</option>
								<option value="shopee">shopee</option>
								<option value="lazada">lazada</option>
								<option value="blibli">blibli</option>
							</select>
						</div>
						<div class="form-group col-md-2">
							<label for="inputPage">Page</label> 
							<select id="inputPage" class="form-control">
								<option selected>Choose...</option>
								<option value="main">main</option>
								<option value="category">category</option>
								<option value="pdp">pdp</option>
								<option value="search">search</option>
							</select>
						</div>
						<div class="form-group col-md-2">
							<label for="inputDevice">Device</label> 
							<select id="inputDevice" class="form-control">
								<option selected>Choose...</option>
								<option value="ios">ios</option>
								<option value="android">android</option>
							</select>
						</div>
						<div class="form-group col-md-2">
							<label for="inputScore">Score</label> 
							<input type="text" class="form-control" id="inputScore" placeholder="Score">
						</div>
					</div>
					<button type="button" class="btn btn-primary" id="form-add">Add</button>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function () {

	    $("#form-add").click(function (e) {
	        e.preventDefault();
	        var data = {};
	        data["inputDate"] = $("#inputDate").val();
	        data["inputScore"] = $("#inputScore").val();
	        data["inputSite"] = $("#inputSite").val();
	        data["inputPage"] = $("#inputPage").val();
	        data["inputDevice"] = $("#inputDevice").val();
	        
	        alert(data["inputSite"]);
	         dd	
	    });

	});
	</script>
	
</body>

</html>