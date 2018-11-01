package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElements;
import pageObjects.hw4.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.hw4.CheckBoxes.WATER;
import static enums.hw4.CheckBoxes.WIND;
import static enums.hw4.DropDown.YELLOW;
import static enums.hw4.RadioButtons.SELEN;

public class InterfaceCheckTest extends SelenideTestBase {

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
        homePage.checkUserName();

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServiceSubcategory();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServiceLeftSection();

        //7 Open Service -> Different Elements
        differentElements.openDiffElem();

        //8 Check Different elements interface
        differentElements.checkDiffElemInterface();

        //9 Assert Right Section
        differentElements.checkRightSection();

        //10 Assert Left Section
        differentElements.checkLeftSection();

        //11 Select checkboxes
        differentElements.selectCheckbox(WATER, WIND);

        //12 Assert info-panel section
        differentElements.checkCheckboxInfo(WIND, WATER);

        //13 Select radio
        differentElements.selectRadio(SELEN);

        //14 Assert info-panel section
        differentElements.checkRadioInfo(SELEN);

        //15  Select in dropdown
        differentElements.selectDropDown(YELLOW);

        //16 Assert info-panel section
        differentElements.checkDropDown(YELLOW);

        //17 Unselect checkboxes
        differentElements.selectCheckbox(WATER, WIND);

        //18 Assert info-panel section
        differentElements.checkUnselect(WIND, WATER);
    }
}

