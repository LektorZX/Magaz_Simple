package servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(servletNames = {"AdminDelProduct","AdminSeeUser","AdminDelUser",
        "AdminNewProduct","AdminServlet","AdminNewUser","AdminSeeProduct"})

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse );




    }
}
