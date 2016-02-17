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
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/t/dt/dt-1.10.11/datatables.min.css" />
<style type="text/css" rel="stylesheet">
body {
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 10px;
}
</style>

<script src="<c:url value='/resources/js/jquery-2.2.0.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/t/dt/dt-1.10.11/datatables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#postEntries').DataTable();
	});

	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<title>My Own Diary</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>My Own Diary</h1>
			<p>Simple application to show IBM Bluemix and IBM Watson features</p>
		</div>

		<a href="<c:url value='/newEntry'/>" class="btn btn-primary btn-md">New
			Entry</a> <br /> <br />
		<table id="postEntries" class="table table-striped table-bordered"
			cellspacing="1" width="100%">
			<thead>
				<tr>
					<th>Title</th>
					<th>Post</th>
					<th>Post Date</th>
					<th>Last Update</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${entries}" var="entry">
					<tr>
						<td>${entry.title}</td>
						<td>
							<!-- Get just first 25 characters from original post --> <c:set
								var="originalPost" value="${entry.post}" /> <c:set
								var="minimalPost" value="${fn:substring(originalPost, 0, 25)}" />
							${minimalPost} ...
						</td>
						<td><fmt:formatDate value="${entry.createDate}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td><fmt:formatDate value="${entry.updateDate}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td>
							<a href="<c:url value='/viewEntry'/>/${entry.id}" data-toggle="tooltip" data-placement="top" title="View entry">
								<button type="button" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-zoom-in"></span>
								</button>
							</a>
							<a href="<c:url value='/prepareEditEntry'/>/${entry.id}" data-toggle="tooltip" data-placement="top" title="Edit entry">
								<button type="button" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-edit"></span>
								</button>
							</a>
							<a href="<c:url value='/deleteEntry'/>/${entry.id}" data-toggle="tooltip" data-placement="top" title="Delete entry">
								<button type="button" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>