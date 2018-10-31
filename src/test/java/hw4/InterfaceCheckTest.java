package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServicePage_HW4;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxes.WATER;
import static enums.CheckBoxes.WIND;
import static enums.DropDown.YELLOW;
import static enums.Logs.*;
import static enums.RadioButtons.SELEN;
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
        servicepage.login(PITER_CHAILOVSKII);

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
        servicepage.selectCheckbox(WATER, WIND);

        //12 Assert info-panel section
        servicepage.checkCheckboxInfo(WATER_TRUE, WIND_TRUE);

        //13 Select radio
        servicepage.selectRadio(SELEN);

        //14 Assert info-panel section
        servicepage.checkRadioInfo(SELEN_TRUE);

        //15  Select in dropdown
        servicepage.selectDropDown(YELLOW);

        //16 Assert info-panel section
        servicepage.checkDropDown(YELLOW_TRUE);

        //17 Unselect checkboxes
        servicepage.selectCheckbox(WATER, WIND);

        //18 Assert info-panel section
        servicepage.checkUnselect(WATER_FALSE, WIND_FALSE);

    }
}

