package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//div[@class='accordion-item']/h2/button[contains(text(), 'Estimate Shipping & Taxes')]")
    WebElement buttonEstimateShippingAndTaxes;

    @FindBy(xpath = "//button[@id='button-quote']")
    WebElement buttonGetQuote;

    @FindBy(xpath = "//button[@id='button-shipping-method']")
    WebElement buttonApplyShipping;

    @FindBy(xpath = "//select[@id='input-country']")
    Select selectInputCountry;

    @FindBy(xpath = "//select[@id='input-zone']")
    Select selectInputCity;

    @FindBy(xpath = "//input[contains(@name, 'shipping_method')]")
    WebElement buttonShippingMethod;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickEstimateShippingAndTaxes(){
        buttonEstimateShippingAndTaxes.click();
    }

    public void selectCountryLithuania(){
        selectInputCountry.selectByVisibleText("Lithuania");
    }

    public void setSelectInputCity(){
        selectInputCity.selectByVisibleText("Vilnius");
    }

    public void clickGetQuotes(){
        buttonGetQuote.click();
    }

    public void clickShippingMethod(){
        buttonShippingMethod.click();
    }

    public void clickApplyShipping(){
        buttonApplyShipping.click();
    }
}
