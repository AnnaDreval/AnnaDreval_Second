package pageObjects.hw6;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.hw4.CheckBoxes;
import enums.hw4.DropDown;
import enums.hw4.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class DifferentElements {

    private String checkBoxLog = ": condition changed to ";
    private String radiobuttonLog = "metal: value changed to ";
    private String dropdownLog = "Colors: value changed to ";


    @FindBy(css = "[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(css = "[href = 'different-elements.html']")
    private SelenideElement diffElements;

    @FindBy(css = ".label-checkbox > input")
    private List<SelenideElement> checkboxes;

    @FindBy(css = ".label-radio > input")
    private List<SelenideElement> radiobuttons;

    @FindBy(css = "[value = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

    @FindBy(css = "[name = 'log-sidebar']")
    private SelenideElement rigthSection;

    @FindBy(css = "[id = 'mCSB_1']")
    private SelenideElement leftSection;

    @FindBy(css = ".colors")
    private SelenideElement dropdownform;

    @FindBy(css = ".uui-form-element > option")
    private List<SelenideElement> dropdownOptions;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    //===========================methods================================

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
            checkboxes.get(c.num).click();
        }
    }

    @Step
    @When("I select radiobutton")
    public void selectRadio(RadioButtons... radioButtons) {
        for (RadioButtons rb : radioButtons) {
            radiobuttons.get(rb.num).click();
        }
    }

    @Step
    @When("I select dropdown item")
    public void selectDropDown(DropDown... dropDowns) {
        dropdownform.click();
        for (DropDown dd : dropDowns) {
            dropdownOptions.get(dd.num).click();
        }
    }

    //================================checks===================================

    @Step
    @Then("Different elements interface contains all elements")
    public void checkDiffElemInterface() {
        assertEquals(checkboxes.size(), 4);
        assertEquals(radiobuttons.size(), 4);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
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
    public void checkCheckboxInfo(CheckBoxes... checkBoxes) {
        int i = 0;
        for (CheckBoxes cb : checkBoxes) {
            assertEquals(logs.get(i).getText().substring(9), cb.title + checkBoxLog + true);
            ++i;
        }
    }

    @Step
    @Then("There is radiobutton log on the info-panel section")
    public void checkRadioInfo(RadioButtons radio) {
        assertEquals(logs.get(0).getText().substring(9), radiobuttonLog + radio.title);
    }

    @Step
    @Then("There is dropdown log on the info-panel section")
    public void checkDropDown(DropDown dropDown) {
        assertEquals(logs.get(0).getText().substring(9), dropdownLog + dropDown.title);
    }

    @Step
    @Then("There are checkbox logs about unselect")
    public void checkUnselect(CheckBoxes... checkBoxes) {
        int i = 0;
        for (CheckBoxes cb : checkBoxes) {
            assertEquals(logs.get(i).getText().substring(9), cb.title + checkBoxLog + false);
            ++i;
        }
    }

}
