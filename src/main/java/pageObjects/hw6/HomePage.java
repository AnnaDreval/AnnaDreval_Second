package pageObjects.hw6;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.ServiceMenuCategories;
import enums.hw4.DiffElemEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePage {

    public HomePage() {
        page(this);
    }

    ServiceMenuCategories options = ServiceMenuCategories.OPTIONS;

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

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

    //================================methods===================================

    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @When("I login as user (.+) with password (.+)")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    @Given("I'm on the Different Elements page")
    public void openDiffElem() {
        serviceHeader.click();
        diffElements.click();
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), DiffElemEnum.URL_DIFFERENT_ELEMENTS_PAGE.text);
    }

    //================================checks===================================

    @Step
    @Then("The browser title is Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    @Then("The user name (.+) is displayed")
    public void checkUserName(String name) {
        userName.shouldHave(text(name));
    }

    @Step
    @Then("Service subcategory in the header contains options")
    public void checkServiceSubcategory() {
        serviceHeader.click();
        for (int i = 0; i < serviceOptions.size(); i++) {
            serviceOptions.get(i).shouldHave(text(options.title(i)));
        }
    }

    @Step
    @Then("Service subcategory in the left section contains options")
    public void checkServiceLeftSection() {
        serviceLeftSection.click();
        for (int i = 0; i < 8; i++) {
            serviceLeftOptions.get(i).shouldHave(text(options.title(i)));
        }
    }

}
