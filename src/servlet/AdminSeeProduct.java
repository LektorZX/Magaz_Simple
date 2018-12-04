package servlet;
        import dao.ProductDao;
        import model.Product;
        import util.JspHelper;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

@WebServlet("/AdminSeeProduct")

public class AdminSeeProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products=new ArrayList<>(ProductDao.getInstance().ReadProduct());
        req.setAttribute("product", products);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("AdminSeeProductJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("AdminSeeProduct1");
        System.out.println(result);
        if(result.equals("назад")){
            resp.sendRedirect("/admin");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
        }
    }

}
