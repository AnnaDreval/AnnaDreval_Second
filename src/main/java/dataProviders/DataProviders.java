package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][] {
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider
    public Object[][] indexPageDataProvider() {
        return new Object[][] {
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n"
                        + "some external projects),\n" + "wish to get more…"}
        };
    }

}
