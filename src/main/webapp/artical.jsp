<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/bootstrap-multiselect/css/bootstrap.css" />
<script src="bootstrap-multiselect/js/chosen.jquery.js"></script>
<script src="bootstrap-multiselect/js/jquery.min.js"></script>
<script>
    $(function() {
        $('.chosen-select').chosen();
        $('.chosen-select-deselect').chosen({ allow_single_deselect: true });
    });
</script>

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
                            <form class="form-horizontal" action="articals" method="post">
                                <fieldset>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-6 control-label" for="description">Названия</label>
                                        <div class="col-md-12">
                                            <input id="description"
                                                   name="description"
                                                   type="text"
                                                   placeholder="Названия"
                                                   required class="form-control input-md"
                                                   value="<c:out value="${artical.description}"/>">
                                        </div>
                                    </div>
                                    <div class="col-md-8">

                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="textArticals">Краткое описания</label>
                                        <div class="col-md-9">
                                            <textarea class="form-control" rows="5" id="textArticals" name="textArticals"><c:out value="${artical.textArticals}"/></textarea>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="dateCreate">Дата создания</label>
                                        <div class="col-md-9">
                                            <input id="dateCreate" name="dateCreate" type="text" placeholder="Дата создания"
                                                   class="form-control input-md"
                                                   value="<c:out value="${artical.dateCreate}"/>">
                                        </div>
                                    </div>
                                            <div class="row">
                                                <div class="col-lg-3">
                                                    <select data-placeholder="Choose a Country" class="chosen-select" multiple tabindex="4">
                                                        <option value=""></option>
                                                        <option value="United States">United States</option>
                                                        <option value="United Kingdom">United Kingdom</option>
                                                        <option value="Afghanistan">Afghanistan</option>
                                                        <option value="Albania">Albania</option>
                                                        <option value="Algeria">Algeria</option>
                                                        <option value="American Samoa">American Samoa</option>
                                                        <option value="Andorra">Andorra</option>
                                                        <option value="Angola">Angola</option>
                                                        <option value="Anguilla">Anguilla</option>
                                                        <option value="Antarctica">Antarctica</option>
                                                        <option value="Antigua and Barbuda">Antigua and Barbuda</option>
                                                    </select>
                                                </div>
                                            </div>
                                    <input id="id" name="id" type="hidden" value="<c:out value="${artical.id}"/>">
                                    <!-- Button -->
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for=""></label>
                                        <div class="col-md-9">
                                            <button type="submit" class="btn btn-primary">Сохранить</button>
                                        </div>
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