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
						[ 'W1 JUNE 2018', 1000, 400, 200, 100, 900 ],
						[ 'W2 JUNE 2018', 1170, 460, 250, 300, 100 ],
						[ 'W3 JUNE 2018', 660, 1120, 300, 500, 700 ],
						[ 'W4 JUNE 2018', 1030, 540, 350, 800, 900 ] ]);

		var options = {
			chart : {
				title : 'Mobile Site Speed Comparasion',
				subtitle : 'in miliseconds (ms)'
			},
	          bars: 'vertical',
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
			[ 'W1 JUNE 2018', 2234, 2374, 1608, 2374, 1997 ],
			[ 'W2 JUNE 2018', 2237, 2285, 1587, 2236, 1905 ],
			[ 'W3 JUNE 2018', 2237, 2285, 1587, 2236, 1905 ]]);


		var options = {
			chart : {
				title : 'Alexa | Average Load Time',
				subtitle : 'in milliseconds (ms)'
			},
			width : 800,
			height : 400,
			vAxis: {format: ''},
			colors : [ '#ff7d1d', '#42b549', '#F15A29', '#1a9cb7', '#0095da' ]
		};

		var chart = new google.charts.Line(document.getElementById('linechart_material'));
		//var chart = new google.visualization.LineChart(document.getElementById('linechart_material'));
		
		google.visualization.events.addListener(chart, 'ready', function () {
			
		    //var imgUri = chart.getImageURI();
		    
		    //alert("url:"+imgUri);
		    // do something with the image URI, like:
		    //window.open(imgUri);
		    
		    //document.getElementById('linechart_material_2').innerHTML = '<img src="' + imgUri + '">';
		});
		
		chart.draw(data, google.charts.Line.convertOptions(options));
	}
</script>
</head>

<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">paingan-boot-charts2</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

<!-- 		<div class="starter-template"> -->
<!-- 			<h1>Spring Boot Web JSP Example</h1> -->
<%-- 			<h2>Message: ${message}</h2> --%>
<!-- 		</div> -->


		<div id="columnchart_material"></div>
		<div id="linechart_material"></div>
<!-- 		<div id="linechart_material_2"></div> -->
	</div>
	<script type="text/javascript" src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>

</html>