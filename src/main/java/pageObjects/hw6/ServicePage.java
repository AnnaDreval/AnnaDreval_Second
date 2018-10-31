package pageObjects.hw6;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Logs.*;
import static org.testng.Assert.assertEquals;

public class ServicePage {

    ServiceMenuCategories options = ServiceMenuCategories.OPTIONS;

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

    @FindBy(css = "[class = 'dropdown-menu'] > li > a")
    private List<SelenideElement> serviceOptions;

    @FindBy(css = ".menu-title [ui = 'label']")
    private SelenideElement serviceLeftSection;

    @FindBy(css = ".sub > li > a p")
    private List<SelenideElement> serviceLeftOptions;

    @FindBy(css = "[href = 'different-elements.html']")
    private SelenideElement diffElements;

    @FindBy(css = ".label-checkbox > input")
    private List<SelenideElement> checkboxes;

    @FindBy(css = ".label-radio > input")
    private List<SelenideElement> radiobuttons;

    @FindBy(css = ".uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = "[value = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

    @FindBy(css = "[name = 'log-sidebar']")
    private SelenideElement rigthSection;

    @FindBy(css = "[id = 'mCSB_1']")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    @FindBy(css = ".colors")
    private SelenideElement dropdownform;

    @FindBy(css = ".uui-form-element > option")
    private List<SelenideElement> dropdownOptions;

    //===========================methods================================

    @Step
    @Given("I'm on the Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @When("I login as user (.+)  with password (.+) ")
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    @Given("I'm on the Different Elements page")
    public void openDiffElem() {
        serviceHeader.click();
        diffElements.click();
    }

    @Step
    @When("I select checkboxes")
    public void selectCheckbox(CheckBoxes... checkBoxes) {
        for (CheckBoxes c : checkBoxes) {
            if (c == CheckBoxes.WATER) checkboxes.get(0).click();
            else if (c == CheckBoxes.EARTH) checkboxes.get(1).click();
            else if (c == CheckBoxes.WIND) checkboxes.get(2).click();
            else if (c == CheckBoxes.FIRE) checkboxes.get(3).click();
        }
    }

    @Step
    @When("I select radiobutton")
    public void selectRadio(RadioButtons... radioButtons) {
        for (RadioButtons rb : radioButtons) {
            if (rb == RadioButtons.GOLD) radiobuttons.get(0).click();
            else if (rb == RadioButtons.SILVER) radiobuttons.get(1).click();
            else if (rb == RadioButtons.BRONZE) radiobuttons.get(2).click();
            else if (rb == RadioButtons.SELEN) radiobuttons.get(3).click();
        }
    }

    @Step
    @When("I select dropdown item")
    public void selectDropDown(DropDown... dropDowns) {
        dropdownform.click();
        for (DropDown dd : dropDowns) {
            if (dd == DropDown.RED) dropdownOptions.get(0).click();
            else if (dd == DropDown.GREEN) dropdownOptions.get(1).click();
            else if (dd == DropDown.BLUE) dropdownOptions.get(2).click();
            else if (dd == DropDown.YELLOW) dropdownOptions.get(3).click();
        }
    }

    //================================checks===================================

    @Step
    @Then("The browser title is Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    @Then("The user icon is displayed on the header")
    public void checkUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
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

    @Step
    @Then("Different elements interface contains all elements")
    public void checkDiffElemInterface() {
        assertEquals(checkboxes.size(), 4);
        assertEquals(radiobuttons.size(), 4);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
        defaultButton.shouldBe(visible);
    }

    @Step
    @Then("There is a Right Section")
    public void checkRightSection() {
        rigthSection.shouldBe(visible);
    }

    @Step
    @Then("There is Left Section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    @Then("There are checkbox logs on the info-panel section")
    public void checkCheckboxInfo(Logs... logsForCheck) {
        String wind = logs.get(0).getText();
        String water = logs.get(1).getText();

        for (Logs l : logsForCheck) {
            if (l.equals(WATER_TRUE)) assertEquals(water.substring(9), Logs.WATER_TRUE.status);
            else if (l.equals(WIND_TRUE)) assertEquals(wind.substring(9), Logs.WIND_TRUE.status);
        }
    }

    @Step
    @Then("There is radiobutton log on the info-panel section")
    public void checkRadioInfo(Logs... logsForCheck) {
        String selen = logs.get(0).getText();

        for (Logs l : logsForCheck) {
            if (l.equals(SELEN_TRUE)) assertEquals(selen.substring(9), Logs.SELEN_TRUE.status);
        }
    }

    @Step
    @Then("There is dropdown log on the info-panel section")
    public void checkDropDown(Logs... logsForCheck) {
        String yellow = logs.get(0).getText();

        for (Logs l : logsForCheck) {
            if (l.equals(YELLOW_TRUE)) assertEquals(yellow.substring(9), Logs.YELLOW_TRUE.status);
        }
    }

    @Step
    @Then("There are checkbox logs about unselect")
    public void checkUnselect(Logs... logsForCheck) {
        String wind = logs.get(0).getText();
        String water = logs.get(1).getText();

        for (Logs l : logsForCheck) {
            if (l.equals(WATER_FALSE)) assertEquals(water.substring(9), Logs.WATER_FALSE.status);
            else if (l.equals(WIND_FALSE)) assertEquals(wind.substring(9), Logs.WIND_FALSE.status);
        }
    }
}
