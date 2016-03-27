

package students.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();

        pw.println("<H1>Список преподователей:</H1>");
        Teacher T = new Teacher();
        List<String> Teachers = T.getAllTeachers()  ;
        for (int i =0; i<=Teachers.size();i++){
            pw.println(Teachers.get(i)+"</br>");
        }

        }

}
