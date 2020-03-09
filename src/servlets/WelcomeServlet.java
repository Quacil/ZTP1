package servlets;

import models.User;
import models.UserRole;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class WelcomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) getServletContext().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/login").forward(req, resp);
        } else if (user.getUserRole().equals(UserRole.Admin)) {
            req.getRequestDispatcher("/admin").forward(req, resp);
        } else {
            req.getRequestDispatcher("/dashboard").forward(req, resp);
        }
    }
}
