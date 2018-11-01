package enums.hw4;

public enum RadioButtons {

    GOLD(0, "Gold"),
    SILVER(1, "Silver"),
    BRONZE(2, "Bronze"),
    SELEN(3, "Selen");

    public int num;
    public String title;

    RadioButtons(int num, String title) {
        this.num = num;
        this.title = title;
    }
}
