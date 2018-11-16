package enums;

public enum  HeaderMenuCategories {
    OPTIONS {

        public String[] arr = new String[]{"Home", "Contact form", "Service", "Metals & Colors"};

        public String title(int i) {
            return arr[i];
        }
    };

    public abstract String title(int i);

}
