package enums.hw6;

public enum Logs {
    URL_HOME_PAGE("https://epam.github.io/JDI/index.html"),
    URL_USER_TABLE_PAGE("https://epam.github.io/JDI/user-table.html"),
    VIP("Vip: condition changed to true");

    public String status;

    Logs(String status) {
        this.status = status;
    }
}
