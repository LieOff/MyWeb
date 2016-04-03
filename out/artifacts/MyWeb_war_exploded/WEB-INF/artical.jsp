<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 02.04.2016
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%><%@page language="java" import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
    </div>
</div>
<%
    List Art= (List)request.getAttribute("data");
    List Tea = (List) request.getAttribute("Tea");
    List TeaKod = (List) request.getAttribute("kodTea");
%>
<div class="container">
    <div class="row">

        <div class="col-sm-8 blog-main">

<div class="blog-post">
    <h2 class="blog-post-title"><%=Art.get(2)%></h2>
    <p class="blog-post-meta"><%=Art.get(3)%> by <%
     String auth;
        for (int i=0;i<Tea.size();i++){
        auth =(String) Tea.get(i);
        %><a href="/arttea?Tea=<%=(Integer) TeaKod.get(i)%>">
        <%=auth%></a>
        <%
            if (i!=(Tea.size()-1)){
        %>
        <%=","%><%
                }}

    %></p>

    <p><%=Art.get(1)%></p>

</div><!-- /.blog-post -->
</div>
</div>
</div>
</body>
</html>
