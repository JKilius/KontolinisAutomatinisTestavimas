package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='narbar-menu']/ul/li/a[contains(text(), 'QA')]")
    WebElement navigationButtonQA;

    @FindBy(xpath = "//div[@id='content']/h2")
    WebElement pageHeadLine;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNavigationButton(){
        navigationButtonQA.click();
    }


    public boolean isPageHeadlineCorrect(){
       return pageHeadLine.getText().contains("QA");
    }
}
