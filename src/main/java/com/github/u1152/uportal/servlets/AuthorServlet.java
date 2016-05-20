package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.AuthorDao;
import com.github.u1152.uportal.localdaoimpl.AuthorDaoExampleImpl;
import com.github.u1152.uportal.model.Articals;
import com.github.u1152.uportal.model.Author;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.validation.constraints.Null;
import java.io.*;
import java.util.Set;
import java.util.UUID;

/**
 * author Aleksandr
 */
@WebServlet("/authors")
@MultipartConfig(fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class AuthorServlet extends HttpServlet {
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String ADD_ACTION = "add";
    private static final String ACTION = "action";
    private static final String AUTHORS = "/frame.jsp";
    private static final String AUTHOR = "/author.jsp";
    private static final String SAVE_DIR = "img";
    private AuthorDao authorDao;

    public AuthorServlet() {
        authorDao = new AuthorDaoExampleImpl();
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
                    return;
                case DELETE_ACTION:
                    authorDao.delete(author);
                    break;
            }
        }
        RequestDispatcher view = req.getRequestDispatcher(AUTHORS);
        view.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String stringId = request.getParameter("id");
        Author author = new Author();
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + SAVE_DIR;
        String fileName = "";

        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
        author.setMidName(request.getParameter("midName"));
        author.seteMail(request.getParameter("eMail"));
         if (stringId == null || stringId.isEmpty()) {
             for (Part part : request.getParts()) {
                 fileName = extractFileName(part);
                 //System.out.print(savePath + File.separator + fileName);
                 part.write(savePath + File.separator + fileName);
                 break;
             }
             author.setImage(SAVE_DIR+File.separator + fileName);

            authorDao.add(author);
        } else {
            Author oldauhor = authorDao.getById(Integer.valueOf(stringId));
            Set<Articals> OldArt = oldauhor.getArticles();
            author.setId(Integer.valueOf(stringId));
            author.setArticles(OldArt);
            author.setLogin(oldauhor.getLogin());
             author.setPassword(oldauhor.getPassword());
             for (Part part : request.getParts()) {
                 fileName = extractFileName(part);
                 UUID uuid = UUID.randomUUID();
                 String extension = "";

                 int i = fileName.lastIndexOf('.');
                 if (i > 0) {
                     extension = fileName.substring(i+1);
                 }
                 fileName = ""+uuid+"."+extension;
                 System.out.print(oldauhor.getImage());
                 System.out.print(fileName);

                 if (oldauhor.getImage()==null || !oldauhor.getImage().equals(SAVE_DIR+File.separator + fileName) && !fileName.equals(""))
                 {
                     part.write(savePath + File.separator + fileName);
                     author.setImage(SAVE_DIR+File.separator + fileName);
                 }else
                 {author.setImage(oldauhor.getImage());}
                 break;
             }

             authorDao.update(author);
        }
        doGet(request, resp);
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
