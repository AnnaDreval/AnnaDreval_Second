package enums.hw4;

public enum CheckBoxes {

    WATER(0, "Water"),
    EARTH(1, "Earth"),
    WIND(2, "Wind"),
    FIRE(3, "Fire");

    public int num;
    public String title;

    CheckBoxes(int num, String title) {
        this.num = num;
        this.title = title;
    }
}

