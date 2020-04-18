<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><c:out value="${song.name}"/> Details</title>
	
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<p>Title: ${song.name}</p>
	<p>Artist: ${song.artist}</p>
	<p>Rating (1-10): ${song.rating}</p>
	<a href="/songs/delete/${song.id}">Delete</a>
</body>