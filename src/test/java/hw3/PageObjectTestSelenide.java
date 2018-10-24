package hw3;

import base.SelenideTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.HomePageSelenide;
import pageObjects.HomePageSelenide_HW3;

import java.util.List;

import static enums.Users.PITER_CHAILOVSKII;

import static com.codeborne.selenide.Selenide.page;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectTestSelenide extends SelenideTestBase {

    HomePageSelenide_HW3 homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide_HW3.class);
    }

    @Test
    public void indexPageContentTest() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Navigate
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name
        homePage.checkUserName();

        //6 Assert 4 items on the header section
        homePage.checkFourItems();

        //7 Assert 4 images on the Index Page
        homePage.checkFourImages();

        //8 Assert  4 texts on the Index Page under icons
        homePage.checkFourTexts();

        //9 Assert Мain header
        homePage.checkMainText();
        homePage.checkJdiTitle();

        //10 Assert iframe in the center of page
        homePage.checkIFrame();

        //11 Assert Epam logo in the left top conner of iframe
        homePage.checkLogo();

        //13 Assert a text of the sub header
        homePage.checkJdiGit();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJdiLink();

        //15 Assert Left Section
        homePage.checkLeftSection();

        //16 Assert Footer
        homePage.checkFooter();


    }
}
