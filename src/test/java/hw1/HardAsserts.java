package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HardAsserts {
    @Test
    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
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
       //через лист сначала размр проверить
        //цикл на 4 эл-та foreach ... .contains(elem.getText())
        WebElement homeTitle = driver.findElement(By.cssSelector("[href = 'index.html']"));
        assertEquals(homeTitle.getText(), "HOME");

        WebElement contactForm = driver.findElement(By.cssSelector("[href = 'contacts.html']"));
        assertEquals(contactForm.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.cssSelector("[class = 'dropdown-toggle']"));
        assertEquals(service.getText(), "SERVICE");

        WebElement metCol = driver.findElement(By.cssSelector("[href= 'metals-colors.html']"));
        assertEquals(metCol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiceImage = driver.findElement(By.cssSelector("[class = 'icons-benefit icon-practise']"));
        assertEquals(practiceImage.isDisplayed(), true);

        WebElement customeImage = driver.findElement(By.cssSelector("[class = 'icons-benefit icon-custom']"));
        assertEquals(customeImage.isDisplayed(), true);

        WebElement multiImage = driver.findElement(By.cssSelector("[class = 'icons-benefit icon-multi']"));
        assertEquals(multiImage.isDisplayed(), true);

        WebElement baseImage = driver.findElement(By.cssSelector("[class = 'icons-benefit icon-base']"));
        assertEquals(baseImage.isDisplayed(), true);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement practiceTxt = driver.findElement(By.cssSelector("[class = 'benefit-txt']"));
        assertEquals(practiceTxt.getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
//        WebElement customeTxt = driver.findElement(By.cssSelector("[class = 'benefit-txt']"));
//        assertEquals(customeTxt.getText(), "To be flexible and\n" +
//                "customizable");

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
//into private peremennie
        WebElement jdiTitle = driver.findElement(By.cssSelector("[name = 'jdi-text']"));
        assertEquals(jdiTitle.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
                " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
                " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE" +
                " VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.id("iframe"));
        assertEquals(iFrame.isDisplayed(), true);

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement logo = driver.findElement(By.id("epam_logo"));
        assertEquals(logo.isDisplayed(), true);

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiGit = driver.findElement(By.cssSelector("[href = 'https://github.com/epam/JDI']"));
        assertEquals(jdiGit.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL

        assertEquals(jdiGit.isEnabled(), true);
        //String jdiLink = driver.findElement(By.linkText("https://github.com/epam/JDI"))//.getAttribute("href");
        //assertEquals(jdiLink.isDisplayed(), true);

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("[class = 'mCustomScrollBox mCS-light mCSB_vertical mCSB_inside']"));
        assertEquals(leftSection.isDisplayed(), true);

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("[class = 'footer-content overflow']"));
        assertEquals(footer.isDisplayed(), true);

        //17 Close Browser
        driver.close();


    }
}
