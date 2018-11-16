package hw8;

import hw8.entities.HeaderMenu;
import hw8.entities.Users;
import org.testng.annotations.Test;

import static hw8.sites.JdiSite.homePage;

public class MetalsColoursDataSet extends TestBase{

    @Test
    public void metalsColoursTest() {
        homePage.open();
        homePage.login(Users.PITER_CHAILOVSKII);
        homePage.header.menu.select(HeaderMenu.METALS_COLORS);
    }

}
