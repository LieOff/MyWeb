<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>UPortal</title>
    <%@include file="WEB-INF/jspf/css.jspf" %>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.6.1/fullcalendar.min.css" type="text/css" rel="stylesheet" />
    <link href="bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" type="text/css" rel="stylesheet" />

</head>
<body>
<%@include file="WEB-INF/jspf/top_bar.jspf" %>
<div class="container">
    <div class="row">
        <div class="col-xs-12">

            <div id="bootstrapModalFullCalendar"></div>

        </div>
    </div>
</div>
<div id="fullCalModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span> <span class="sr-only">close</span></button>
                <h4 id="modalTitle" class="modal-title"></h4>
            </div>
            <div id="modalBody" class="modal-body"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <a class="btn btn-primary" id="eventUrl" target="_blank">Event Page</a>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.6.1/fullcalendar.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="bootstrap/js/lang-all.js"></script>
<script src="bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<div class="modal fade" id="modalev" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" align="center">

                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
            </div>

            <div id="div-forms">
                <form id="login-form" action="events" method="post">
                    <div class="modal-body">
                        <div id="div-login-msg">
                            <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                            <span id="text-login-msg">Введите названия события</span>
                        </div>
                        <input id="nameEvent" name="nameEvent"  class="form-control" placeholder = "Названия события">
                        <div id="div-login-msg1">
                            <div id="icon-login-msg1" class="glyphicon glyphicon-chevron-right"></div>
                            <span id="text-login-msg1">Введите дату начала и конца</span>
                        </div>
                        <div class='input-group date' id='datetimepicker2'>
                        <input id="start_date" name="start_date"  class="form-control" placeholder = "Дата начала события">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                        <div class='input-group date' id='datetimepicker3'>
                            <input id="end_date" name="end_date"  class="form-control" placeholder = "Дата конца события">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                        <input id="eventid" name="eventid" type="hidden">

                    </div>
                    <div class="modal-footer">
                        <div>
                            <button type="submit" id="SaveEv" name="act" class="btn btn-success" value="update">Сохранить</button>
                            <button type="submit" id="DeleteEv" name="act" class="btn btn-danger" value="delete">Удалить</button>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>

    $(document).ready(function() {
        $('#datetimepicker3').datetimepicker({
            dateFormat:'dd.mm.yyyy'
        }),
        $('#datetimepicker2').datetimepicker({
            dateFormat:'dd.mm.yyyy'
        }),
        $('#bootstrapModalFullCalendar').fullCalendar({
            nextDayThreshold: '00:00:00',
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            timezone:'local',
            displayEventEnd: {
                month: true,
                basicWeek: true,
                "default": true
            },
            monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь','Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
            monthNamesShort: ['Янв.','Фев.','Март','Апр.','Май','Июнь','Июль','Авг.','Сент.','Окт.','Ноя.','Дек.'],
            dayNames: ["Воскресенье","Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"],
            dayNamesShort: ["ВС","ПН","ВТ","СР","ЧТ","ПТ","СБ"],
            dayClick: function(date, allDay, jsEvent, view) {
                var newDate = moment(date).format("DD.MM.YYYY HH:MM");
                var endDayEv = moment(date,"DD.MM.YYYY HH:MM").add('hours',2);
                var newDateEnd = moment(endDayEv).format("DD.MM.YYYY HH:MM");
                document.getElementById('start_date').setAttribute('value',newDate);
                document.getElementById('end_date').setAttribute('value',newDateEnd);
                document.getElementById('eventid').setAttribute('value',"");
                document.getElementById('DeleteEv').style.display = "none";
                //alert(newDate);
                $('#modalev').modal();
            },
            eventClick:  function(event, jsEvent, view) {
                var StartDate = moment(event.start).format("DD.MM.YYYY HH:MM");
                var EndDate = moment(event.end).format("DD.MM.YYYY HH:MM");
                //$('#modalTitle').html(event.title);
                //$('#modalBody').html(event.id);
                document.getElementById('nameEvent').setAttribute('value',event.title);
                document.getElementById('start_date').setAttribute('value',StartDate);
                document.getElementById('end_date').setAttribute('value',EndDate);
                document.getElementById('eventid').setAttribute('value',event.id);
                document.getElementById('DeleteEv').style.display = "inline";
                $('#modalev').modal();
                return false;
            },
            events: "events/CalendarJsonServlet"
        });
    });
</script>

</body>
</html>