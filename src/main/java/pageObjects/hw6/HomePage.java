package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.HeaderMenuCategories;
import enums.ServiceMenuCategories;
import enums.hw4.DiffElemEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.hw6.Logs.URL_HOME_PAGE;
import static org.testng.Assert.assertEquals;

public class HomePage {

    public HomePage() {
        page(this);
    }

    ServiceMenuCategories options = ServiceMenuCategories.OPTIONS;
    HeaderMenuCategories headerOptions = HeaderMenuCategories.OPTIONS;

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "#Name")
    private SelenideElement login;

    @FindBy(css = "#Password")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "[ui = 'label']")
    private SelenideElement userName;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceHeader;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection serviceOptions;

    @FindBy(css = ".nav > li")
    private ElementsCollection headerMenuOptions;

    @FindBy(css = ".menu-title [ui = 'label']")
    private SelenideElement serviceLeftSection;

    @FindBy(css = ".sub > li > a p")
    private ElementsCollection serviceLeftOptions;

    @FindBy(css = "[href = 'different-elements.html']")
    private SelenideElement diffElements;

    @FindBy(css = "[href = 'dates.html']")
    private SelenideElement datesPage;

    @FindBy(css = "[href = 'user-table.html']")
    private SelenideElement userTableButton;

    //================================methods===================================

    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        open(URL_HOME_PAGE.status);
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
    @Given("I'm on the (.+) page")
    public void openDiffElem(String difElemPage) {
        serviceHeader.click();
        for (int i = 0; i < serviceOptions.size(); i++) {
            if (difElemPage.equals(options.title(i))) {
                serviceOptions.get(i).click();
            }
        }
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), DiffElemEnum.URL_DIFFERENT_ELEMENTS_PAGE.text);
    }

    @Step
    @When("I click on (.+) button in Header")
    public void clickServiceButton(String option) {
        for (int i = 0; i < headerMenuOptions.size(); i++) {
            if (option.equals(headerOptions.title(i))) {
                headerMenuOptions.get(i).click();
            }
        }
    }

    @Step
    @When("I click on (.+) button in Service dropdown")
    public void clickUserTable(String option) {
        for (int i = 0; i < serviceOptions.size(); i++) {
            if (option.equals(options.title(i))) {
                serviceOptions.get(i).click();
            }
        }
    }

    //================================checks===================================

    @Step
    @Then("The browser title is (.+)")
    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @Step
    @Then("The user name (.+) is displayed")
    public void checkUserName(String name) {
        userName.shouldHave(text(name));
    }

    @Step
    @Then("Service subcategory in the header contains options:")
    public void checkServiceSubcategory(List<String> options) {
        serviceHeader.click();
        serviceOptions.shouldHave(texts(options));
    }

    @Step
    @Then("Service subcategory in the left section contains the same options")
    public void checkServiceLeftSection() {
        serviceLeftSection.click();
        for (int i = 0; i < 8; i++) {
            serviceLeftOptions.get(i).shouldHave(text(options.title(i)));
        }
    }
}
