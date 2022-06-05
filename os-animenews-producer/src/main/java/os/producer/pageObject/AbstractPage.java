package os.producer.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import os.producer.utils.CustomDriver;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    private WebDriverWait wait = new WebDriverWait(CustomDriver.getDriver(), Duration.ofSeconds(10));

    protected void proceedToPage(){
        CustomDriver.getDriver().get("https://www.cbr.com/category/anime-news/");
    }

    WebElement getElement(By locator){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator){
        List<WebElement> webElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return webElements;
    }
}
