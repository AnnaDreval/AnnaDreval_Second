package enums.hw6;

public enum UserTable {

    PLAYERS {

        public String[] arr = new String[]{"Roman", "Sergey Ivan", "Vladzimir",
                "Helen Bennett", "Yoshi Tannamuri", "Giovanni Rovelli"};

        public String title(int i) {
            return arr[i];
        }
    },

    DESCRIPTION {
        public String[] arr = new String[]{"Lorem ipsum", "Lorem ipsum", "Lorem ipsum",
                "Lorem ipsum\nsome description", "Lorem ipsum\nsome description", "Lorem ipsum\nsome description"};

        public String title(int i) {
            return arr[i];
        }
    };

    public abstract String title(int i);
}