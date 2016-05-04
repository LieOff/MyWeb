package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.AuthorDao;
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
import java.util.Set;

/**
 * author Aleksandr
 */
@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String ADD_ACTION = "add";
    private static final String ACTION = "action";
    private static final String AUTHORS = "/frame.jsp";
    private static final String AUTHOR = "/author.jsp";

    private AuthorDao authorDao;

    public AuthorServlet() {
        authorDao = new AuthorDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);

        if (action != null) {
            if (action.equals(ADD_ACTION)) {
                RequestDispatcher view = req.getRequestDispatcher(AUTHOR);
                view.forward(req, resp);
                return;
            }

            String id = req.getParameter("id");
            Author author = authorDao.getById(Integer.valueOf(id));
            switch (action) {
                case EDIT_ACTION:
                    req.setAttribute("author", author);
                    RequestDispatcher view = req.getRequestDispatcher(AUTHOR);
                    view.forward(req, resp);
                    break;
                case DELETE_ACTION:
                    authorDao.delete(author);
                    break;
            }
        }
        req.setAttribute("authors", authorDao.getAll());
        RequestDispatcher view = req.getRequestDispatcher(AUTHORS);
        view.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Author oldauhor = authorDao.getById(Integer.valueOf(request.getParameter("id")));
        Set<Articals> OldArt = oldauhor.getArticles();
        Author author = new Author();
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
        author.setMidName(request.getParameter("midName"));
        author.seteMail(request.getParameter("eMail"));
        String stringId = request.getParameter("id");
        if (stringId == null || stringId.isEmpty()) {
            authorDao.add(author);
        } else {
            author.setId(Integer.valueOf(stringId));
            author.setArticles(OldArt);
            authorDao.update(author);
        }
        doGet(request, resp);
    }
}
