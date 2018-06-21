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
		<a class="navbar-brand" href="/">paingan-boot-charts</a>
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
		        <a class="nav-link active" href="/form">Data</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="javascript:void(0);">About</a>
		      </li>    
		    </ul>
		 </div>
	</nav>

	<div class="container">
		<br />
		<div class="alert alert-warning" role="alert">
		  This is a <strong>average</strong> score!
		</div>

		<form>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputDate">Date</label> 
					<input type="text" class="form-control" id="inputDate" placeholder="Date">
				</div>
				<div class="form-group col-md-2">
					<label for="inputScore">Score</label> 
					<input type="text" class="form-control" id="inputScore" placeholder="Score">
				</div>
				<div class="form-group col-md-2">
					<label for="inputSite">Site</label> 
					<select id="inputSite" class="form-control">
						<option selected>Choose...</option>
						<option>elevenia</option>
						<option>tokopedia</option>
						<option>shopee</option>
						<option>lazada</option>
						<option>blibli</option>
					</select>
				</div>
				
				<div class="form-group col-md-2">
					<label for="inputPage">Page</label> 
					<select id="inputPage" class="form-control">
						<option selected>Choose...</option>
						<option>main</option>
						<option>category</option>
						<option>pdp</option>
						<option>search</option>
					</select>
				</div>
				
				<div class="form-group col-md-2">
					<label for="inputDevice">Device</label> 
					<select id="inputDevice" class="form-control">
						<option selected>Choose...</option>
						<option>ios</option>
						<option>android</option>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Add</button>
		</form>
		<br />
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Score</th>
					<th scope="col">Site</th>
					<th scope="col">Page</th>
					<th scope="col">Device</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	
</body>

</html>