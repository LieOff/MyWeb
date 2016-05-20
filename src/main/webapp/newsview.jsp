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
    <div class="row">
        <div class="col-md-offset-2 col-md-8">

            <div class="panel panel-default">

                <div class="panel-body">
                    <div class="row">
                        <form class="form-horizontal" action="news" method="post">
                            <fieldset>
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-6 control-label" for="description">Названия</label>
                                    <div class="col-md-10">
                                        <input id="description"
                                               name="description"
                                               type="text"
                                               placeholder="Названия"
                                               required class="form-control input-md"
                                               value="<c:out value="${news.header}"/>">
                                    </div>
                                </div>
                                <div class="col-md-10">
                                <c:out value="${news.text}" escapeXml="false"/>
                                </div>
                                    <input id="id" name="id" type="hidden" value="<c:out value="${news.id}"/>">
                                    <!-- Button -->

                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for=""></label>
                                        <div class="col-md-9">
                                            <button type="submit" name="postSubmit" id="postSubmit" class="btn btn-primary">Сохранить</button>
                                        </div>
                                    </div>

                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>