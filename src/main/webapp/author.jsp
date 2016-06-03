<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<script type="text/javascript" src="http://yandex.st/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js"></script>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UPortal</title>
    <%@include file="WEB-INF/jspf/css.jspf" %>
</head>
<body>

<script type="text/javascript">
    $(":file").filestyle(
            {buttonText: "Загрузить...."}
    );
</script>
<%@include file="WEB-INF/jspf/top_bar.jspf" %>
<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8">

            <div class="panel panel-default">

                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4">
                            <img alt="placeholder"
                                 src="<c:out value="${author.image}"/>"
                            data-holder-rendered="true" style="height: 220px; width:220px   ; display: block;">
                        </div>
                        <form class="form-horizontal" action="authors" method="post" enctype="multipart/form-data">
                            <div class="col-md-6">
                                <label class="control-label">Аватар: </label>
                                <input type="file" name="file" id="file" class="filestyle" data-placeholder="Загрузите файл"/>
                            </div>
                                <div class="col-md-8">
                                <legend>
                                    <c:out value="${author.lastName}"/>
                                    <c:out value="${author.firstName}"/>
                                    <c:out value="${author.midName}"/>
                                </legend>

                                    <fieldset>
                                        <!-- Text input-->
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="lastName">Фамилия</label>
                                            <div class="col-md-9">
                                                <input id="lastName"
                                                       name="lastName"
                                                       type="text"
                                                       placeholder="фамилия"
                                                       required class="form-control input-md"
                                                       value="<c:out value="${author.lastName}"/>">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="firstName">Имя</label>
                                            <div class="col-md-9">
                                                <input id="firstName" name="firstName" type="text" placeholder="имя"
                                                       class="form-control input-md"
                                                       required value="<c:out value="${author.firstName}"/>">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="midName">Отчество</label>
                                            <div class="col-md-9">
                                                <input id="midName" name="midName" type="text" placeholder="Отчество"
                                                       class="form-control input-md"
                                                       value="<c:out value="${author.midName}"/>">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="eMail">e-mail</label>
                                            <div class="col-md-9">
                                                <input id="eMail" name="eMail" type="text" placeholder="e-mail"
                                                       required class="form-control input-md"
                                                value="<c:out value="${author.eMail}"/>">
                                            </div>
                                        </div>
                                        <input id="id" name="id" type="hidden" value="<c:out value="${author.id}"/>">
                                        <!-- Button -->
                                        <div class="form-group">
                                            <label class="col-md-3 control-label"></label>
                                            <div class="col-md-9">
                                                <button type="submit" class="btn btn-primary">Сохранить</button>
                                            </div>
                                        </div>


                                    </fieldset>

                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="WEB-INF/jspf/css.jspf" %>
</body>
</html>