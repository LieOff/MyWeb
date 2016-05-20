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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * author Aleksandr
 */
@WebServlet("/autific")
public class Autific extends HttpServlet {
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String ADD_ACTION = "add";
    private static final String ACTION = "action";
    private static final String AUTHORS = "/authors";
    private static final String AUTHOR = "/event.jsp";

    private AuthorDao authorDao;

    public Autific() {
        authorDao = new AuthorDaoExampleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //Integer IdAutIn = (Integer) session.getAttribute("userInfo");
        String login = req.getParameter("login_username");
        String password = req.getParameter("login_password");
        List<Author> AutInList = authorDao.getByLogin(login);
        System.out.print("получили");
        System.out.print(AutInList);
        System.out.print(login);
        if (AutInList.size()>0) {
            System.out.print("Зашли в цикл");
            Author AutIn = AutInList.get(0);
            System.out.print(AutIn.getPassword());
            System.out.print(password);
            if (AutIn.getPassword().equals(password)) {
                System.out.print("в ифе");
                session.setAttribute("userInfo", AutIn.getId());
                System.out.print("установили");
            }
        }
        resp.sendRedirect(req.getContextPath() + AUTHORS);
        return;

    }

}
