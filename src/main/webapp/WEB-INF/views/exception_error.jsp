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

<title>My Own Diary</title>
</head>
<body>
	<div class="container">
		<jsp:include page="includes/header.jsp" />
		<h2>Exception</h2>
		<br /> ${exception}
		<p />
		<p />
		<a href="<c:url value='/list'/>">
			<button type="button" class="btn btn-danger btn-md">Back to
				List</button>
		</a>
	</div>
</body>
</html>