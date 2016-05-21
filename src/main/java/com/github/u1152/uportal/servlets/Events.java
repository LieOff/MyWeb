package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.localdaoimpl.AuthorDaoExampleImpl;
import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.model.Author;
import com.github.u1152.uportal.model.Event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

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

    public Events() {
        authorDao = new AuthorDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("authors", authorDao.getAll());
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
        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Event event = new Event();
        //event.setDateStart();
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
        //doGet(request, resp);
    }
}
