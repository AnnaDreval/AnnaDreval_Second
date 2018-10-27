package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class ServicePage_HW4 {

    private String[] options = new String[]{"Support", "Dates", "Complex Table", "Simple Table",
            "User Table", "Table with pages", "Different Elements", "Performance"};
    private String windTrue = "Wind: condition changed to true";
    private String windFalse = "Wind: condition changed to false";
    private String waterTrue = "Water: condition changed to true";
    private String waterFalse = "Water: condition changed to false";
    private String selen = "metal: value changed to Selen";
    private String yellow = "Colors: value changed to Yellow";


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

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void openDiffElem() {
        serviceHeader.click();
        diffElements.click();
    }

    public void selectCheckbox() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
    }

    public void selectRadio() {
        radiobuttons.get(3).click();
    }

    public void selectDropDown() {
        dropdownform.click();
        assertEquals(dropdownOptions.size(), 4);
        dropdownOptions.get(3).click();
    }
    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkServiceSubcategory() {
        serviceHeader.click();
        assertEquals(serviceOptions.size(), 8);
        for (int i = 0; i < serviceOptions.size(); i++) {
            serviceOptions.get(i).shouldHave(text(options[i]));
        }
    }

    public void checkServiceLeftSection() {
        serviceLeftSection.click();
        assertEquals(serviceLeftOptions.size(), 10);
        for (int i = 0; i < 8; i++) {
            serviceLeftOptions.get(i).shouldHave(text(options[i]));
        }
    }

    public void checkDiffElemInterface() {
        assertEquals(checkboxes.size(), 4);
        assertEquals(radiobuttons.size(), 4);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
    }

    public void checkRightSection() {
        rigthSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkCheckboxInfo() {

        assertEquals(logs.size(), 2);

        String wind = logs.get(0).getText();
        assertEquals(wind.substring(9), this.windTrue);

        String water = logs.get(1).getText();
        assertEquals(water.substring(9), this.waterTrue);
    }

    public void checkRadioInfo() {
        assertEquals(logs.size(), 3);
        String selen = logs.get(0).getText();
        assertEquals(selen.substring(9), this.selen);
    }

    public void checkDropDown() {
        assertEquals(logs.size(), 4);
        String yellow = logs.get(0).getText();
        assertEquals(yellow.substring(9), this.yellow);
    }

    public void checkUnselect() {
        String wind = logs.get(0).getText();
        assertEquals(wind.substring(9), this.windFalse);

        String water = logs.get(1).getText();
        assertEquals(water.substring(9), this.waterFalse);
    }

}
