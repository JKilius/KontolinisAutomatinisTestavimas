import lt.techin.MainPage;
import lt.techin.QAPage;
import org.junit.jupiter.api.Test;

public class QAPageTest extends BasePageTest {
    MainPage mainPage;
    QAPage qaPage;

    @Test
    void getAllProductDescriptions() {
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);
        mainPage.clickOnNavigationButton();
        qaPage.clickOnButtonSelectShowList();



    }


}
