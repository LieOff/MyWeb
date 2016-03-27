package students.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Илья on 27.03.2016.
 */
public class ArticTeach extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw1 = resp.getWriter();
        pw1.println("<H1>Список статьей по автору:</H1>");
        Teacher T =new Teacher();
        Articles A = new Articles();
        List<Integer> Artic = T.GetArtiCalsByTeacher(6);
        List<String> ArticRow;
        for (int i = 0; i<Artic.size(); i++){
            ArticRow = A.GetArticalsById(Artic.get(i));
            for (int i1 = 0; i<ArticRow.size(); i1= i1 + 2){
                pw1.println("Загаловок:");
                pw1.println(ArticRow.get(i1+1)+"</br>");
                pw1.println("Описания:");
                pw1.println(ArticRow.get(i1)+"</br>");
            }
         }


    }
}
