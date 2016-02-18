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
				<div class="col-sm-10"><fmt:formatDate value="${entry.updateDate}"
								pattern="dd/MM/yyyy HH:mm:ss" /></div>
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
				<div class="col-sm-12" align="center">
					<br /> <a href="<c:url value='/list'/>">
						<button type="button" class="btn btn-danger btn-md">Back
							to List</button>
					</a> <br /> <br />
				</div>
			</div>
		</div>
	</div>
</body>
</html>