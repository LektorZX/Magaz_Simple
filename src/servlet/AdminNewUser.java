package servlet;

import DTO.RequestDtoUser;
import dao.ProductDao;
import service.RequestService;
import servlet.validator.RequestValidatorUser;
import util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")

public class AdminNewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("AdminNewUserJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("flag");

        if(result.equals("Добавить в базу")){
            RequestDtoUser requestDto = RequestDtoUser.builder()
                    .name(req.getParameter("name"))
                    .mail(req.getParameter("mail"))
                    .status(req.getParameter("status"))
                    .build();
            RequestValidatorUser isValid = new RequestValidatorUser();
            if (isValid.isValid(requestDto)) {
                RequestService.getInstance().save(requestDto);
                resp.sendRedirect("/admin");
            } else {
                resp.sendRedirect("/addUser");
            }
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        if(result.equals("Отмена")){
            resp.sendRedirect("/admin");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
    }

}
