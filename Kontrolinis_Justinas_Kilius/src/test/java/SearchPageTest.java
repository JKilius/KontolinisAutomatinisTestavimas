import lt.techin.ItemPage;
import lt.techin.MainPage;
import lt.techin.SearchPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SearchPageTest extends BasePageTest{

    MainPage mainPage;
    SearchPage searchPage;

    @Test
    void assertIfSearchWasSuccessful(){
        mainPage=new MainPage(driver);
        searchPage=new SearchPage(driver);

        mainPage.inputSearchItem("Duck");
        mainPage.clickButtonSearch();

        System.out.println(searchPage.getFoundItemsDescriptionText());

        assertTrue(searchPage.getFoundItemsDescriptionText().stream().anyMatch(i->i.contains("Duck")));

    }

    @Test
    void assertIfAddAllItemsToCartWorks(){
        mainPage=new MainPage(driver);
        searchPage=new SearchPage(driver);

        mainPage.inputSearchItem("Duck");
        mainPage.clickButtonSearch();
        searchPage.clickButtonSelectList();

        searchPage.clickAllAddToCartButtons();
    }
}
