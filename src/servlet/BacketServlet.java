package servlet;

import dao.ProductDao;
import model.Product;
import util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/backet")

public class BacketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object buyProduct = session.getAttribute("BuyProduct");
        String[] r= (String[]) buyProduct;
        Set<Product> products=new HashSet<>(ProductDao.getInstance().SearchProduct(r));
        req.setAttribute("product", products);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("BacketJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("submitOUT");
        System.out.println(result);

        if(result.equals("ОПЛАТИТЬ!")){
            getServletContext()
                    .getRequestDispatcher(JspHelper.getPath("OutJsp"))
                    .forward(req,resp);
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
        else {
            resp.sendRedirect("/backet");
        }
    }
}
