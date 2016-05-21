package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.dao.EventDao;
import com.github.u1152.uportal.localdaoimpl.AuthorDaoExampleImpl;
import com.github.u1152.uportal.localdaoimpl.EventDaoExampleImpl;
import com.github.u1152.uportal.model.Author;
import com.github.u1152.uportal.model.Event;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author Aleksandr
 */
@WebServlet("/events/CalendarJsonServlet")
public class ForGetEvents extends HttpServlet {


    private AuthorDao authorDao;
    private EventDao eventDao;

    public ForGetEvents() {
        authorDao = new AuthorDaoExampleImpl();
        eventDao = new EventDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> AllEvent = eventDao.getAll();
        System.out.print("EVENTSALL");
        System.out.print(AllEvent.get(0).getStart());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(new Gson().toJson(AllEvent));
    }


}