package enums;

public enum ServiceMenuCategories {

    OPTIONS {

        public String[] arr = new String[]{"Support", "Dates", "Complex Table", "Simple Table",
                "User Table", "Table with pages", "Different Elements", "Performance"};

        public String title(int i) {
            return arr[i];
        }
    };

    public abstract String title(int i);

}
