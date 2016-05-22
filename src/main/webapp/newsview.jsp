<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<html>
<head>
    <title>UPortal</title>
    <%@include file="WEB-INF/jspf/css.jspf" %>
</head>
<body>



<%@include file="WEB-INF/jspf/top_bar.jspf" %>


<div class="container">
    <div class="blog-header">
        <h1 class="blog-title"><c:out value="${news.header}"/></h1>
        <c:forEach items="${news.authors}" var="authors">
        <p class="lead blog-description"><c:out value="${DateCreate}"/>,<a href="authors?action=edit&id=<c:out value="${authors.id}"/>"> <c:out value="${authors.lastName}"/></a></p>
        </c:forEach>
    </div>
    <div class="blog-post">
        <p>
            <c:out value="${news.text}" escapeXml="false"/>
        </p>
    </div>
</div>
</div>

</body>
</html>