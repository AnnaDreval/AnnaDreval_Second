package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServicePage_HW4;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class InterfaceCheckTest extends SelenideTestBase {

    private ServicePage_HW4 servicepage;

    @BeforeClass
    public void beforeClass() {
        servicepage = page(ServicePage_HW4.class);
    }

    @Test
    public void interfaceCheckTest() {

        //1 Open test site by URL
        servicepage.openPage();

        //2 Assert Browser title
        servicepage.checkTitle();

        //3 Perform login
        servicepage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name
        servicepage.checkUserName();

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicepage.checkServiceSubcategory();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicepage.checkServiceLeftSection();

        //7 Open Service -> Different Elements
        servicepage.openDiffElem();

        //8 Check Different elements interface
        servicepage.checkDiffElemInterface();

        //9 Assert Right Section
        servicepage.checkRightSection();

        //10 Assert Left Section
        servicepage.checkLeftSection();

        //11 Select checkboxes
        servicepage.selectCheckbox();

        //12 Assert info-panel section
        servicepage.checkCheckboxInfo();

        //13 Select radio
        servicepage.selectRadio();

        //14 Assert info-panel section
        servicepage.checkRadioInfo();

        //15  Select in dropdown
        servicepage.selectDropDown();

        //16 Assert info-panel section
        servicepage.checkDropDown();

        //17 Unselect checkboxes
        servicepage.selectCheckbox();

        //18 Assert info-panel section
        servicepage.checkUnselect();

    }
}

