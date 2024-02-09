package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[@class='description']")
    List<WebElement> textItemDescription;

    @FindBy(css = ".fa-shopping-cart")
    //@FindBy(xpath = "//div[@class='button-group']/button[1]")
   // @FindBy(xpath = "//div[@class='button-group']/button[contains(@aria-label, 'Add to Cart')]")
    List<WebElement> buttonsAddToCart;

    @FindBy(xpath = "//button[@id='button-list']")
    WebElement buttonSelectList;

    @FindBy(xpath = "//div[@class='dropdown d-grid']/button")
    WebElement buttonCartDropdown;


    @FindBy(xpath = "//div[@class='dropdown d-grid']/strong[contains(@text(), 'View Cart')]")
    WebElement buttonViewCart;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonSelectList(){
        buttonSelectList.click();
    }

    public List<String> getFoundItemsDescriptionText(){
        return textItemDescription.stream().map(WebElement::getText).toList();
    }

    public void clickAllAddToCartButtons() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Actions actions = new Actions(driver);
     //   List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='button-group']/button[contains(@aria-label, 'Add to Cart')]"));
        buttonsAddToCart.forEach(WebElement::click);
        //        for(WebElement i:button){
//            actions.moveToElement(i).build().perform();
//            wait.until(ExpectedConditions.elementToBeClickable(i));
//            actions.click(i).build().perform();
//
//        }
//        Actions actions = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        for (WebElement button : buttonsAddToCart) {
//            // Perform hover action using JavaScript
//            js.executeScript("arguments[0].dispatchEvent(new Event('mouseover'))", button);
//
//            // Wait for the button to be clickable
//            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
//        }

    }

    public void clickViewCart(){
        buttonViewCart.click();
    }

    public void clickButtonCartDropDown(){
        buttonCartDropdown.click();
    }




}
