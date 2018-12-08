package servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = {"/delProduct","/seeUser","/delUser","/AdminNewProduct","/admin","/addUser","/AdminSeeProduct"} )
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String s= String.valueOf(((HttpServletRequest) servletRequest).getSession().getAttribute("statusUser"));
        System.out.println(s);
        if(!s.equals("null")){
            int statusUserInt=(int) Integer.valueOf(s);
            if(statusUserInt==2){
                filterChain.doFilter(servletRequest,servletResponse );
            }
            if(statusUserInt==1){
                ((HttpServletResponse)servletResponse).sendRedirect("/enter");
            }
        }
        else {
            ((HttpServletResponse)servletResponse).sendRedirect("/enter");
        }

    }
}
