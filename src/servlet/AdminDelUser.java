package servlet;
import dao.ProductDao;
import dao.UserDao;
import model.Product;
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

@WebServlet("/delUser")

public class AdminDelUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<User> users=new ArrayList<>(UserDao.getInstance().ReadUser());
        req.setAttribute("users", users);
        getServletContext()
                .getRequestDispatcher(JspHelper.getPath("AdminDelUserJsp"))
                .forward(req,resp);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String result=req.getParameter("flag");
        if(result.equals("Удалить из базы")){//вытянули параметры и отдали в дао//++++++
            String result1=req.getParameter("UserId");
            UserDao.getInstance().DeleteUser(Integer.valueOf(result1));
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
