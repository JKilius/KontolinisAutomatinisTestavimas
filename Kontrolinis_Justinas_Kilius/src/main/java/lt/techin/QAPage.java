package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class QAPage extends BasePage{

    @FindBy(css = "button#button-list")
    WebElement buttonSelectShowList;

    @FindBy(xpath = "//div[@class='description']")
    List<WebElement> productDescription;

    @FindBy(xpath = "//div[@class='description']/h4/a")
    List<WebElement> productName;

    @FindBy(xpath = "//div[@class='description']/h4/a[contains(text(), 'Code Confusion Raccoon')]")
    WebElement linkToRacoonItem;

    @FindBy(xpath = "//div[@class='description']/h4/a[contains(text(), 'Debug Duck')]")
    WebElement linkToDuckItem;

    @FindBy(xpath = "//div[@class='description']/h4/a[contains(text(), 'Java Genius Duck')]")
    WebElement linkToGeniusDuckItem;

    @FindBy(xpath = "//div[@class='description']/h4/a[contains(text(), 'Code Calm pills')]")
    WebElement linkToCalmPillsItem;

    public QAPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonSelectShowList(){
        buttonSelectShowList.click();
    }

    public List<String> getProductDescriptions(){
      return   productDescription.stream().map(WebElement::getText).toList();
    }

    public void clickRacoon(){
        linkToRacoonItem.click();
    }

    public void clickDuck(){
        linkToDuckItem.click();
    }

    public void clickGeniusDuck(){
        linkToGeniusDuckItem.click();
    }

    public void clickPills(){
        linkToCalmPillsItem.click();
    }

    public void clickSelectedItemByName(String itemName){
       productName.stream().filter(e->e.getText().contains(itemName)).findFirst().ifPresent(WebElement::click);
    }

    public boolean isProductNameInTheWebSite(String item){
        return productName.stream().map(WebElement::getText).toList().contains(item);
    }


}
