package enums.hw6;

public enum DropDown {

    RED(0, "Red"),
    GREEN(1, "Green"),
    BLUE(2, "Blue"),
    YELLOW(3, "Yellow");

    public int num;
    public String title;

    DropDown(int num, String title) {
        this.num = num;
        this.title = title;
    }
}
