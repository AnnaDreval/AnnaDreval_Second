package hw2.ex1;

import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.*;

public class IndexPage {

    @Test(dataProvider = "indexPageDataProvider", dataProviderClass = DataProviders.class)
    public void textsAssertingTest(int num, String text) {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Asserting 4 texts below 4 pictures
        List<WebElement> texts = driver.findElements(By.cssSelector("div.benefit > span"));
        assertEquals(texts.get(num).getText(), text);

        //4 Close
        driver.close();

    }

}
