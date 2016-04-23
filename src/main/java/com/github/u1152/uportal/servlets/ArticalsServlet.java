package com.github.u1152.uportal.servlets;

import com.github.u1152.uportal.dao.ArticalsDao;
import com.github.u1152.uportal.localdaoimpl.ArticalsDaoExampleImpl;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Илья on 20.04.2016.
 */
@WebServlet("/articals")
public class ArticalsServlet {
    private ArticalsDao authorDao;

    public ArticalsServlet() {
        authorDao = new ArticalsDaoExampleImpl();
    }

}
