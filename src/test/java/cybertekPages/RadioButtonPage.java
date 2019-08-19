package cybertekPages;

import utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonPage {
    public static void main(String[] args) throws Exception{
        String radioButtonsLocator = "input[type='radio']";

        WebDriver driver = BrowserUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> radioButtons = driver.findElements(By.cssSelector(radioButtonsLocator));
        for (WebElement radioButton: radioButtons){
            Thread.sleep(1000);
            if(!radioButton.isSelected())
                radioButton.click();
         //   System.out.println(radioButton.getText()+"-"+radioButton.isEnabled());
            System.out.println(radioButton.getAttribute("id"));
        }
        driver.quit();


    }
}
