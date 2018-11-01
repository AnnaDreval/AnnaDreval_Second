package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
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
    public void openDiffElem() {
        serviceHeader.click();
        diffElements.click();
    }

    @Step
    public void selectCheckbox(CheckBoxes... checkBoxes) {
        for (CheckBoxes c : checkBoxes) {
            checkboxes.get(c.num).click();
        }
    }

    @Step
    public void selectRadio(RadioButtons... radioButtons) {
        for (RadioButtons rb : radioButtons) {
            radiobuttons.get(rb.num).click();
        }
    }

    @Step
    public void selectDropDown(DropDown... dropDowns) {
        dropdownform.click();
        for (DropDown dd : dropDowns) {
            dropdownOptions.get(dd.num).click();
        }
    }

    //================================checks===================================

    @Step
    public void checkDiffElemInterface() {
        assertEquals(checkboxes.size(), 4);
        assertEquals(radiobuttons.size(), 4);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    @Step
    public void checkRightSection() {
        rigthSection.shouldBe(visible);
    }

    @Step
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    public void checkCheckboxInfo(CheckBoxes... checkBoxes) {
        int i = 0;
        for (CheckBoxes cb : checkBoxes) {
            assertEquals(logs.get(i).getText().substring(9), cb.title + checkBoxLog + true);
            ++i;
        }
    }

    @Step
    public void checkRadioInfo(RadioButtons radio) {
        assertEquals(logs.get(0).getText().substring(9), radiobuttonLog + radio.title);
    }

    @Step
    public void checkDropDown(DropDown dropDown) {
        assertEquals(logs.get(0).getText().substring(9), dropdownLog + dropDown.title);
    }

    @Step
    public void checkUnselect(CheckBoxes... checkBoxes) {
        int i = 0;
        for (CheckBoxes cb : checkBoxes) {
            assertEquals(logs.get(i).getText().substring(9), cb.title + checkBoxLog + false);
            ++i;
        }
    }

}
