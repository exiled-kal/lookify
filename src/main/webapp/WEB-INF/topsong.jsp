<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Search</title>
	<link rel="stylesheet" type="text/css" href="css/topSongs.css">
</head>
<body>
	<h3>Top Ten Songs</h3>
	<a href="/dashboard">Dashboard</a>
	<c:forEach var="song" items="${songs}">
		<li>${song.rating} - <a href="/songs/${song.id}"><c:out value="${song.name}"/></a> - ${song.artist}</li>
	</c:forEach>
</body>
