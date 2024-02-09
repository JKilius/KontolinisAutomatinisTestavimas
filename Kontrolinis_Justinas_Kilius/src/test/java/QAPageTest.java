import lt.techin.ItemPage;
import lt.techin.MainPage;
import lt.techin.QAPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class QAPageTest extends BasePageTest {
    MainPage mainPage;
    QAPage qaPage;


    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/products.csv", numLinesToSkip = 1)
    void assertIfAllItemsInFileExistInWebsite(String itemName){
        mainPage = new MainPage(driver);
        qaPage = new QAPage(driver);

        mainPage.clickOnNavigationButton();
        qaPage.clickOnButtonSelectShowList();

        assertTrue(qaPage.isProductNameInTheWebSite(itemName), "Expected item not found: "+itemName);

    }




}
