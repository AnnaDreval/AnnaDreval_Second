package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPage_HW4;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class SlidersCheckTest extends SelenideTestBase {

    private DatesPage_HW4 datesPage;

    @BeforeClass
    public void beforeClass() {
        datesPage = page(DatesPage_HW4.class);
    }

    @Test
    public void slidersCheckTest() {

        //1 Open test site by URL
        datesPage.openPage();

        //2 Assert Browser title
        datesPage.checkTitle();

        //3 Perform login
        datesPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name
        datesPage.checkUserName();

        //5 Open Service -> Dates Page
        datesPage.datesPage();
        datesPage.openPage();
        //6
        datesPage.setRange2();


    }
}
