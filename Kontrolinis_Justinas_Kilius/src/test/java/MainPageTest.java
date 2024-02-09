import lt.techin.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends BasePageTest{

    MainPage mainPage;

    @Test
    void goToQAPage(){
        mainPage = new MainPage(driver);
        mainPage.clickOnNavigationButton();

        assertTrue(mainPage.isPageHeadlineCorrect());
    }
}
