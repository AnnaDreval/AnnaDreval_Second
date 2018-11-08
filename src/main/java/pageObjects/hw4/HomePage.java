package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import enums.ServiceMenuCategories;
import enums.Users;
import enums.hw4.DiffElemEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class HomePage {

    ServiceMenuCategories options = ServiceMenuCategories.OPTIONS;

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = "[ui = 'label']")
    private SelenideElement userName;

    @FindBy(css = "[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(css = "[class = 'dropdown-menu'] > li > a")
    private List<SelenideElement> serviceOptions;

    @FindBy(css = ".menu-title [ui = 'label']")
    private SelenideElement serviceLeftSection;

    @FindBy(css = ".sub > li > a p")
    private List<SelenideElement> serviceLeftOptions;

    @FindBy(css = "[href = 'different-elements.html']")
    private SelenideElement diffElements;

    @FindBy(css = "[href = 'dates.html']")
    private SelenideElement datesPage;

    //===========================methods================================

    @Step
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void openDiffElem() {
        serviceHeader.click();
        diffElements.click();
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), DiffElemEnum.URL_DIFFERENT_ELEMENTS_PAGE.text);
    }

    @Step
    public void openDatesPage() {
        serviceHeader.click();
        datesPage.click();
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), DiffElemEnum.URL_DATES_PAGE.text);
    }

    //================================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    public void checkUserName(Users user) {
        userName.shouldHave(text(user.name));
    }

    @Step
    public void checkServiceSubcategory() {
        serviceHeader.click();
        for (int i = 0; i < serviceOptions.size(); i++) {
            serviceOptions.get(i).shouldHave(text(options.title(i)));
        }
    }

    @Step
    public void checkServiceLeftSection() {
        serviceLeftSection.click();
        for (int i = 0; i < 8; i++) {
            serviceLeftOptions.get(i).shouldHave(text(options.title(i)));
        }
    }
}
