package servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = {"/magaz","/backet"})
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String s= String.valueOf(((HttpServletRequest) servletRequest).getSession().getAttribute("statusUser"));
        System.out.println(s);
        if(!s.equals("null")){
            int statusUserInt=(int) Integer.valueOf(s);
            if(statusUserInt==1){
                filterChain.doFilter(servletRequest,servletResponse );
            }
        }
        else {
            ((HttpServletResponse)servletResponse).sendRedirect("/enter");
        }
    }
}
