package dao;

import exception.DAOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Status;
import model.User;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static util.Const.*;


@NoArgsConstructor(access = AccessLevel.PRIVATE)


public class UserDao {
    private static final UserDao INSTANCE = new UserDao();

    ///

/////////////////////////////////////////USERS
    public void DeleteUser(Integer integer){
        CheckOrdersEndDel(integer);
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1,integer );
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }
//проверка и удаление заказов при удалении пользователя
    public void CheckOrdersEndDel(Integer integer) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_ID_ORDERS_IN_USERID);
             PreparedStatement preparedStatement1=connection.prepareStatement(DEL_IN_BACKET_IDUSER);
             PreparedStatement preparedStatement2=connection.prepareStatement(DEL_IN_ORDER_IDORDER)){
            preparedStatement.setInt(1,integer );
            ResultSet resultSet = preparedStatement.executeQuery();
            //взяли все ордера если они есть на айди полльзователя
            List<Integer> idOrder=new ArrayList<>();
            while (resultSet.next()){
                idOrder.add(resultSet.getInt(1));
            }
            for (Integer integer1 : idOrder) {
                preparedStatement2.setInt(1,integer1 );
                preparedStatement2.executeUpdate();
            }
            preparedStatement1.setInt(1,integer );
            preparedStatement1.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public User CreateUser(User user){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER,RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getMail());
            preparedStatement.setInt(3,Status.getIntStatus(user.getStatus()) );
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }
        return user;
    }
    ///+++
    public List<User> ReadUser (){
        List<User>users=new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(READ_USER);
            while (resultSet.next()) {

                users.add(User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .mail(resultSet.getString(3))
                        .status(Status.getByName(resultSet.getString("status")))
                        .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
       return users;

    }
    public User SearchUser(User user ){
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement=connection.prepareStatement(USER_Search)) {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getMail());
            preparedStatement.setInt(3,Status.getIntStatus(user.getStatus()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return user;

    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
