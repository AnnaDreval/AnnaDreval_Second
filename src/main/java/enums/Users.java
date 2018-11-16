package enums;

public enum Users {

    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    public String login;
    public String password;
    public String name;

    Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public static Users getUser(String username) {
        for (Users user : Users.values()) {
            if (username.equals(user.name)) {
                return user;
            }
        }
        return null;
    }
}
