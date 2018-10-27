package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DatesPage_HW4 {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "[ui = 'label']")
    private SelenideElement userName;

    @FindBy(css = "[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(css = "[href = 'dates.html']")
    private SelenideElement datesPage;

    @FindBy(css = ".col-sm-5 > [style = 'left: 20%;']")
    private SelenideElement range2_Left;

    @FindBy(css = ".col-sm-5 > [style = 'left: 100%;']")
    private SelenideElement range2_Rigth;

    @FindBy(css = ".ui-slider-range ui-widget-header ui-corner-all > style")
    private List<SelenideElement> range2;

    //ui-slider-range ui-widget-header ui-corner-all
    //ui-slider-range ui-widget-header ui-corner-all

    //===========================methods================================

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void datesPage() {
        serviceHeader.click();
        datesPage.click();
    }

    public void setRange2() {
        assertEquals(range2.size(), 2);
//        range2.get(0).dragAndDropTo("0");
//        range2.get(1).dragAndDropTo("100");
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }
}
