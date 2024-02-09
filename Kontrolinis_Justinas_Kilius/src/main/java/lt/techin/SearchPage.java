package lt.techin;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@class='button-group']/button[contains(@aria-label, 'Add to Cart')]")
    WebElement buttonsAddToCart;

    @FindBy(xpath = "//button[@id='button-list']")
    WebElement buttonSelectList;

    @FindBy(xpath = "//div[@class='dropdown d-grid']/button")
    WebElement buttonCartDropdown;

    @FindBy(xpath = "//div[@class='dropdown d-grid']/ul")
    WebElement dropdownCart;

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

    public void clickAllAddToCartButtons(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //wait.until(ExpectedConditions.visibilityOf());
       // buttonsAddToCart.stream().forEach(WebElement::click);

        Actions actions = new Actions(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class='button-group']/button[contains(@aria-label, 'Add to Cart')]"));
        for(WebElement i:button){
            actions.moveToElement(i).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(i));
            actions.click(i).build().perform();

        }
    }

    public void addProductToCart(){

    }

    public void clickViewCart(){
        buttonViewCart.click();
    }

    public void clickButtonCartDropDown(){
        buttonCartDropdown.click();
    }




}
