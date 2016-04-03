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
    List WWN= (List)request.getAttribute("WWN");
    String TeaStr = (String) request.getAttribute("TeaStr");

%>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h2 class="sub-header"><%=TeaStr%></h2>
    <div class="table-responsive">
        <table class="table table-hover">
            <tbody>
            <%
                for (int i=0;i<WWN.size();i++){
                List<String> Art = (List<String>) WWN.get(i);
                 %> <tr> <%
                 for (int i1=0;i1<Art.size();i1++){
                 if ((i1==0)||(i1==1)){
                %><td width="119" style="display:none;"><%=Art.get(i1)%></td><%
                 }
                else {
                %><td width="119"><%=Art.get(i1)%></td><%
                    }
                }
                %> </tr> <%
                }

            %>
            </tbody>
        </table>
    </div>
</div>
<script>
    $(function()	{
        $('tr').click(function()	{
            var val = $(this).html();	//получаем значение ячейки
            var wwn = val.replace('<td width="119" style="display:none;">','')
            wwn = wwn.split('</td>')[0].replace(/\s{2,}/g, '');
            //формируем код текстового поля
            wwn = wwn.replace(/\s+/g, '');
            wwn = '/articles?item='+wwn;
            //alert(wwn);
            document.location.href=wwn;

        });
    });
</script>
</body>
</html>
