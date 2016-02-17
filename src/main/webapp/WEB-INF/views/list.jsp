<%@ include file="includes/taglibs.jsp"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" type="text/css" />

<style type="text/css">
body {
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 10px;
}
</style>

<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>
<title>My Own Diary</title>
</head>
<body>
	<div class="page-header" align="center">
		<img src="<c:url value='/resources/img/mindstorms.jpg' />" />
	</div>
	<a href="<c:url value='/newEntry'/>" class="btn btn-primary btn-md">New Entry</a>
	<br />
	<br />
	<div class="panel panel-default" align="center">
		<div class="panel-heading">Diary Entries</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Text</th>
					<th>Post Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${entries}" var="entry">
					<tr>
						<td>${entry.id}</td>
						<td>${entry.title}</td>
						<td>${entry.body}</td>
						<td>${entry.entryDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>