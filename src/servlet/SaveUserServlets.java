package servlet;

import DTO.RequestDtoUser;
import model.User;
import service.RequestService;
import util.JspHelper;
import servlet.validator.RequestValidatorUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/request-save")
public class SaveUserServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("request-save"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sre=req.getParameter("name");
        System.out.println(sre);
        RequestDtoUser requestDto = RequestDtoUser.builder()
                .name(req.getParameter("name"))
                .mail(req.getParameter("mail"))
                .status(req.getParameter("status"))
                .build();
        RequestValidatorUser isValid = new RequestValidatorUser();
        if (isValid.isValid(requestDto)) {
            RequestService.getInstance().save(requestDto);
            resp.sendRedirect("/enter");
        } else {
            resp.sendRedirect("/request-save");
        }
    }

}
