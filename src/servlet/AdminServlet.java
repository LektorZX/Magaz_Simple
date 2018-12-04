package servlet;

import DTO.RequestDtoUser;
import dao.UserDao;
import model.Status;
import model.User;
import service.ServisUser;
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

@WebServlet("/admin")

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("AdminJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("this");
        System.out.println(result);

        if(result.equals("ДОБАВИТЬ ТОВАР")){//+++
            resp.sendRedirect("/AdminNewProduct");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("ПОКАЗАТЬ ВСЕ ТОВАРЫ В БАЗЕ")){//+++
            resp.sendRedirect("/AdminSeeProduct");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("УДАЛИТЬ ТОВАР ИЗ БАЗЫ")){
            resp.sendRedirect("/delProduct");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("ПОКАЗАТЬ ЗАРЕГЕСТРИРОВАНЫХ ПОЛЬЗОВАТЕЛЕЙ")){
            resp.sendRedirect("/seeUser");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("УДАЛИТЬ ЗАПИСЬ О ПОЛЬЗОВАТЕЛЕ")){
            resp.sendRedirect("/delUser");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("ДОБАВИТЬ ЗАПИСЬ О ПОЛЬЗОВАТЕЛЕ")){
            resp.sendRedirect("/addUser");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("выход")){
            getServletContext()
                    .getRequestDispatcher(JspHelper.getPath("OutJsp"))//////нужно в магаз
                    .forward(req,resp);
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("назад")){
            getServletContext()
                    .getRequestDispatcher(JspHelper.getPath("RootJsp"))//////нужно в магаз
                    .forward(req,resp);
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
    }
}
