<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-multiselect/css/bootstrap.css" />
    <script language="JavaScript" type="text/JavaScript" src="<c:url value="bootstrap-multiselect/js/jquery.min.js" />"></script>
    <script language="JavaScript" type="text/JavaScript" src="<c:url value="bootstrap-multiselect/js/chosen.jquery.js" />"></script>
    <script src="bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js"></script>

    <title>UPortal</title>
</head>
<body>
<%@include file="WEB-INF/jspf/top_bar.jspf" %>

<script language="JavaScript" type="text/JavaScript">
    $(":file").filestyle(
            {buttonText: "Загрузить...."}
    );
    $(function() {
        $('.chosen-select').chosen();
        $('.chosen-select-deselect').chosen({ allow_single_deselect: true });
    });
</script>

<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8">

            <div class="panel panel-default">

                <div class="panel-body">
                    <div class="row">
                        <form class="form-horizontal" action="articals" method="post" enctype="multipart/form-data">
                            <fieldset>
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-6 control-label" for="description">Названия</label>
                                    <div class="col-md-9" style="float: none;
                                                margin: 0 auto;">
                                        <input id="description"
                                               name="description"
                                               type="text"
                                               placeholder="Названия"
                                               required class="form-control input-md"
                                               value="<c:out value="${artical.description}"/>">
                                    </div>
                                </div>


                                    <div class="form-group" style="margin-right: 5%">
                                        <label class="col-md-3 control-label" for="textArticals">Краткое описания</label>
                                        <div class="col-md-9">
                                            <textarea class="form-control" rows="5" id="textArticals" name="textArticals" style="resize: vertical; width: 100%"><c:out value="${artical.textArticals}"/></textarea>
                                        </div>
                                    </div>


                                    <div class="form-group" style="margin-right: 5%">
                                        <label class="col-md-3 control-label" for="dateCreate">Дата создания</label>
                                        <div class="col-md-9">
                                            <input id="dateCreate" name="dateCreate" type="text" placeholder="Дата создания"
                                                   class="form-control input-md"
                                                   value="<c:out value="${artical.dateCreate}"/>">
                                        </div>
                                    </div>
                                    <div class="form-group" style="margin-right: 5%">
                                        <label class="col-md-3 control-label">Авторы</label>
                                            <div class="col-md-9">
                                                <select data-placeholder="Выберите авторов" id="authorssel" name="authorssel" class="chosen-select" multiple tabindex="4">
                                                    <option value=""></option>
                                                        <c:forEach items="${authorsall}" var="authorl">
                                                            <option value="<c:out value="${authorl.id}"/>"><c:out value="${authorl.lastName}"/></option>
                                                        </c:forEach>

                                                    <c:forEach items="${authorsin}" var="authorin">
                                                        <option value="<c:out value="${authorin.id}"/>" selected><c:out value="${authorin.lastName}"/></option>
                                                    </c:forEach>
                                                 </select>
                                            </div>
                                    </div>
                                    <c:forEach items="${AllDescs}" var="alldesc">
                                        <div class="form-group" style="margin-right: 5%">
                                            <label class="col-md-3 control-label"><c:out value="${alldesc.description}"/></label>
                                            <div class="col-md-9">
                                                <select data-placeholder="<c:out value="${alldesc.description}"/>" id="prop<c:out value="${alldesc.id}"/>" name="prop<c:out value="${alldesc.id}"/>" class="chosen-select" tabindex="4">
                                                    <option value=""></option>
                                                    <c:forEach items="${propin}" var="propins">
                                                        <option value="<c:out value="${propins.id}"/>" selected><c:out value="${propins.valueOf}"/></option>
                                                    </c:forEach>
                                                    <c:forEach items="${AllDescsValue}" var="DescValue">
                                                        <option value="<c:out value="${DescValue.id}"/>"><c:out value="${DescValue.valueOf}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="form-group" style="margin-right: 5%">
                                    <div class="col-md-8">
                                        <label class="col-md-4 control-label">Приложение:  </label>
                                        <div class="col-md-15">
                                            <input type="file" name="file" id="file" class="filestyle" data-placeholder="Загрузите файл"/>
                                        </div>

                                    </div>
                                    </div>
                                    <br>
                                    <input id="id" name="id" type="hidden" value="<c:out value="${artical.id}"/>">
                                    <!-- Button -->
                                    <div class="form-group" style="margin-left: 5%">

                                        <div class="col-md-9">
                                            <button type="submit" class="btn btn-primary">Сохранить</button>
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