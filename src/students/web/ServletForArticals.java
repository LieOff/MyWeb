package students.web;

/**
 * Created by Илья on 27.03.2016.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForArticals extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer item = Integer.parseInt(req.getParameter("item"));
        resp.setContentType("text/html;charset=utf-8");
        //PrintWriter pw1 = resp.getWriter();
        //pw1.println(item);
        Articles art = new Articles();
        Teacher Teach = new Teacher();
        List<String> Artis = art.GetArticalsById(item);
        List<Integer> Tea = art.GetTeacherByArtical(item);
        List<String> TeaSt = new ArrayList<String>();
        for (int i = 0; i<Tea.size();i++){
            TeaSt.add(Teach.GetTeacherById(Tea.get(i)));
        }
       // System.out.print(Tea);
        req.setAttribute("data",Artis);
        req.setAttribute("Tea",TeaSt);
        req.setAttribute("kodTea",Tea);
        //req.setAttribute("listTeach",Tea);
        String page = "/WEB-INF/artical.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);



    }

    }


