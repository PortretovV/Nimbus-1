package Services;

import Entities.User;
import dao.UsersDAO;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    User user = new User();
    List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    @PostConstruct
    public void setData() {
        UsersDAO usersDAO = new UsersDAO();
        try {
            this.users = usersDAO.selectUsers();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String deleteUser(String login) {
        UsersDAO usersDAO = new UsersDAO();
        try {
            usersDAO.deleteUser(login);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "AllUsers";
    }
}
