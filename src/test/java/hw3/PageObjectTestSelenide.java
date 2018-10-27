package hw3;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide_HW3;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class PageObjectTestSelenide extends SelenideTestBase {

    private HomePageSelenide_HW3 homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide_HW3.class);
    }

    @Test
    public void indexPageContentTest() {

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
