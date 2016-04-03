

package students.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //PrintWriter pw = resp.getWriter();
        //pw.println("<H1>Список преподователей:</H1>");

        Articles Arcs =new Articles();
        Teacher Teach = new Teacher();
        List<String> ArList = Arcs.GetAllArticals();
        List<List<String>> ArtTeach =new ArrayList<List<String>>();

        //List<String> Tea = new ArrayList<String>();
        for (int i = 0; i<ArList.size(); i= i + 4){
            List<String> ListAR = new ArrayList<String>();
            ListAR.add(ArList.get(i));
            ListAR.add(ArList.get(i+1));
            ListAR.add(ArList.get(i+2));
            List<Integer> TeachInArt = Arcs.GetTeacherByArtical(Integer.parseInt(ArList.get(i)));
            //System.out.print(TeachInArt.size());
            for (int i1 = 0; i1<TeachInArt.size(); i1++){
               // Tea.add(Integer.toString(i));
                ListAR.add(Teach.GetTeacherById(TeachInArt.get(i1)));
                //System.out.print(Teach.GetTeacherById(TeachInArt.get(i1)));
            }
            ArtTeach.add(ListAR);
        }

        //System.out.print(ArtTeach);
        req.setAttribute("data",ArtTeach);
        //req.setAttribute("listTeach",Tea);
        String page = "/WEB-INF/index.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);

        //PrintWriter pw = resp.getWriter();
        //pw.println("<H1>Список преподователей:</H1>");
        //Teacher T = new Teacher();
        //List<String> Teachers = T.getAllTeachers()  ;
        //for (int i =0; i<=Teachers.size();i++){
        //    pw.println(Teachers.get(i)+"</br>");
        //}

        }

}
