package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    private static final Logger logger = LogManager.getLogger();

    public static void verifyEquals(String expectedResult, String actualResult){
        if (expectedResult.equals(actualResult))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");
        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result " + actualResult);
    }
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch(Exception e){
            logger.error(e);
            System.out.println(e.getMessage());
        }
    }
    public static void openPage(String page, WebDriver driver){
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for (WebElement example: listOfExamples){
            if(example.getText().contains(page))
                example.click();
            break;
        }
    }
    public static void verifyIsDisplayed(WebElement element){
        if(element.isDisplayed()){
            System.out.println("PASSED");
            System.out.println(element.getText() + ": is visible");
        }else{
            System.out.println("FAILED");
            System.out.println(element.getText() + ": is not visible");
        }
    }
    public static void clickWithWait(WebDriver driver, By by, int attempts){
        int counter = 0;
        while(counter < attempts){
            try {
                driver.findElement(by).click();
                break;
            }catch (WebDriverException e){
                logger.error((e));
                logger.error("Attempt :: " + ++counter);
                waitPlease(1);
            }
        }

    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    public static void clickWithWait(By by, int attempts){
        int counter = 0;
        while(counter < attempts) {
            try {
                clickWithJS(Driver.getDriver().findElement(by));
                break;
            }catch (WebDriverException e) {
                logger.error(e);
                logger.error("Attempt :: " + ++counter)
                waitPlease(1);
            }
        }
    }
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for(String handle: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);

    }
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    public static List<String> getElementText(List<WebElement> list){
        List<String> elementTexts = new ArrayList<>();
        for(WebElement el : list){
            if(!el.getText().isEmpty()){
                elementTexts.add(el.getText());
            }
        }
        return elementTexts;
    }

}
