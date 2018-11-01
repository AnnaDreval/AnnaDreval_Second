package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPage;
import pageObjects.hw4.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class SlidersCheckTest extends SelenideTestBase {

    private HomePage homePage;
    private pageObjects.hw4.DatesPage datesPage;


    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPage = page(pageObjects.hw4.DatesPage.class);
    }

    @Test
    public void slidersCheckTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name
        homePage.checkUserName();

        //5 Open Service -> Dates Page
        datesPage.datesPage();

        //6 Setting Range sliders
        datesPage.setSliders(0, 100);

        //7 Assert sliders
        datesPage.checkSliders();

        //8 Setting Range sliders
        datesPage.setSliders(0, 0);

        //9 Assert sliders
        datesPage.checkSliders();

        //10 Setting Range sliders
        datesPage.setSliders(100, 100);

        //11 Assert sliders
        datesPage.checkSliders();

        //12 Setting Range sliders
        datesPage.setSliders(30, 70);

        //13 Assert sliders
        datesPage.checkSliders();

    }
}
