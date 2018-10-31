package enums.hw6;

public enum Roles {

    ROLES {
        public String[] arr = new String[]{"Admin", "User", "Manager"};

        public String title(int i) {
            return arr[i];
        }
    };

    public abstract String title(int i);
}