package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String liczba1String = request.getParameter("l1");
        String liczba2String = request.getParameter("l2");
        if (liczba1String == null || liczba2String == null) {
            response.sendError(400);
            return;
        }
        Double liczba1 = Double.parseDouble(liczba1String);
        Double liczba2 = Double.parseDouble(liczba2String);
        response.setStatus(200);
        PrintWriter writer = response.getWriter();
        writer.printf("Wynik: %s%n", liczba1 * liczba2);
        writer.close();
    }
}
