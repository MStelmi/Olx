package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ResultPage;

public class ResultPage extends ResultPage{

    @FindBy(xpath="//table[@summary='Ogłoszenia']")
    WebElement results;

    public ResultPage (WebElement driver){
        super(driver);
    }

    public boolean verifyResults(String result){
        String resultsText = results.getText().toLowerCase();
        return resultsText.contains(result);
    }
}
