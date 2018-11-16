package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.DiffElemEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static enums.hw4.DiffElemEnum.*;
import static org.testng.Assert.assertEquals;

public class DifferentElements {

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
    public void selectCheckbox(DiffElemEnum... diffElemEnums) {
        for (DiffElemEnum element : diffElemEnums) {
            getCheckboxName(element).click();
        }

        for (DiffElemEnum element : diffElemEnums) {
            getCheckboxName(element).find(INPUT.text).should(Condition.checked);
        }
    }

    private SelenideElement getCheckboxName(DiffElemEnum element) {
        checkboxes.forEach(checkbox -> {
            if (checkbox.text().equalsIgnoreCase(element.text)) {
                checkboxName = checkbox;
            }
        });
        return checkboxName;
    }

    @Step
    public void selectRadio(DiffElemEnum... diffElemEnums) {
        for (DiffElemEnum element : diffElemEnums) {
            getRadioName(element).click();
        }
        radioName.find(INPUT.text).should(Condition.checked);

    }

    private SelenideElement getRadioName(DiffElemEnum element) {
        radiobuttons.forEach(radio -> {
            if (radio.text().equalsIgnoreCase(element.text)) {
                radioName = radio;
            }
        });
        return radioName;
    }

    @Step
    public void selectDropDown(DiffElemEnum diffElemEnums) {
        dropdown.click();
        dropdown.selectOption(diffElemEnums.text);
        dropdown.should(Condition.text(diffElemEnums.text));
    }

    @Step
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
