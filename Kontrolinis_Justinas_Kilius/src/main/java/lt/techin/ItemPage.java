package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ItemPage extends BasePage {

    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement inputQuantity;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//div[@class='dropdown d-grid']/button")
    WebElement buttonCartDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-end p-2 show']")
    WebElement dropdownCartInfo;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clearInputQuantity() {
        inputQuantity.clear();
    }

    public void inputRequiredQuantity(String quantity) {
        inputQuantity.sendKeys(quantity);
    }

    public void clickButtonAddToCart(){
        buttonAddToCart.click();
    }

    


}
