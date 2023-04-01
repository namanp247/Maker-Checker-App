<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>This is a Form</title>
</head>
<body>

<%--redirect to makerController and run the makerView method--%>
<a href="maker">maker</a>
<a href="checker">checker</a>

<%-- invalidate the user session--%>
    <c:url var="logout" value="/logout">
    </c:url>
    <form:form action="${logout}" method ="post">
    <div>
        <button input type="submit" value="logout">Logout</button>
    </div>
    </form:form>

</body>
</html>