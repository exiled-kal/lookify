<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Song</title>
	
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<form:form method="POST" action="/songs/new" modelAttribute="song">
    		<form:label path="name">Name:
    		<form:errors path="name"/>
    		<form:input path="name"/></form:label>
    		
    		<form:label path="artist">Artist:
    		<form:errors path="artist"/>
    		<form:input path="artist"/></form:label>
    		
    		<form:label path="rating">Rating:
    		<form:errors path="rating"/>
    		<form:input type="number" path="rating"/></form:label>
    		
    		<input type="submit" value="Add Song">
    </form:form>
</body>
</html>