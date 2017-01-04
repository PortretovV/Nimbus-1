package dao;

import Entities.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO {
    Connection connection;

    public UsersDAO() {
    }

    public List<User> selectUsers() throws SQLException, NamingException {
        connection = Connection();
        String sqlSelect = "select developer.id_developer, developer.FirstName, developer.LastName, developer.MiddleName," +
                "developer.OfficialPosition, developer.id_supersystem, users.Login, users.Password" +
                " from developer, users where users.Login = developer.Login";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id_developer"));
            user.setFirstname(resultSet.getString("FirstName"));
            user.setLastname(resultSet.getString("LastName"));
            user.setMiddleName(resultSet.getString("MiddleName"));
            user.setOfficialPosition(resultSet.getString("OfficialPosition"));
            user.setId_supersystem(resultSet.getInt("id_supersystem"));
            user.setLogin(resultSet.getString("Login"));
            user.setPassword(resultSet.getString("Password"));
            users.add(user);
        }
        connection.close();
        return users;
    }

    public String deleteUser(String login) throws SQLException, NamingException {
        connection = Connection();
        String sqlDelete = "delete developer, users from developer left join users on developer.Login = users.Login" +
                " where developer.Login = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
            preparedStatement.setString(1, login);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return "Пользователь удалён";
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        return "Не удалось удалить пользователя";
    }
}
