package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.hw4.DiffElemEnum.COLOR;
import static enums.hw4.DiffElemEnum.METALL;
import static org.testng.Assert.assertEquals;

public class DifferentElements {

    public DifferentElements() {
        page(this);
    }

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radiobuttons;

    @FindBy(css = "[value = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

    @FindBy(css = "[name = 'log-sidebar']")
    private SelenideElement rigthSection;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = ".colors")
    private SelenideElement dropdownform;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    //===========================methods================================

    @Step
    @When("Select checkboxes:")
    public void selectCheckBox(List<String> checkbox) {
        for (String boxes : checkbox) {
            checkboxes.find(text(boxes)).click();
        }
    }

    @Step
    @When("I select (.+) radiobutton")
    public void selectRadio(String radio) {
        radiobuttons.find(text(radio)).click();
    }

    @Step
    @When("I select (.+) dropdown item")
    public void selectDropDown(String drop) {
        dropdown.click();
        dropdown.selectOption(drop);
        dropdown.should(Condition.text(drop));
    }

    @Step
    @When("Unselect checkboxes:")
    public void unselectCheckBox(List<String> checkbox) {
        for (String boxes : checkbox) {
            checkboxes.find(text(boxes)).click();
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
    @Then("There are logs about all actions:")
    public void checkLogs(List<String> elements) {
        int finish = logs.size();
        int start = finish - elements.size();

        StringBuffer actualElement = new StringBuffer();

        for (String element : elements) {
            actualElement.setLength(0);

            for (int i = start; i < finish; i++) {

                String log = logs.get(i).getText().replaceAll("[\\d\\s\\W]", "").toLowerCase();

                if (log.startsWith(element.toLowerCase()) && log.endsWith(String.valueOf(true))) {
                    actualElement.append(element);
                    break;

                } else if ((log.startsWith(METALL.text.toLowerCase()) | log.startsWith(COLOR.text.toLowerCase()))
                        && log.endsWith(element.toLowerCase())) {
                    actualElement.append(element);
                    break;
                }
            }
            assertEquals(element, actualElement.toString());
        }
    }

}
