package servlet;

import DTO.RequestDtoUser;
import dao.ProductDao;
import dao.UserDao;
import model.Product;
import model.Status;
import model.User;
import service.RequestService;
import servlet.validator.RequestValidatorUser;
import util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/magaz")

public class Magaz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products=new ArrayList<>(ProductDao.getInstance().ReadProduct());
        req.setAttribute("product", products);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("MAGAZJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] rootids = req.getParameterValues("rootid");
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        //отдали список купленных товаров айди
        session.setAttribute("BuyProduct", rootids);

        boolean b = RequestService.getInstance().saveOrder(rootids, userId);
        if(b){
            resp.sendRedirect("/backet");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");

        }else {
            resp.sendRedirect("/magaz");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
    }

}
