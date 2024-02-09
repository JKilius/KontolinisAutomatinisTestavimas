import lt.techin.ItemPage;
import lt.techin.MainPage;
import lt.techin.QAPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class ItemPageTest extends BasePageTest {

    MainPage mainPage;
    QAPage qaPage;
    ItemPage itemPage;

    @Test
    void assertIfQuantityInputWorks() {
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);
        itemPage = new ItemPage(driver);

        String randomQuantity = itemPage.generateRandomNumber();

        mainPage.clickOnNavigationButton();
        qaPage.clickOnButtonSelectShowList();
        qaPage.clickGeniusDuck();
        itemPage.clearInputQuantity();
        itemPage.inputRequiredQuantity(randomQuantity);

        assertEquals(randomQuantity, itemPage.getQuantity(), "The quantity is incorrect or not selected");


    }

    @Test
    void assertIfAddingToCartWorks() {
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);
        itemPage = new ItemPage(driver);

        mainPage.clickOnNavigationButton();
        qaPage.clickOnButtonSelectShowList();
        qaPage.clickGeniusDuck();
        itemPage.clearInputQuantity();
        itemPage.inputRequiredQuantity(itemPage.generateRandomNumber());
        itemPage.clickButtonAddToCart();
        itemPage.clickCartDropdown();

        assertTrue(itemPage.isAlertMessageVisible(), "No alert message, should be 'Success...'");
        assertEquals("Success: You have added Java Genius Duck to your shopping cart!", itemPage.textAlertMessage(), "Your alert message is incorrect. Should be:'Success: You have added Java Genius Duck to your shopping cart!'");
        assertTrue(itemPage.getCartInfo().contains("Duck"), "Duck does not exist in the eshop");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/products.csv", numLinesToSkip = 1)
    void selectItemFromTheFileAndAddToTheCart(String productName){
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);
        itemPage = new ItemPage(driver);

        mainPage.clickOnNavigationButton();
        qaPage.clickOnButtonSelectShowList();
        qaPage.clickSelectedItemByName(productName);
        itemPage.clearInputQuantity();
        itemPage.inputRequiredQuantity(itemPage.generateRandomNumber());
        itemPage.clickButtonAddToCart();
        itemPage.clickCartDropdown();

        assertEquals("Success: You have added " + productName + " to your shopping cart!", itemPage.textAlertMessage(), "Your alert message is incorrect. Should be:'Success: You have added "+productName+ "to your shopping cart!'");
        assertTrue(itemPage.getCartInfo().contains(productName), productName+" does not exist in the eshop");
    }


}
