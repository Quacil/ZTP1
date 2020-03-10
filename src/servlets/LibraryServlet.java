package servlets;

import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/library")
public class LibraryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add": {
                List<Book> library = (List<Book>) getServletContext().getAttribute("library");
                String author = request.getParameter("author");
                String title = request.getParameter("title");
                String dateString = request.getParameter("publishedOn");
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    library.add(new Book(title, author, date, UUID.randomUUID()));
                } catch (ParseException e) {
                    response.sendError(400);
                    return;
                }

                break;
            }
            case "delete": {
                List<Book> library = (List<Book>) getServletContext().getAttribute("library");
                String idString = request.getParameter("id");
                if (idString == null) {
                    response.sendError(400);
                    return;
                }
                UUID bookId = UUID.fromString(idString);
                library.removeIf(p -> p.getId().equals(bookId));
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }
        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
