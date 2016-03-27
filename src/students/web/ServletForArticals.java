package students.web;

/**
 * Created by Илья on 27.03.2016.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForArticals extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw1 = resp.getWriter();
        pw1.println("<H1>Список статьей:</H1>");

        Articles Arcs =new Articles();
        List<String> ArList = Arcs.GetAllArticals();
        for (int i = 0; i<ArList.size(); i= i + 2){
            pw1.println("Загаловок:");
            pw1.println(ArList.get(i+1)+"</br>");
            pw1.println("Описания:");
            pw1.println(ArList.get(i)+"</br>");
        }

    }

}
