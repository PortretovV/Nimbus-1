package Entities;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String middleName;
    private String officialPosition;
    private int id_supersystem;
    private String login;
    private String confirmLogin;
    private String password;


    public User(){
    }

    public User(int id, String firstname, String lastname, String middleName, String officialPosition,
                int id_supersystem, String login, String confirmLogin, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleName = middleName;
        this.officialPosition = officialPosition;
        this.id_supersystem = id_supersystem;
        this.login = login;
        this.confirmLogin = confirmLogin;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getOfficialPosition() {
        return officialPosition;
    }

    public void setOfficialPosition(String officialPosition) {
        this.officialPosition = officialPosition;
    }

    public int getId_supersystem() {
        return id_supersystem;
    }

    public void setId_supersystem(int id_supersystem) {
        this.id_supersystem = id_supersystem;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getConfirmLogin() {
        return confirmLogin;
    }

    public void setConfirmLogin(String confirmLogin) {
        this.confirmLogin = confirmLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
