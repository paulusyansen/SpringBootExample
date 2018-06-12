<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this, Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />


<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart','bar','line' ]
	});

	google.charts.setOnLoadCallback(barChart);
	google.charts.setOnLoadCallback(lineChart);

	function barChart() {
		var data = 
			google.visualization.arrayToDataTable([
						[ 'Date', 'elevenia', 'tokopedia', 'shopee', 'lazada',
								'blibli' ],
						[ '2014', 1000, 400, 200, 100, 900 ],
						[ '2015', 1170, 460, 250, 300, 100 ],
						[ '2016', 660, 1120, 300, 500, 700 ],
						[ '2017', 1030, 540, 350, 800, 900 ] ]);

		var options = {
			chart : {
				title : 'Speed Comparasion',
				subtitle : 'Sales, Expenses, and Profit: 2014-2017'
			},
	          bars: 'vertical',
	          vAxis: {format: 'decimal'},
	          width : 800,
	          height: 400,
			colors : [ '#ff7d1d', '#42b549', '#F15A29', '#1a9cb7', '#0095da' ]
		};

		var chart = new google.charts.Bar(document
				.getElementById('columnchart_material'));

		chart.draw(data, google.charts.Bar.convertOptions(options));
	}


	function lineChart() {
		var data = google.visualization.arrayToDataTable([
			[ 'Date', 'elevenia', 'tokopedia', 'shopee', 'lazada', 'blibli' ],
			[ '2014', 1000, 400, 200, 100, 900 ],
			[ '2015', 1170, 460, 250, 300, 100 ],
			[ '2016', 660, 1120, 300, 500, 700 ],
			[ '2017', 1030, 540, 350, 800, 900 ] ]);


		var options = {
			chart : {
				title : 'Box Office Earnings in First Two Weeks of Opening',
				subtitle : 'in milliseconds (ms)'
			},
			width : 800,
			height : 400
		};

		var chart = new google.charts.Line(document.getElementById('linechart_material'));
		chart.draw(data, google.charts.Line.convertOptions(options));
	}
</script>
</head>

<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Message: ${message}</h2>
		</div>


		<div id="columnchart_material"></div>
		<br />
		<div id="linechart_material"></div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>