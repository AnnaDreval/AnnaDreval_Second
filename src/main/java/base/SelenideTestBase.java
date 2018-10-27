package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class SelenideTestBase {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}
