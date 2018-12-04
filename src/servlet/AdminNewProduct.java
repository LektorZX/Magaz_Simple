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
@WebServlet("/AdminNewProduct")

public class AdminNewProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("AdminNewProductJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("flag");
        if(result.equals("Внести в базу")){//вытянули параметры и отдали в дао//++++++
            ProductDao.getInstance().Create(Product.builder()
                    .rootId(req.getParameter("RootId"))
                    .remark(req.getParameter("Remark"))
                    .postName(req.getParameter("PostName"))
                    .weight(Double.valueOf(req.getParameter("Weight")))
                    .groupId(req.getParameter("GroupId"))
                    .price(Double.valueOf(req.getParameter("Price")))
                    .dimId(req.getParameter("Dimid"))
                    .name(req.getParameter("Name"))
                    .build());
            resp.sendRedirect("/admin");
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
