<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 26.03.2016
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%><%@page language="java" import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<html>
<head>
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

<div class="table-responsive">
    <table class="table table-hover">
        <tbody>


    <%
        List Art= (List)request.getAttribute("data");
 for (int i = 0; i<Art.size(); i ++){

    String StrTea = new String();
%>
<tr>
<%List TeaArt =(List) Art.get(i);
for (int i1 = 0;i1<TeaArt.size();i1++){
if (i1<=0){
%>
    <td width="119" style="display:none;"><%=TeaArt.get(i1)%></td>
    <%
}
    else { if(i1==2) {
%>
        <td width="119"><%=TeaArt.get(i1)%></td>
<%}
else {
    if (i1==3){
        StrTea = (String) TeaArt.get(i1);
    }
    else {
        StrTea = StrTea +',' + TeaArt.get(i1);
    }
}
}
}
%>
    <td width="119"><%=StrTea%></td>
    <%

        }
%>
</tr>


        </tbody>
    </table>
</div>
<script>
    $(function()	{
        $('tr').click(function(){
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
