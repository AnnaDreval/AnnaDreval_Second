package hw5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElements;
import pageObjects.hw4.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.hw4.DiffElemEnum.*;

@Feature("Smoke tests")
@Story("Different elements Interface Check tests")
@Listeners(AllureAttachmentListener.class)
public class InterfaceCheckTest_Failed extends SelenideTestBase {

    private DifferentElements differentElements;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        differentElements = page(DifferentElements.class);
        homePage = page(HomePage.class);
    }

    @Test
    public void interfaceCheckTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name
        homePage.checkUserName(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServiceSubcategory();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServiceLeftSection();

        //7 Open Service -> Different Elements
        homePage.openDiffElem();

        //8 Check Different elements interface
        differentElements.checkDiffElemInterface();

        //9 Assert Right Section
        differentElements.checkRightSection();

        //10 Assert Left Section
        differentElements.checkLeftSection();

        //11 Select checkboxes
        differentElements.selectCheckbox(WATER, WIND);

        //13 Select radio
        differentElements.selectRadio(SELEN);

        //15  Select in dropdown
        differentElements.selectDropDown(YELLOW);

        //16 Assert info-panel section
        differentElements.checkLogs(0, 4, true, FIRE, WIND, YELLOW, SELEN);

        //17 Unselect checkboxes
        differentElements.unSelectCheckbox(WATER, WIND);

        //18 Assert info-panel section
        differentElements.checkLogs(4, 6, true, WATER, WIND);
    }
}

