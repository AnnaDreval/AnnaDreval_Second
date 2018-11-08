package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliders;

    @FindBy(css = ".ui-slider")
    private SelenideElement sliderLine;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    //===========================methods================================

    @Step
    public void setSliders(int left, int right) {

        double step = sliderLine.getSize().width / 100.0;

        double leftInit = Double.parseDouble(sliders.get(0).text());
        double rigthInit = Double.parseDouble(sliders.get(1).text());

        double factorLeft = (leftInit >= left ? 1 : 0);
        double factorRight = (rigthInit >= right ? 1 : 0);

        double leftX = (left - leftInit - factorLeft) * step;
        double rightX = (right - rigthInit - factorRight) * step;

        actions().dragAndDropBy(sliders.get(0), (int) leftX, 0).perform();
        actions().dragAndDropBy(sliders.get(1), (int) rightX, 0).perform();

    }

    //================================checks===================================

    @Step
    public void checkSliders(int left, int rigth) {

        assertEquals(Integer.parseInt(sliders.get(0).getText()), left);
        assertEquals(Integer.parseInt(sliders.get(1).getText()), rigth);

        String log0 = logs.get(0).getText().replaceAll("[\\s\\D]", "").substring(7);
        String log1 = logs.get(1).getText().replaceAll("[\\s\\D]", "").substring(7);

        if (Integer.parseInt(log0) < Integer.parseInt(log1)) {
            assertEquals(log0, Integer.toString(left));
            assertEquals(log1, Integer.toString(rigth));
        } else if (Integer.parseInt(log0) > Integer.parseInt(log1)) {
            assertEquals(log1, Integer.toString(left));
            assertEquals(log0, Integer.toString(rigth));
        }
    }
}
