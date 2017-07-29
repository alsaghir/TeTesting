<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Entry</title>
</head>
<body>
<form id="theForm" action="${empty fn:escapeXml(toEditEntity.id) ? 'entry' : 'edit'}" method="POST">
<input type="hidden" name="id" value="${empty fn:escapeXml(toEditEntity.id) ? '' : fn:escapeXml(toEditEntity.id)}" />
<label>Name: <br /><input type="text" name="name" value="${empty fn:escapeXml(toEditEntity.id) ? '' : fn:escapeXml(toEditEntity.name)}" required /></label>
<br />
<label>Title: <br /><input type="text" name="title" value="${empty fn:escapeXml(toEditEntity.id) ? '' : fn:escapeXml(toEditEntity.title)}" required /></label>
<br />
<label>Age: <br /><input type="number" name="age" required value="${empty fn:escapeXml(toEditEntity.id) ? '' : fn:escapeXml(toEditEntity.age)}" /></label>
<br />
<label>Success: <br /><input type="checkbox" name="success" ${empty fn:escapeXml(toEditEntity.id) ? '' : (fn:escapeXml(toEditEntity.success) ? 'checked' : '')} /></label>
<br />

<input type="submit" name="submitEmployee" value="Enter Data" />

</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<script>
$(document).ready(function () {

    //$('#theForm').validate();

});
</script>
</body>
</html>