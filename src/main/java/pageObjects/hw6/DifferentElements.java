package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.hw4.DiffElemEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.hw4.DiffElemEnum.*;
import static org.testng.Assert.assertEquals;

public class DifferentElements {

    public DifferentElements() {
        page(this);
    }

    private SelenideElement checkboxName;
    private SelenideElement radioName;

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkboxes;


    @FindBy(css = ".label-radio")
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

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    //===========================methods================================

    @Step
    @When("I select (.+)")
    public void selectCheckbox( String elements) {
      //  for (String elem: elements)
        {
            for (SelenideElement selElem: checkboxes) {
                if (selElem.parent().getText().equals(elements)) selElem.setSelected(true);
            }
        }

    }

    @Step
    private SelenideElement getCheckboxName(DiffElemEnum element) {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(element.text)) {
                checkboxName = checkbox;
            }
        });
        return checkboxName;
    }

    @Step
    @When("I select radiobutton")
    public void selectRadio(DiffElemEnum... diffElemEnums) {
        for (DiffElemEnum element : diffElemEnums) {
            getRadioName(element).click();
        }

        for (DiffElemEnum element : diffElemEnums) {
            radioName.find(INPUT.text).should(Condition.checked);
        }
    }

    @Step
    private SelenideElement getRadioName(DiffElemEnum element) {
        radiobuttons.forEach(radio -> {
            if (radio.text().equalsIgnoreCase(element.text)) {
                radioName = radio;
            }
        });
        return radioName;
    }

    @Step
    @When("I select dropdown item")
    public void selectDropDown(DiffElemEnum diffElemEnums) {
        dropdown.click();
        dropdown.selectOption(diffElemEnums.text);
        dropdown.should(Condition.text(diffElemEnums.text));
    }

    @Step
    @When("I unselect checkboxes")
    public void unSelectCheckbox(DiffElemEnum... diffElemEnums) {
        for (DiffElemEnum element : diffElemEnums) {
            getCheckboxName(element).click();
        }

        for (DiffElemEnum element : diffElemEnums) {
            getCheckboxName(element).find(INPUT.text).shouldNot(Condition.checked);
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
    @Then("There are logs about all actions")
    public void checkLogs(int start, int finish, boolean isChecked, DiffElemEnum... elements) {

        StringBuffer actualElement = new StringBuffer();

        for (DiffElemEnum element : elements) {
            actualElement.setLength(0);

            for (int i = start; i < finish; i++) {

                String log = logs.get(i).getText().replaceAll("[\\d\\s\\W]", "").toLowerCase();

                if (log.startsWith(element.text.toLowerCase()) && log.endsWith(String.valueOf(isChecked))) {
                    actualElement.append(element.text);
                    break;

                } else if ((log.startsWith(METALL.text.toLowerCase()) | log.startsWith(COLOR.text.toLowerCase()))
                        && log.endsWith(element.text.toLowerCase())) {
                    actualElement.append(element.text);
                    break;
                }
            }
            assertEquals(element.text, actualElement.toString());
        }
    }

}
