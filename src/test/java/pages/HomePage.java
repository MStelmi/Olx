package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

public class HomePage extends AbstractPage {

    @FindBy(linkText="Motoryzacja")
    WebElement categoryMotoryzacja;

    @FindBy(linkText="Samochody osobowe")
    WebElement subcategorySamochodyOsobowe;

    public HomePage (WebDriver driver) {
        super(driver);
    }

    public void clickMotoryzacja() {
        categoryMotoryzacja.click();
    }

    public void clickSamochodyOsobowe() {
        subcategorySamochodyOsobowe.click();
    }
}

