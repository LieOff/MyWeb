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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //Integer IdAutIn = (Integer) session.getAttribute("userInfo");
        String act = req.getParameter("act");
        if (act.equals("out")){
            session.removeAttribute("userInfo");
        }else {
            String login = req.getParameter("login_username");
            String password = req.getParameter("login_password");
            List<Author> AutInList = authorDao.getByLogin(login);

            if (AutInList.size() > 0) {
                Author AutIn = AutInList.get(0);
                System.out.print(AutIn.getPassword());
                System.out.print(password);
                if (AutIn.getPassword().equals(password)) {
                    session.setAttribute("userInfo", AutIn.getId());
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + AUTHORS);
        return;

    }

}
