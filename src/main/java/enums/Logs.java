package enums;

public enum Logs {
    WIND_TRUE("Wind: condition changed to true"),
    WIND_FALSE("Wind: condition changed to false"),
    WATER_TRUE("Water: condition changed to true"),
    WATER_FALSE("Water: condition changed to false"),
    SELEN_TRUE("metal: value changed to Selen"),
    YELLOW_TRUE("Colors: value changed to Yellow");

    public String status;

    Logs(String status) {
        this.status = status;
    }
}
