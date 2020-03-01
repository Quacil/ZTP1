package servlets;

import data.Credentials;
import models.User;
import models.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Credentials credentials;

    @Override
    public void init() throws ServletException {
        super.init();
        credentials = Credentials.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        if (login == null) {
            response.sendError(400);
            return;
        }
        User user = credentials.getUser(login);
        if (user == null) {
            response.sendRedirect("/loginFailed.html");
        } else if (user.getUserRole().equals(UserRole.Admin)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/admin");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/user");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}

