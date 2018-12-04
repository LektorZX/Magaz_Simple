package servlet;

import dao.UserDao;
import model.User;
import util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/seeUser")

public class AdminSeeUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<User> users=new ArrayList<>(UserDao.getInstance().ReadUser());
        req.setAttribute("users", users);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("AdminSeeUserJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("flag");
        if(result.equals("НАЗАД")){
            resp.sendRedirect("/admin");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
    }

}
