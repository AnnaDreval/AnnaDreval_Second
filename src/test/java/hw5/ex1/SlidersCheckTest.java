package hw5.ex1;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DatesPage;
import pageObjects.hw4.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Dates page Interface Check tests")
@Listeners(AllureAttachmentListener.class)
public class SlidersCheckTest extends SelenideTestBase {

    private HomePage homePage;
    private DatesPage datesPage;


    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);
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
        homePage.checkUserName(PITER_CHAILOVSKII);

        //5 Open Service -> Dates Page
        homePage.openDatesPage();

        //6 Setting Range sliders
        datesPage.setSliders(0, 100);

        //7 Assert sliders
        datesPage.checkSliders(0, 100);

        //8 Setting Range sliders
        datesPage.setSliders(0, 0);

        //9 Assert sliders
        datesPage.checkSliders(0, 0);

        //10 Setting Range sliders
        datesPage.setSliders(100, 100);

        //11 Assert sliders
        datesPage.checkSliders(100, 100);

        //12 Setting Range sliders
        datesPage.setSliders(30, 70);

        //13 Assert sliders
        datesPage.checkSliders(30, 70);
    }
}
