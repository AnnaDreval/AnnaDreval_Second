package enums.hw4;

public enum DiffElemEnum {
    INPUT("Input"),
    OPTION("Option"),
    WATER("Water"),
    WIND("Wind"),
    SELEN("Selen"),
    YELLOW("Yellow"),
    METALL("metal"),
    COLOR("Colors"),
    URL_DIFFERENT_ELEMENTS_PAGE("https://epam.github.io/JDI/different-elements.html"),
    URL_DATES_PAGE("https://epam.github.io/JDI/dates.html");

    public String text;

    DiffElemEnum(String text) {
        this.text = text;
    }


}