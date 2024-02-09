import lt.techin.ItemPage;
import lt.techin.MainPage;
import lt.techin.QAPage;
import org.junit.jupiter.api.Test;

public class ItemPageTest extends BasePageTest{

    MainPage mainPage;
    QAPage qaPage;
    ItemPage itemPage;

    @Test
    void assertIfQuantityInputWorks(){
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);
        itemPage = new ItemPage(driver);

        mainPage.clickOnNavigationButton();
        qaPage.clickOnButtonSelectShowList();
        qaPage.clickGeniusDuck();
        itemPage.clearInputQuantity();
        itemPage.inputRequiredQuantity("20");
        itemPage.clickButtonAddToCart();


    }
}
