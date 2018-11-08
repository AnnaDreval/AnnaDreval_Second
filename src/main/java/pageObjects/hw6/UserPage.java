package pageObjects.hw6;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import enums.hw6.Logs;
import enums.hw6.Roles;
import enums.hw6.UserTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static enums.hw6.Logs.URL_USER_TABLE_PAGE;
import static enums.hw6.Logs.VIP;
import static org.testng.Assert.assertEquals;

public class UserPage {

    Roles roles = Roles.ROLES;
    UserTable players = UserTable.PLAYERS;
    UserTable description = UserTable.DESCRIPTION;

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(css = "[href = 'user-table.html']")
    private SelenideElement userPageButton;

    @FindBy(css = "[id = 'user-table'] > tbody > tr > td > select")
    private List<SelenideElement> userDropDowns;

    @FindBy(css = "[id = 'user-table'] > tbody > tr > td a")
    private List<SelenideElement> userNames;

    @FindBy(css = "[id = 'user-table'] > tbody > tr > td img")
    private List<SelenideElement> images;

    @FindBy(css = "[class = 'user-descr'] > span")
    private List<SelenideElement> texts;

    @FindBy(css = "[class = 'user-descr'] > input")
    private List<SelenideElement> checkboxes;

    @FindBy(css = "[class = 'user-descr'] > [id = 'ivan']")
    private SelenideElement ivan;

    @FindBy(css = "[class = 'panel-body-list logs'] > li")
    private List<SelenideElement> logs;

    @FindBy(css = "#user-table > tbody > tr:nth-child(2) > td:nth-child(2) > select")
    private SelenideElement romanDropDown;

    @FindBy(css = "#user-table > tbody > tr:nth-child(2) > td:nth-child(2) > select > option")
    private List<SelenideElement> romanOptions;

    @FindBy(css = "#user-table > tbody > tr > td > div > span")
    private List<SelenideElement> descriptions;

    //===========================methods================================

    @Step
    @Given("I am on Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @Given("I login as user \"Piter Chailovskii\"")
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    @When("I click on \"Service\" button in Header")
    public void clickServiceButton() {
        serviceHeader.click();
    }

    @Step
    @When("I click on \"User Table\" button in Service dropdown")
    @Then("\"User Table\" page is opened")
    public void clickUserTableButton() {
        userPageButton.click();
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), URL_USER_TABLE_PAGE.status);
    }

    @Step
    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectIvanVip() {
        ivan.click();
    }

    @Step
    @When("I click on dropdown in column Type for user Roman")
    public void clickRomanDropDown() {
        romanDropDown.click();
    }

    //================================checks===================================

    @Step
    @Then("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkDropDownsNumber() {
        assertEquals(userDropDowns.size(), 6);
    }

    @Step
    @Then("6 User names are displayed on Users Table on User Table Page")
    public void checkUserNameNumber() {
        assertEquals(userNames.size(), 6);
    }

    @Step
    @Then("6 Description images are displayed on Users Table on User Table Page")
    public void checkImageNumber() {
        assertEquals(images.size(), 6);
    }

    @Step
    @Then("6 Description texts under images are displayed on Users Table on User Table Page")
    public void checkTextNumber() {
        assertEquals(texts.size(), 6);
    }

    @Step
    @Then("6 checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxNumber() {
        assertEquals(checkboxes.size(), 6);
    }

    @Step
    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void checklogs(Logs... inputLog) {
        String log = logs.get(0).getText().substring(9);
        for (Logs l : inputLog) {
            if (l.equals(VIP)) assertEquals(log, VIP.status);
        }
    }

    @Step
    @Then("droplist contains values")
    public void checkRomanOptions() {
        for (int i = 0; i < romanOptions.size(); i++) {
            romanOptions.get(i).shouldHave(text(roles.title(i)));
        }
    }

    @Step
    @When("User table contains following values:")
    public void checkUserTable() {
        checkPlayers();
        checkDescription();
    }

    public void checkPlayers() {
        assertEquals(userNames.size(), 6);
        for (int i = 0; i < userNames.size(); i++) {
            assertEquals(userNames.get(i).getText(), players.title(i));
        }
    }

    public void checkDescription() {
        assertEquals(descriptions.size(), 6);
        for (int i = 0; i < descriptions.size(); i++) {
            assertEquals(descriptions.get(i).getText(), description.title(i));
        }
    }

}
