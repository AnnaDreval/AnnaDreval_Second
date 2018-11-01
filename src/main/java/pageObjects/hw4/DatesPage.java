package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;
import static enums.SlidersLog.*;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    private int sliderLeft;
    private int sliderRight;

    @FindBy(css = "[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(css = "[href = 'dates.html']")
    private SelenideElement datesPage;

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliders;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    //===========================methods================================

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

    public void checkSliders() {

        assertEquals(Integer.parseInt(sliders.get(0).getText()), sliderLeft);
        assertEquals(Integer.parseInt(sliders.get(1).getText()), sliderRight);

        String from = logs.get(1).getText().substring(9);
        String to = logs.get(0).getText().substring(9);

        assertEquals(from, FROM_SLIDER.status + sliderLeft + END.status);
        assertEquals(to, TO_SLIDER.status + sliderRight + END.status);
    }

}
