package pl.olx.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    final Integer shortWaitTime = 5;
    final Integer longWaitTime = 30;
    protected WebDriver driver;
    protected static WebDriverWait wait;
    public AbstractPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, longWaitTime);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, longWaitTime), this);
    }
    public void waitForElement(WebElement e){
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void click(WebElement e){
        waitForElement(e);
        wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }
}
