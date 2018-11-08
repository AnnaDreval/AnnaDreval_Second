package enums.hw4;

public enum SlidersLog {

    FROM_SLIDER("Range 2(From):"),
    TO_SLIDER("Range 2(To):"),
    END(" link clicked");

    public String status;

    SlidersLog(String status) {
        this.status = status;
    }
}

