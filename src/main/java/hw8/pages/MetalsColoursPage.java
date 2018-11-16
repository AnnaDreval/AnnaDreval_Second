package hw8.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalsColoursPage extends WebPage {

    public Header header;

    public void openPage() {
        header.metalColor.click();
    }
}
