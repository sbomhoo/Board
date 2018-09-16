<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<!DOCTYPE html>
<html>
<head>
	<title>Board Project</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>" />
    </c:forEach>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	
	<tiles:insertAttribute name="content" />
	
	<tiles:insertAttribute name="footer" />

    <c:forEach var="script" items="${javascripts}">
        <script src="<c:url value="${script}"/>"></script>
    </c:forEach>
</body>
</html>