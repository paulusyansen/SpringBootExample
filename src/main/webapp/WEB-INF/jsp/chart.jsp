<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this, Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />


<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


</head>

<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="/">${title}</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
		    <ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href="/">Home</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link active" href="/chart">Chart</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/form">Data</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="javascript:void(0);">Login</a>
		      </li>    
		    </ul>
		 </div>
	</nav>

	<div class="container-fluid">
		<br />
		<div class="alert alert-primary">
	    <strong>Primary!</strong> Indicates an important action.
	  	</div>
		<div id="columnchart_material"></div>
		<div id="linechart_material"></div>
	</div>
	
	<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart','bar','line' ]
	});

	google.charts.setOnLoadCallback(barChart);

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
				title : 'Mobile Site Speed Comparison',
				subtitle : 'in miliseconds (ms)'
			},
	       	bars: 'vertical',
	        width : 800,
	        height: 400,
	        vAxis: {format: ''},
			colors : [ '#ff7d1d', '#42b549', '#F15A29', '#1a9cb7', '#0095da' ]
		};

		var chart = new google.charts.Bar(document
				.getElementById('columnchart_material'));

		chart.draw(data, google.charts.Bar.convertOptions(options));
	}
	
	
	

	//var alexaData = [[ 'Date', 'elevenia', 'tokopedia', 'shopee', 'lazada', 'blibli' ]];
	

	google.charts.setOnLoadCallback(lineChart);
	
	function lineChart() {

		var dataArray = [];
		
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'date');
		data.addColumn('number', 'elevenia');
		data.addColumn('number', 'tokopedia');
		data.addColumn('number', 'shopee');
		data.addColumn('number', 'lazada');
		data.addColumn('number', 'blibli');
	
		$.ajax({
			type : "GET",
			url : "/ajax/chart/alexa/search?q=sortasc:date,showYn:1",
			dataType : "json",
			success: function(result){
				if(result.status == "OK"){
					 $.each(result.data, function (i, obj) {
						 dataArray.push([obj.date, obj.elevenia, obj.tokopedia, obj.shopee, obj.lazada, obj.blibli]);
					 });
					
					 data.addRows(dataArray);
				} else {
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});	
		
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
		chart.draw(data, google.charts.Line.convertOptions(options));
	}
	</script>
</body>

</html>