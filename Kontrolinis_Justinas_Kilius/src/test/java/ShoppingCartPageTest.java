import lt.techin.BasePage;
import lt.techin.MainPage;
import lt.techin.SearchPage;
import lt.techin.ShoppingCartPage;
import org.junit.jupiter.api.Test;

public class ShoppingCartPageTest extends BasePageTest {
MainPage mainPage;
SearchPage searchPage;

ShoppingCartPage shoppingCartPage;


    @Test
    void assertIfSelectingShippingFunctions(){
        mainPage=new MainPage(driver);
        searchPage=new SearchPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        mainPage.inputSearchItem("Duck");
        mainPage.clickButtonSearch();
        searchPage.clickButtonSelectList();


        searchPage.clickAllAddToCartButtons();

        searchPage.clickButtonCartDropDown();
        searchPage.clickViewCart();

        shoppingCartPage.clickEstimateShippingAndTaxes();
        shoppingCartPage.selectCountryLithuania();
        shoppingCartPage.setSelectInputCity();
        shoppingCartPage.clickGetQuotes();
        shoppingCartPage.clickShippingMethod();
        shoppingCartPage.clickApplyShipping();


    }
}
