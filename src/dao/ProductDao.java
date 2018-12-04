package dao;

import exception.DAOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Product;
import model.Status;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.Const.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDao {
    private static final ProductDao INSTANCE = new ProductDao();

    //ADMIN
    public void Create(Product product) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {
            preparedStatement.setString(1, product.getRootId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getDimId());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getGroupId());
            preparedStatement.setDouble(6, product.getWeight());
            preparedStatement.setString(7, product.getPostName());
            preparedStatement.setString(8, product.getRemark());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    public List<Product> ReadProduct(){
        List<Product>products=new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(READ_PRODUCT);
            while (resultSet.next()) {
                products.add(Product.builder()
                        .rootId(resultSet.getString("rootid"))
                        .name(resultSet.getString("name"))
                        .dimId(resultSet.getString("dimId"))
                        .price(resultSet.getDouble("price"))
                        .groupId(resultSet.getString("groupId"))
                        .weight(resultSet.getDouble("weight"))
                        .postName(resultSet.getString("postName"))
                        .remark(resultSet.getString("remark"))
                        .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
       return products;
    }

    public void DeleteProduct(String string){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setString(1,string );
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    public Set<Product> SearchProduct(String[] string){
        Set<Product>products=new HashSet<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_PRODUCT);) {
            for (String s : string) {
                preparedStatement.setString(1,s);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    products.add(Product.builder()
                            .rootId(resultSet.getString("rootid"))
                            .name(resultSet.getString("name"))
                            .dimId(resultSet.getString("dimId"))
                            .price(resultSet.getDouble("price"))
                            .groupId(resultSet.getString("groupId"))
                            .weight(resultSet.getDouble("weight"))
                            .postName(resultSet.getString("postName"))
                            .remark(resultSet.getString("remark"))
                            .build());
                }
              }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return products;

    }



    public static ProductDao getInstance() {
        return INSTANCE;
    }
}
