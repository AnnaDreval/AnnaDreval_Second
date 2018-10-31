package hw6.ex2;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw6.UserPage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.hw6.Logs.VIP;

public class InterfaceCheckTest extends SelenideTestBase {

    private UserPage userPage;

    @BeforeClass
    public void beforeClass() {
        userPage = page(UserPage.class);
    }

    @Test
    public void interfaceCheckTest() {

        //1 Open test site by URL
        userPage.openPage();

        //2 Perform login
        userPage.login(PITER_CHAILOVSKII);

        //3 Click on "Service" button in Header
        userPage.clickServiceButton();

        //4 Click on "User Page" button
        userPage.clickUserTableButton();

        //5 Assert Dropdowns number
        userPage.checkDropDownsNumber();

        //6 Assert User names
        userPage.checkUserNameNumber();

        //7 Assert Description images
        userPage.checkImageNumber();

        //8 Assert Description texts
        userPage.checkTextNumber();

        //9 Assert checkboxes
        userPage.checkCheckboxNumber();

        //10 Assert user table
        userPage.checkUserTable();

        //11 Select 'vip' checkbox for "Sergey Ivan"
        userPage.selectIvanVip();

        //12 1 log row has "Vip: condition changed to true" text in log section
        userPage.checklogs(VIP);

        //13 Click on dropdown for user Roman
        userPage.clickRomanDropDown();

        //14 Assert Roman dropdown list
        userPage.checkRomanOptions();

    }
}

