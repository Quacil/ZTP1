package filters;

import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "UserFilter", servletNames = {"DashboardServlet"}, urlPatterns = {"/dashboard"})
public class UserFilter implements Filter {
    private ServletContext context;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        User user = (User) context.getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/login").forward(req, resp);
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }
}
