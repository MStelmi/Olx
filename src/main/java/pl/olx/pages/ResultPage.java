package pl.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends AbstractPage{

    @FindBy(xpath = "//table[@summary='Ogłoszenia']")
    WebElement results;

    public ResultPage (WebDriver driver){
        super(driver);
    }

    public boolean verifyResults(String result){
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOf(results));
        String resultsText = results.getText().toLowerCase();
        System.out.println(resultsText);
        return resultsText.contains(result);
    }
}
