package servlet;

import DTO.RequestDtoUser;
import dao.UserDao;
import model.Status;
import model.User;
import servlet.validator.RequestValidatorUser;
import util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/root")

public class RootJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("RootJsp"))
                .forward(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result = req.getParameter("this");
        System.out.println(result);
        HttpSession session = req.getSession();
        session.setAttribute("statusUser", "null");
        if (result.equals("войти")) {
            resp.sendRedirect("/enter");
        }
        if (result.equals("регистрация")) {
            getServletContext()
                    .getRequestDispatcher(JspHelper.getPath("request-save"))
                    .forward(req, resp);
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
    }
}
