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
		<jsp:include page="includes/header.jsp" />
		<div class="panel panel-default">
			<div class="panel-heading">New Diary Entry</div>
			<br />
			<form:form class="form-horizontal" action="saveEntry" commandName="diaryEntry">
				<div class="row">
					<div class="form-group col-md-12">
						<label for="inputTitle" class="control-label col-md-2">Title</label>
						<div class="col-md-6">
							<form:input type="text" maxlength="50" class="form-control"
								id="title" path="title" />
							<form:errors path="title" cssStyle="color: red" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label for="inputPost" class="control-label col-md-2">Post</label>
						<div class="col-md-9">
							<form:textarea class="form-control" rows="8" id="post"
								path="post" maxlength="2000"></form:textarea>
							<form:errors path="post" cssStyle="color: red" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success btn-md">Save</button>
							<a href="<c:url value='/list'/>">
								<button type="button" class="btn btn-danger btn-md">Cancel</button>
							</a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>