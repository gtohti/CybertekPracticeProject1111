package cybertekPages;

import utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormPage {
    public static void main(String[] args) throws Exception {
        String firstNameLocator = "input[name='firstname']";
        String lastNameLocator = "input[name='lastname']";
        String userNameLocator = "input[name='username']";
        String emailLocator = "input[name='email']";
        String passwordLocator = "input[name='password']";
        String phoneNumberLocator = "input[name='phone']";
        String maleLocator = "input[value='male']";
        String femaleLocator = "input[value='female']";
        String otherGenderLocator = "input[value='other']";
        String birthDayLocator = "input[name='birthday']";
        String departmentLocator = "select[name='department']";
        String jobTitleLocator = "select[name='job_title']";
        String proLanguageCLocator = "#inlineCheckbox1";
        String proLanguageJavaLocator = "#inlineCheckbox2";
        String proLanguageJSLocator = "#inlineCheckbox3";
        String signUpLocator = "#wooden_spoon";


        WebDriver driver = BrowserUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.cssSelector(firstNameLocator)).sendKeys("Gheyret");
        driver.findElement(By.cssSelector(lastNameLocator)).sendKeys("Tohti");
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("gtohti");
        driver.findElement(By.cssSelector(emailLocator)).sendKeys("example@gmail.com");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("1234abcd");
        driver.findElement(By.cssSelector(phoneNumberLocator)).sendKeys("123-456-7890");
        driver.findElement(By.cssSelector(maleLocator)).click();
        driver.findElement(By.cssSelector(birthDayLocator)).sendKeys("01/01/1970");
        Select departmentSelect = new Select(driver.findElement(By.cssSelector(departmentLocator)));
        departmentSelect.selectByVisibleText("MCR");
        Select jobTitleSelect = new Select(driver.findElement(By.cssSelector(jobTitleLocator)));
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(By.cssSelector(signUpLocator)).click();

        Thread.sleep(3000);
        driver.quit();

    }
    }

