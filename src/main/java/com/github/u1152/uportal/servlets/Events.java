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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author Aleksandr
 */
@WebServlet("/events")
public class Events extends HttpServlet {
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String ADD_ACTION = "add";
    private static final String ACTION = "action";
    private static final String AUTHORS = "/events.jsp";
    private static final String AUTHOR = "/event.jsp";

    private AuthorDao authorDao;
    private EventDao eventDao;

    public Events() {
        authorDao = new AuthorDaoExampleImpl();
        eventDao = new EventDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("event", authorDao.getAll());
        if (session.getAttribute("userInfo") != null) {
            Author AutIn = authorDao.getById((Integer) session.getAttribute("userInfo"));
            req.setAttribute("AutIN",true);
            req.setAttribute("userin", AutIn);
        }else{req.setAttribute("AutIN",false);}
        RequestDispatcher view = req.getRequestDispatcher(AUTHORS);
        view.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("INDOPOST");
        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Event event = new Event();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String stringId = request.getParameter("eventid");

        try {
            Date dateStart = format.parse(request.getParameter("start_date"));
            Date dateEnd = format.parse(request.getParameter("end_date"));
            event.setStart(dateStart);
            event.setEnd(dateEnd);
            System.out.print("WEHERE");
            System.out.print(dateStart);
            event.setTitle(request.getParameter("nameEvent"));
            if (stringId == null || stringId.isEmpty()) {
                eventDao.add(event);
            }else {
                String act = request.getParameter("act");
                if (act == null) {
                    //no button has been selected
                } else if (act.equals("delete")) {
                    event.setId(Integer.valueOf(stringId));
                    eventDao.delete(event);
                } else if (act.equals("update")) {
                    event.setId(Integer.valueOf(stringId));
                    eventDao.update(event);
                } else {
                    //someone has altered the HTML and sent a different value!
                }

            }
        } catch (ParseException e) {
            System.out.print("ErrorConvertData");
            e.printStackTrace();
        }

        //event.getDateEnd(request.getParameter("lastName"));
        //event.setName(request.getParameter("midName"));
        //String stringId = request.getParameter("id");
         //if (stringId == null || stringId.isEmpty()) {
         //   authorDao.add(author);
        //} else {
         //   Author oldauhor = authorDao.getById(Integer.valueOf(stringId));
         //   Set<Articals> OldArt = oldauhor.getArticles();
         //   author.setId(Integer.valueOf(stringId));
         //   author.setArticles(OldArt);
         //   authorDao.update(author);
        //}
        doGet(request, resp);
    }
}
