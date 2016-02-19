<%@ include file="includes/taglibs.jsp"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />

<style type="text/css">
body {
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 10px;
}
</style>

<script src="<c:url value='/resources/js/jquery-2.2.0.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

<!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table: Emotional Analysis
        var dataEmotionalAnalysis = new google.visualization.DataTable();
        dataEmotionalAnalysis.addColumn('string', 'Emotion');
        dataEmotionalAnalysis.addColumn('number', 'Feelings');
        dataEmotionalAnalysis.addRows([
        	<c:forEach items="${toneInfo.emotionTones}" var="emotionTone">
        		['${emotionTone.name}', ${emotionTone.score}],
        	</c:forEach>
        ]);
        
        // Create the data table: Writing Style
        var dataWritingStyle = new google.visualization.DataTable();
        dataWritingStyle.addColumn('string', 'Writing');
        dataWritingStyle.addColumn('number', 'Styles');
        dataWritingStyle.addRows([
        	<c:forEach items="${toneInfo.writingTones}" var="writingTone">
        		['${writingTone.name}', ${writingTone.score}],
        	</c:forEach>
        ]);

        // Create the data table: Social Analysis
        var dataSocialAnalysis = new google.visualization.DataTable();
        dataSocialAnalysis.addColumn('string', 'Social');
        dataSocialAnalysis.addColumn('number', 'Social');
        dataSocialAnalysis.addRows([
        	<c:forEach items="${toneInfo.socialTones}" var="socialTone">
        		['${socialTone.name}', ${socialTone.score}],
        	</c:forEach>
        ]);

        // Set chart options
        var options = {'width':800,
                       'height':400};

        // Instantiate and draw our chart, passing in some options.
        var chart1 = new google.visualization.BarChart(document.getElementById('chart_div1'));
        chart1.draw(dataEmotionalAnalysis, options);
        
        var chart2 = new google.visualization.BarChart(document.getElementById('chart_div2'));
        chart2.draw(dataWritingStyle, options);
        
        var chart3 = new google.visualization.BarChart(document.getElementById('chart_div3'));
        chart3.draw(dataSocialAnalysis, options);
      }
    </script>

<title>My Own Diary</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>My Own Diary</h1>
			<p>Simple application to show IBM Bluemix and IBM Watson features</p>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading" align="center">View Diary Entry</div>
			<div class="row">
				<label class="col-sm-2">ID</label>
				<div class="col-sm-10">${entry.id}</div>
			</div>
			<div class="row">
				<label class="col-sm-2">Post</label>
				<div class="col-sm-10">
					<fmt:formatDate value="${entry.createDate}"
						pattern="dd/MM/yyyy HH:mm:ss" />
				</div>
			</div>
			<div class="row">
				<label class="col-sm-2">Last Post Update</label>
				<div class="col-sm-10">
					<fmt:formatDate value="${entry.updateDate}"
						pattern="dd/MM/yyyy HH:mm:ss" />
				</div>
			</div>
			<div class="row">
				<label class="col-sm-2">Title</label>
				<div class="col-sm-10">${entry.title}</div>
			</div>
			<div class="row">
				<label class="col-sm-2">Post</label>
				<div class="col-sm-10">${entry.post}</div>
			</div>
			<div class="row">
				<label class="col-sm-2">Emotional Analysis</label>
				<div id="chart_div1" class="col-sm-10" align="center"></div>
			</div>
			<div class="row">
				<label class="col-sm-2">Writing Style</label>
				<div id="chart_div2" class="col-sm-10" align="center"></div>
			</div>
			<div class="row">
				<label class="col-sm-2">Social Analysis</label>
				<div id="chart_div3" class="col-sm-10" align="center"></div>
			</div>
			<div class="row">
				<div class="col-sm-12" align="center">
					<a href="<c:url value='/list'/>">
						<button type="button" class="btn btn-danger btn-md">Back to List</button>
					</a>
				</div>
			</div>
			<p/>
		</div>
	</div>
</body>
</html>