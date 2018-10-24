package lesson4;

import base.SelenideTestBase;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.System.setProperty;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke Tests")
@Story("Home Page Testing")

public class SimpleTestSelenidePageObject extends SelenideTestBase {
    HomePageSelenide homePageSelenide;
    @BeforeClass
    public void beforeClass() {
         homePageSelenide = page(HomePageSelenide.class);
    }


    @Flaky
    @Test

    public void simpleTest() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //2 Navigate
        homePageSelenide.openPage();

        //3 Assert Title
        homePageSelenide.checkTitle();

        //4 Login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //5 Check main title
        homePageSelenide.checkMainText();


    }
}
