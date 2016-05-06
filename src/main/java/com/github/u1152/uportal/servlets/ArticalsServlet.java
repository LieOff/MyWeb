package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.ArticalsDao;
import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.localdaoimpl.ArticalsDaoExampleImpl;
import com.github.u1152.uportal.localdaoimpl.AuthorDaoExampleImpl;
import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.model.Author;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Илья on 20.04.2016.
 */
@WebServlet("/articals")
public class ArticalsServlet extends HttpServlet {
    private ArticalsDao articalsDao;
    private AuthorDao authorDao;
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String ADD_ACTION = "add";
    private static final String ACTION = "action";
    private static final String AUTHORS = "/articals.jsp";
    private static final String ARTICAL = "/artical.jsp";

    public ArticalsServlet() {
        articalsDao = new ArticalsDaoExampleImpl();
        authorDao = new AuthorDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);

        if (action != null) {
            if (action.equals(ADD_ACTION)) {
                List<Author> authorList =authorDao.getAll();
                req.setAttribute("authorsall", authorList);
                RequestDispatcher view = req.getRequestDispatcher(ARTICAL);
                view.forward(req, resp);
                return;
            }

            String id = req.getParameter("id");
            Articals artical = articalsDao.getById(Integer.valueOf(id));
            switch (action) {
                case EDIT_ACTION:
                    List<Author> authorList =authorDao.getAll();
                    List<Author> inauthor = new ArrayList<>(artical.getAuthors());
                    authorList.removeAll(inauthor);
                    req.setAttribute("artical", artical);
                    req.setAttribute("authorsall", authorList);
                    req.setAttribute("authorsin", inauthor);
                    RequestDispatcher view = req.getRequestDispatcher(ARTICAL);
                    view.forward(req, resp);
                    break;
                case DELETE_ACTION:
                    articalsDao.delete(artical);
                    break;
            }
        }
        req.setAttribute("articals", articalsDao.getAll());
        RequestDispatcher view = req.getRequestDispatcher(AUTHORS);
        view.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Articals articals = new Articals();
        articals.setTextArticals(request.getParameter("textArticals"));
        articals.setDescription(request.getParameter("description"));
        articals.setDateCreate(request.getParameter("dateCreate"));
        String arrayidauthor[] = request.getParameterValues("authors");
        Set<Author> newAuthor = new HashSet<>();
        for(String s: arrayidauthor) {
            newAuthor.add(authorDao.getById(Integer.valueOf(s)));
        }
        if (!newAuthor.isEmpty()) {
            articals.setAuthors(newAuthor);
        }else {}
        String stringId = request.getParameter("id");
        if (stringId == null || stringId.isEmpty()) {
            articalsDao.add(articals);
        } else {
            articals.setId(Integer.valueOf(stringId));
            articalsDao.update(articals);
        }
        doGet(request, resp);
    }

}
