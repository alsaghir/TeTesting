<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Name</td>
			<td>Title</td>
			<td>Age</td>
			<td>Success</td>
			<td>Options</td>
		</tr>
		<c:forEach items="${sessionScope.entityList}" var="entity">
			<tr>
				<td><c:out value="${entity.name}" /></td>
				<td><c:out value="${entity.title}" /></td>
				<td><c:out value="${entity.age}" /></td>
				<td><c:out value="${entity.success}" /></td>
				<td><a href="<c:url value = "/edit?id=${entity.id}"/>">Update</a> <a href="<c:url value = "/delete?id=${entity.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr />
	<a href='<c:url value = "/entry"/>'>Click Here to Enter Data</a>
</body>
</html>