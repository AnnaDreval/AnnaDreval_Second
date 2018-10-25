package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy
    private WebDriver driver;

    @FindBy(css = "[ui = 'label']")
    private WebElement user;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "[name = 'jdi-text']")
    private WebElement jdiTitle;

    @FindBy(id = "iframe")
    private WebElement iFrame;

    @FindBy(id = "epam_logo")
    private WebElement logo;

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public String userName() {
       return user.getText();
    }

    public String mainTitle() {
        return mainTitle.getText();
    }

    public String jdiTitle() {
        return jdiTitle.getText();
    }

    public void iFrame() {
        iFrame.isDisplayed();
    }

    public Boolean logo() {
        return logo.isDisplayed();
    }


    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/");
    }

}
