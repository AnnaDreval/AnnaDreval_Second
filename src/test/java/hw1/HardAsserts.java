package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HardAsserts {

    private String mainHeader = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
            " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
            " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE" +
            " VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @Test
    public void indexPageContentTest() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector("[ui = 'label']"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

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
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement jdiTitle = driver.findElement(By.cssSelector("[name = 'jdi-text']"));
        assertEquals(jdiTitle.getText(), mainHeader);

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.id("iframe"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement logo = driver.findElement(By.id("epam_logo"));
        assertTrue(logo.isDisplayed());

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

        //17 Close Browser
        driver.close();


    }
}
