package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.ArticalsDao;
import com.github.u1152.uportal.dao.ArticalsPropDao;
import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.dao.NewsDao;
import com.github.u1152.uportal.localdaoimpl.ArticalsDaoExampleImpl;
import com.github.u1152.uportal.localdaoimpl.ArticalsPropDaoExampleImpl;
import com.github.u1152.uportal.localdaoimpl.AuthorDaoExampleImpl;
import com.github.u1152.uportal.localdaoimpl.NewsDaoExampleImpl;
import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.model.ArticalsProp;
import com.github.u1152.uportal.model.Author;
import com.github.u1152.uportal.model.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Илья on 20.04.2016.
 */
@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    //private ArticalsDao articalsDao;
    private AuthorDao authorDao;
    private NewsDao newsDao;
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String ADD_ACTION = "add";
    private static final String VIEW_ACTION = "view";
    private static final String ACTION = "action";
    private static final String AUTHORS = "/news.jsp";
    private static final String ARTICAL = "/newso.jsp";
    private static final String NewsView = "/newsview.jsp";

    public NewsServlet() {
        //articalsDao = new ArticalsDaoExampleImpl();
        authorDao = new AuthorDaoExampleImpl();
        newsDao = new NewsDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        HttpSession session = req.getSession();
        req.setAttribute("authors", authorDao.getAll());
        if (session.getAttribute("userInfo") != null) {
            Author AutIn = authorDao.getById((Integer) session.getAttribute("userInfo"));
            req.setAttribute("AutIN",true);
            req.setAttribute("userin", AutIn);
        }else{req.setAttribute("AutIN",false);}
        if (action != null) {
            if (action.equals(ADD_ACTION)) {
                //List<Author> authorList =authorDao.getAll();
                //req.setAttribute("authorsall", authorList);
                RequestDispatcher view = req.getRequestDispatcher(ARTICAL);
                view.forward(req, resp);
                return;
            }

            String id = req.getParameter("id");

            News news = newsDao.getById(Integer.valueOf(id));
            switch (action) {
                case EDIT_ACTION:

                    //List<Author> authorList =authorDao.getAll();
                   // List<Author> authorList =authorDao.getAll();
                   // List<Author> inauthor = new ArrayList<>(artical.getAuthors());
                   // authorList.removeAll(inauthor);
                    //List<ArticalsProp> articalsProps = articalsPropDao.getAllPopDesc();
                    //List<ArticalsProp> propList = articalsPropDao.getAllValue("Вид публикации");
                    //List<ArticalsProp> inprop = new ArrayList<>(artical.getArticalsProps());
                    //propList.removeAll(inprop);
                    //req.setAttribute("artical", artical);
                    //req.setAttribute("authorsall", authorList);
                    //req.setAttribute("authorsin", inauthor);
                    //req.setAttribute("AllDescsValue", propList);
                    //req.setAttribute("propin", inprop);
                    req.setAttribute("news",news);
                    //req.setAttribute("authorsall", authorList);
                    RequestDispatcher view = req.getRequestDispatcher(ARTICAL);
                    view.forward(req, resp);
                    return;
                case VIEW_ACTION:
                    req.setAttribute("news",news);
                    RequestDispatcher views = req.getRequestDispatcher(NewsView);
                    views.forward(req, resp);
                    return;
                case DELETE_ACTION:
                    newsDao.delete(news);
                    break;
            }
        }
        req.setAttribute("news", newsDao.getAll());
        RequestDispatcher view = req.getRequestDispatcher(AUTHORS);
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");



        String stringId = request.getParameter("id");
        if (stringId == null || stringId.isEmpty()) {
            News news = new News();
            //news.setDateCreate(\);
            news.setHeader(request.getParameter("description"));
            news.setText(request.getParameter("body"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            news.setDateCreate(dateFormat.format(date));
            newsDao.add(news);
        } else {
            News news = newsDao.getById(Integer.valueOf(stringId));
            //news.setDateCreate(\);
            news.setHeader(request.getParameter("description"));
            news.setText(request.getParameter("body"));
            //news.setId(Integer.valueOf(stringId));
            newsDao.update(news);
        }
        doGet(request, resp);
    }



}
