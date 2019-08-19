package cybertekPages;

import utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPage {
    public static void main(String[] args) throws InterruptedException {
//        String checkBox1Locator = "input[type='checkbox']:nth-of-type(1)";
//        String checkBox2Locator = "input[type='checkbox']:nth-of-type(2)";
          String checkBoxesLocator = "input[type='checkbox']";

          WebDriver driver = BrowserUtils.getDriver("chrome");
          driver.manage().window().maximize();
          driver.get("http://practice.cybertekschool.com/checkboxes");
//        driver.findElement(By.cssSelector(checkBox1Locator)).click();
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector(checkBox2Locator)).click();
//        Thread.sleep(2000);
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(checkBoxesLocator));
        for (WebElement checkbox: checkBoxes){
            Thread.sleep(3000);
            if(!checkbox.isSelected())
                checkbox.click();
        }

        driver.quit();

    }

}
