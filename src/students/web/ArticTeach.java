package students.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Илья on 27.03.2016.
 */
public class ArticTeach extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Integer item = Integer.parseInt(req.getParameter("Tea"));
        Teacher Tea = new Teacher();
        Articles Art = new Articles();
        String TeaStr = Tea.GetTeacherById(item);
        List<Integer> ListArt = Tea.GetArtiCalsByTeacher(item);
        List<List<String >> WWN = new ArrayList<List<String>>();
        for (int i = 0; i<ListArt.size(); i++){
        List<String> Artical = Art.GetArticalsById(ListArt.get(i));
        //  System.out.print(Artical);
        WWN.add(Artical);
        }
        req.setAttribute("WWN",WWN);
        req.setAttribute("TeaStr",TeaStr);
        String page = "/WEB-INF/Tea.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);


    }
}
