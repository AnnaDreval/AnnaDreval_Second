package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide_HW3 {

    private String mainHeader = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
            " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
            " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE" +
            " VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = "[ui = 'label']")
    private SelenideElement userName;

    @FindBy(css = "ul.uui-navigation.nav  > li > a")
    private List<SelenideElement> items;

    @FindBy(css = "div.benefit-icon > span")
    private List<SelenideElement> images;

    @FindBy(css = "div.benefit > span")
    private List<SelenideElement> texts;

    @FindBy(css = "[name = 'jdi-text']")
    private SelenideElement jdiTitle;

    @FindBy(css = "[id = 'iframe']")
    private SelenideElement iFrame;

    @FindBy(css = "[id = 'epam_logo']")
    private SelenideElement logo;

    @FindBy(css = "[href = 'https://github.com/epam/JDI']")
    private SelenideElement jdiLink;

    @FindBy(css = "[class = 'mCustomScrollBox mCS-light mCSB_vertical mCSB_inside']")
    private SelenideElement leftSection;

    @FindBy(css = "[class = 'footer-content overflow']")
    private SelenideElement footer;


    //================================methods===================================

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkMainText() {
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
    }

    public void checkJdiTitle() {
        jdiTitle.shouldHave((text(mainHeader)));
    }

    public void checkUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkFourItems() {

        assertEquals(items.size(), 4);
        items.get(0).shouldHave(text("HOME"));
        items.get(1).shouldHave(text("CONTACT FORM"));
        items.get(2).shouldHave(text("SERVICE"));
        items.get(3).shouldHave(text("METALS & COLORS"));

    }

    public void checkFourImages() {
        assertEquals(images.size(), 4);
        for (SelenideElement elem : images) {
            elem.shouldBe(visible);
        }
    }

    public void checkFourTexts() {
        assertEquals(texts.size(), 4);
        texts.get(0).shouldHave(text("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        texts.get(1).shouldHave(text("To be flexible and\n" + "customizable"));
        texts.get(2).shouldHave(text("To be multiplatform"));
        texts.get(3).shouldHave(text("Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…"));

    }

    public void checkIFrame() {
        iFrame.shouldBe(visible);
    }

    public void checkLogo() {
        logo.shouldBe(visible);
    }

    public void checkJdiGit() {
        jdiLink.shouldHave(text("JDI GITHUB"));
    }

    public void checkJdiLink() {
        String link = jdiLink.getAttribute("href");
        assertEquals(link, "https://github.com/epam/JDI");
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkFooter() {
        footer.shouldBe(visible);
    }
}
