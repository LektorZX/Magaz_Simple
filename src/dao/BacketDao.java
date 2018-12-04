package dao;

import exception.DAOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.*;
import util.ConnectionManager;
import java.sql.*;
import java.util.*;

import static util.Const.*;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BacketDao {
    private static final BacketDao INSTANCE = new BacketDao();

    public boolean setCreateOrder(Basket basket,Order order){// в ордере список товаров,в корзине id покупателя+++++++++++++++
        boolean result=false;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(CREATE_BUY);//создали запись в корзине юзер и автоматом id заказа
             PreparedStatement preparedStatement0=connection.prepareStatement(CREATE_BUY1);//находим заказ по юзеру
             PreparedStatement preparedStatement1=connection.prepareStatement(CREATE_ORDER)) {//создаем покупки по ордеру

            preparedStatement.setInt(1,basket.getIdUser());
            preparedStatement.executeUpdate();//появился заказ
            preparedStatement0.setInt(1, basket.getIdUser());
            ResultSet resultSet = preparedStatement0.executeQuery();//id_order
            while (resultSet.next()){//берем последний ордер в таблице(что бы не брало всегда с первой строки
                if(resultSet.isLast()){
                    basket.setIdOrder(resultSet.getInt("id_order"));//передали в обьект ордер
                    result=true;
                    break;
                }
            }
            System.out.println(basket);
            order.setIdOrder(basket.getIdOrder());
            List<Product> products=new ArrayList<>(order.getProducts());
            for (Product product : products) {
                System.out.println(product);
            }
            for (Product product : products) {
                preparedStatement1.setInt(1,order.getIdOrder());
                preparedStatement1.setString(2,product.getRootId());
                preparedStatement1.executeUpdate();
            }
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }
//delete заказ по id заказа
    public void setDeleteOrders(Integer integer){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_ORDERS);
             PreparedStatement preparedStatement1=connection.prepareStatement(DELETE_ORDERS1)) {
            preparedStatement.setInt(1,integer );
            preparedStatement.executeUpdate();
            preparedStatement1.setInt(1,integer );
            preparedStatement1.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }


///////////////////опд вопросом сущьность


    public void setReadOrdersByIdUser(Integer integer){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(READ_ORDERS_BY_ID_USER)) {
            preparedStatement.setInt(1,integer );
            ////создавать сущность или нет? для передачи выше
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void setReadOrdersByIdOrder(Integer integer){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(READ_ORDERS_BY_ID_ORDER)) {
            preparedStatement.setInt(1,integer );
            ////создавать сущность или нет? для передачи выше
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static BacketDao getInstance() {
        return INSTANCE;
    }
}
