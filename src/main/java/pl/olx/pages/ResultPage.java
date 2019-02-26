package pl.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends AbstractPage{

    @FindBy(xpath="//table[@summary='Ogłoszenia']")
    WebElement results;

    public ResultPage (WebDriver driver){
        super(driver);
    }

    public boolean verifyResults(String result){
        String resultsText = results.getText().toLowerCase();
        return resultsText.contains(result);
    }
}
