package cybertekPages;

import utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    static WebDriver driver = BrowserUtils.getDriver("chrome");
    public static void main(String[] args) throws Exception {
        selectByTextTest();

    }
    public static void setup() throws Exception{

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    public static void selectByTextTest() throws Exception{
        setup();
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");
        Thread.sleep(2000);
    }
    public static void dateOfBirth(){
      //  driver.findElements(


    }
        public static void selectState(){

    }
}

