package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.ServiceMenuCategories;
import enums.hw6.UserTable;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.hw6.Logs.VIP;
import static org.testng.Assert.assertEquals;

public class UserPage {

    public UserPage() {
        page(this);
    }

    ServiceMenuCategories options = ServiceMenuCategories.OPTIONS;

    @FindBy(css = "#user-table select")
    private ElementsCollection userDropDowns;

    @FindBy(css = "#user-table > tbody > tr > td a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table > tbody > tr > td img")
    private ElementsCollection images;

    @FindBy(css = ".user-descr > span")
    private ElementsCollection texts;

    @FindBy(css = ".user-descr > input")
    private ElementsCollection checkboxes;

    @FindBy(css = "[class = 'panel-body-list logs'] > li")
    private ElementsCollection logs;

    @FindBy(css = "#user-table > tbody > tr:nth-child(2) > td:nth-child(2) > select > option")
    private ElementsCollection romanOptions;

    @FindBy(css = "#user-table > tbody > tr > td > div > span")
    private ElementsCollection descriptions;

    @FindBy(css = ".dropdown-menu > li > a")
    private ElementsCollection serviceOptions;

    //===========================methods================================

    @Step
    @When("I select 'vip' checkbox for (.+)")
    public void selectIvanVip(String name) {
        for (int i = 0; i < checkboxes.size(); i++) {
            if (name.equals(userNames.get(i).getText()))
                checkboxes.get(i).setSelected(true);
        }
    }

    @Step
    @When("I click on dropdown in column Type for user (.+)")
    public void clickRomanDropDown(String name) {
        for (int i = 0; i < 6; i++) {
            if (name.equals(UserTable.PLAYERS.title(i))) {
                userDropDowns.get(i).click();
            }
        }
    }

    //================================checks===================================

    @Step
    @Then("(.+) page is opened")
    public void checkOpenUserTable(String option) {
        assertEquals(getWebDriver().getTitle(), option);
    }

    @Step
    @Then("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkDropDownsNumber(int size) {
        userDropDowns.shouldHaveSize(size);
    }

    @Step
    @Then("(\\d+) User names are displayed on Users Table on User Table Page")
    public void checkUserNameNumber(int size) {
        userNames.shouldHaveSize(size);
    }

    @Step
    @Then("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void checkImageNumber(int size) {
        images.shouldHaveSize(size);
    }

    @Step
    @Then("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void checkTextNumber(int size) {
        texts.shouldHaveSize(size);
    }

    @Step
    @Then("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxNumber(int size) {
        checkboxes.shouldHaveSize(size);
    }

    @Step
    @Then("1 log row has (.+) text in log section")
    public void checklogs(String log) {
        log = logs.get(0).getText().substring(9);
        assertEquals(log, VIP.status);
    }

    @Step
    @Then("droplist contains values")
    public void checkRomanOptions(List<String> roles) {
        romanOptions.shouldHave(texts(roles.subList(1, roles.size())));
    }

    @Step
    @When("User table contains following values:")
    public void checkUserTable(DataTable userTable) {
        userNames.shouldHave(texts(userTable.column(1).subList(1, userTable.height())));
        descriptions.shouldHave(texts(userTable.column(2).subList(1, userTable.height())));

    }

}
