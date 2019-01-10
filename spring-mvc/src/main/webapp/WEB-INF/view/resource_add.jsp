<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>
	<jsp:include page="../view/fragment/header.jsp"></jsp:include>

	<div class="container">

		<div class="row">
			<h1>Resource</h1>
		</div>

		<spring:url value="/resource/review" var="formUrl" />

		<form:form action="${formUrl}" method="POST" modelAttribute="resource">

			<div class="row">

				<div class="form-group">
					<label for="resource-name">Name</label>
					<!-- <input type="text" name="name" class="form-control" id="resource-name"> -->
					<form:input path="name" cssClass="form-control" id="resource-name" />
				</div>
 
				<div class="form-group">
					<label for="resource-type">Type</label>
					<form:select path="type" items="${typeOptions}"
						cssClass="selectpicker" />
					<!-- <select id="resource-type" name="type" class="selectpicker">
						<option></option>
						<option value="material">Material</option>
						<option value="other">Other</option>
						<option value="staff">Staff</option>
						<option value="tech">Technical Equipment</option>
					</select> -->
				</div>

				<div class="form-group">
					<label for="cost">Cost</label> <input id="cost" type="text"
						name="cost" />
				</div>

				<div class="form-group">
					<label for="unit">Unit of Measure</label><br>
					<form:radiobuttons path="unitOfMeasure" items="${radioOptions}"
						id="unit" />
				</div>
				<div class="form-group">
					<label for="indicators">Indicators</label><br>
					<form:checkboxes path="indicators" items="${checkOptions}"
						id="indicators" />
						<a id="request-link" href="<spring:url value="/resource/request"/>">send Request</a>
				</div>

				<div class="form-group">
					<label for="notes">Notes</label><br>
					<form:textarea path="notes" id="notes" class="form-control" />
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
		</form:form>
		
		<spring:url value="/resource/upload" var="uploadFileUrl" />
		<form action="${uploadFileUrl}" method="post"enctype="multipart/form-data">
File to Upload:<input type="file" name="file"><br>
		<input type="submit" value="Upload">Press here to upload file!
		</form>
	</div>
</body>
</html>