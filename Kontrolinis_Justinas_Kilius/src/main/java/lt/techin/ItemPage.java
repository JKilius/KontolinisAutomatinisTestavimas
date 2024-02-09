package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ItemPage extends BasePage {

    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement inputQuantity;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//div[@class='dropdown d-grid']/button")
    WebElement buttonCartDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-end p-2 show']")
    WebElement dropdownCartInfo;

    @FindBy(xpath = "//div[@id='alert']")
    WebElement alertMessage;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clearInputQuantity() {
        inputQuantity.clear();
    }

    public void inputRequiredQuantity(String quantity) {
        inputQuantity.sendKeys(quantity);
    }

    public String getQuantity(){
        return inputQuantity.getAttribute("value");
    }

    public void clickButtonAddToCart(){
        buttonAddToCart.click();
    }

    public void clickCartDropdown(){
        try {
            WebElement button = driver.findElement(By.xpath("//div[@class='dropdown d-grid']/button"));
            button.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath("//div[@class='dropdown d-grid']/button"));
            button.click();
        }
    }

    public String getCartInfo(){
        return dropdownCartInfo.getText();
    }

    public boolean isAlertMessageVisible(){
        return alertMessage.isDisplayed();
    }

    public String textAlertMessage(){
        return alertMessage.getText();
    }

    public String generateRandomNumber(){
        int num = (int)(Math.random()*20);
        return String.valueOf(num);
    }



}
