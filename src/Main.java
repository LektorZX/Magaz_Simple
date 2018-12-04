import com.sun.org.apache.xpath.internal.operations.Or;
import dao.BacketDao;
import dao.ProductDao;
import dao.UserDao;
import model.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        driver();
//        UserDao instanceUser = UserDao.getInstance();
//        instanceUser.ReadUser();//чтение зеров+++
//        instanceUser.DeleteUser(1);//удаление юзеров по id+++
        //добавление юзера+++
//        instanceUser.CreateUser(User.builder()
//        .name("Петя пробный2")
//        .mail("@sdfsdffgf")
//        .status(Status.getByName("client"))
//        .build());

//        ProductDao instance = ProductDao.getInstance();
//        instance.ReadProduct();//+++
//        instance.Create(Product.builder()//++++
//                .rootId("rootid")
//                .name("name")
//                .dimId("dimId")
//                .price((double) 10101)
//                .groupId("groupId")
//                .weight(101.10)
//                .postName("postName")
//                .remark("remark")
//                .build());
        // instance.DeleteProduct("2201537");//передать rootid+++

        BacketDao instance1 = BacketDao.getInstance();
        Basket basket = new Basket();
        basket.setIdUser(3);

        Set<Product> products = new HashSet<Product>();
        products.add(new Product("220003", "Конфеты Спартак вес", "КГ", "170108",
                "170108", "1.000000000000000e+000", 11.98, 135.71111));
        products.add(new Product("2200001", "Конфеты Свитязь", "КГ", "12970.0000", "170102", "1.000000000000000e+000", 453.53, 44.87));
        products.add(new Product("2202267", "Конфdfgеты Спартак вес", "КГ", "170108",
                "170108", "1.000000000000000e+000", 11.98, 135.7));
        products.add(new Product("2200011", "Конфjkеты Спартак вес", "КГ", "170108",
                "170108", "1.000000000000000e+000", 11.98, 135.7));
        Order order = new Order();
        order.setProducts(products);
        instance1.setCreateOrder(basket, order);//++++++++++
        instance1.setDeleteOrders(18);//+++++++++++++


    }


    private static void driver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
