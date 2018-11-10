package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static enums.hw4.SlidersLog.FROM;
import static enums.hw4.SlidersLog.TO;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    @FindBy(css = "a.ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliders;

    @FindBy(css = ".ui-slider")
    private SelenideElement sliderLine;

    @FindBy(css = ".panel-body-list > li")
    private List<SelenideElement> logs;

    //================================methods===================================

    @Step
    public void setSliders(double from, double to) {

        double leftSlider = Double.parseDouble(sliders.get(0).text());

        if (from <= leftSlider) {
            dragNdrop(sliders.get(0), from);
            dragNdrop(sliders.get(1), to);

        } else {
            dragNdrop(sliders.get(1), to);
            dragNdrop(sliders.get(0), from);
        }
    }

    @Step
    private void dragNdrop(SelenideElement slider, double to) {

        double step = sliderLine.getSize().width / 100.0;

        double from = Double.parseDouble(slider.text());
        double x = (to - from - (from >= to ? 1 : 0)) * step;

        actions().dragAndDropBy(slider.toWebElement(), (int) x, 0).perform();
    }

    //================================checks===================================

    @Step
    public void checkSliders(int left, int rigth) {

        assertEquals(Integer.parseInt(sliders.get(0).getText()), left);
        assertEquals(Integer.parseInt(sliders.get(1).getText()), rigth);

        for (int i = 0; i < 2; i++) {
            if (logs.get(i).has(text(TO.status))) {
                logs.get(i).shouldHave(text(Integer.toString(rigth)));
            } else if (logs.get(i).has(text(FROM.status))) {
                logs.get(i).shouldHave(text(Integer.toString(left)));
            }
        }
    }

}
