package servlet;

import DTO.RequestDtoUser;
import dao.UserDao;
import model.Status;
import model.User;
import service.RequestService;
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

@WebServlet ("/enter")
public class EnterUserServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("EnterJsp"))
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
            //проверить есть ли юзер взять айди
            User user1=ServisUser.getInstance().Direct(requestDto);
            if(user1.getId()!=null){
                //////////////////////////отправить айди в сессию!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                HttpSession session = req.getSession();
                session.setAttribute("userId", user1.getId());
                List<User> users = UserDao.getInstance().ReadUser();
                for (User user : users) {
                    String name=user.getName();
                    String mail=user.getMail();

                    Integer id=user.getId();///////////////////////////////////////////////////////
                    int status =Status.getIntStatus(user.getStatus());
                    if(name.equals(requestDto.getName())&&mail.equals(requestDto.getMail())&&status==1){
                        resp.sendRedirect("/magaz");
                        resp.setContentType("text/html;charset=UTF-8");
                        resp.setCharacterEncoding("UTF-8");
                    }
                    if(name.equals(requestDto.getName())&&mail.equals(requestDto.getMail())&&status==2) {
                        resp.sendRedirect("/admin");
                        resp.setContentType("text/html;charset=UTF-8");
                        resp.setCharacterEncoding("UTF-8");
                    }
                }

            } else {
                resp.sendRedirect("/enter");
            }

            }



    }
}
