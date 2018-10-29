package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DatesPage_HW4 {

    private int sliderLeft;
    private int sliderRight;
    private String fromSlider = "Range 2(From):";
    private String toSlider = "Range 2(To):";
    private String end = " link clicked";

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

    @FindBy(css = "[href = 'dates.html']")
    private SelenideElement datesPage;

    @FindBy(css = ".col-sm-5 > [style = 'left: 20%;']")
    private SelenideElement range2_Left;

    @FindBy(css = ".col-sm-5 > [style = 'left: 100%;']")
    private SelenideElement range2_Rigth;

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliders;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;


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

    public void datesPage() {
        serviceHeader.click();
        datesPage.click();
    }

    public void setSliders(int left, int right) {

        actions().dragAndDropBy(sliders.get(0), -1000, 0).build().perform();
        actions().dragAndDropBy(sliders.get(1), 1000, 0).build().perform();

        double panelStep = (double) (sliders.get(1).getLocation().getX() - sliders.get(0).getLocation().getX()) / 100;

        actions().dragAndDropBy(sliders.get(0), (int) (left * panelStep - ((left > 0) ? 0.5 * panelStep : panelStep)), 0).build()
                .perform();
        actions().dragAndDropBy(sliders.get(1), (int) (-((100 - right) * panelStep + panelStep)), 0).build().perform();

        sliderLeft = Integer.parseInt(sliders.get(0).getText());
        sliderRight = Integer.parseInt(sliders.get(1).getText());

    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkSliders() {

        assertEquals(Integer.parseInt(sliders.get(0).getText()), sliderLeft);
        assertEquals(Integer.parseInt(sliders.get(1).getText()), sliderRight);

        String from = logs.get(1).getText();
        String to = logs.get(0).getText();

        assertEquals(from.substring(9), fromSlider + sliderLeft + end);
        assertEquals(to.substring(9), toSlider + sliderRight + end);

    }

}
