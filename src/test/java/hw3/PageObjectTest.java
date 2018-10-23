package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObjects.HomePage;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectTest {
    private String mainHeader = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
            " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
            " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE" +
            " VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private String mainTitle = "EPAM FRAMEWORK WISHES…";
    private String user = "PITER CHAILOVSKII";

    private HomePage homePage;
    private String driverPath = "src\\main\\resources\\chromedriver.exe";

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void indexPageContentTest() {

        driver.navigate().to("https://epam.github.io/JDI/");
        //homePage.open();

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        homePage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.userName(), user);

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> items = driver.findElements(By.cssSelector("ul.uui-navigation.nav  > li > a"));
        assertEquals(items.size(), 4);
        assertEquals(items.get(0).getText(), "HOME");
        assertEquals(items.get(1).getText(), "CONTACT FORM");
        assertEquals(items.get(2).getText(), "SERVICE");
        assertEquals(items.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector("div.benefit-icon > span"));
        assertEquals(images.size(), 4);
        for (WebElement elem : images) {
            assertTrue(elem.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.cssSelector("div.benefit > span"));
        assertEquals(texts.size(), 4);
        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…");


        //9 Assert a text of the main header
        assertEquals(homePage.mainTitle(), mainTitle);
        assertEquals(homePage.jdiTitle(), mainHeader);

        //10 Assert that there is the iframe in the center of page
        homePage.iFrame();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(homePage.logo());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiGit = driver.findElement(By.cssSelector("[href = 'https://github.com/epam/JDI']"));
        assertEquals(jdiGit.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        String jdiLink = driver.findElement(By.cssSelector("[href = 'https://github.com/epam/JDI']")).getAttribute("href");
        assertEquals(jdiLink, "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("[class = 'mCustomScrollBox mCS-light mCSB_vertical mCSB_inside']"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("[class = 'footer-content overflow']"));
        assertTrue(footer.isDisplayed());


    }
}
