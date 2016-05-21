<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>UPortal</title>
    <%@include file="WEB-INF/jspf/css.jspf" %>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.6.1/fullcalendar.min.css" type="text/css" rel="stylesheet" />

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
                            <span id="text-login-msg">Введите логин и пароль</span>
                        </div>
                        <input id="nameEvent" name="nameEvent"  class="form-control" placeholder = "Названия события">
                        <input id="start_date" name="start_date"  class="form-control" placeholder = "Дата начала события">
                        <input id="end_date" name="end_date"  class="form-control" placeholder = "Дата конца события">
                    </div>
                    <div class="modal-footer">
                        <div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Сохранить</button>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {

        $('#bootstrapModalFullCalendar').fullCalendar({
            nextDayThreshold: '00:00:00',
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            timezone:'local',
            monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь','Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
            monthNamesShort: ['Янв.','Фев.','Март','Апр.','Май','Июнь','Июль','Авг.','Сент.','Окт.','Ноя.','Дек.'],
            dayNames: ["Воскресенье","Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"],
            dayNamesShort: ["ВС","ПН","ВТ","СР","ЧТ","ПТ","СБ"],
            dayClick: function(date, allDay, jsEvent, view) {
                var newDate = moment(date).format("DD/MM/YYYY HH:MM:SS");
                document.getElementById('start_date').setAttribute('value',newDate);
                document.getElementById('end_date').setAttribute('value',newDate);
                //alert(newDate);
                $('#modalev').modal();
            },
            eventClick:  function(event, jsEvent, view) {
                $('#modalTitle').html(event.title);
                $('#modalBody').html(event.description);
                $('#fullCalModal').modal();
                return false;
            },
            events: "events/CalendarJsonServlet"
        });
    });
</script>

</body>
</html>