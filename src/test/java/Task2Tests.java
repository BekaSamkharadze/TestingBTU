import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task2Tests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testProgressBar() {
        driver.navigate().to("https://demoqa.com/progress-bar");
        WebElement startButton = driver.findElement(By.id("startStopButton"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBar = driver.findElement(By.id("progressBar"));
        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));

        System.out.println("100%");
    }

    @Test
    public void testDropdownCheckboxesRadioButtons() {
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement programmingLanguageDropdown = driver.findElement(By.id("dropdowm-menu-1"));
        programmingLanguageDropdown.click();

        WebElement javascriptOption = driver.findElement(By.xpath("//option[@value='javascript']"));
        javascriptOption.click();

        String selectedOptionText = programmingLanguageDropdown.getAttribute("value");
        Assert.assertEquals(selectedOptionText, "javascript");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        WebElement purpleRadioButton = driver.findElement(By.xpath("//input[@value='purple']"));
        purpleRadioButton.click();

        WebElement orangeOption = driver.findElement(By.xpath("//option[@value='orange']"));
        Assert.assertFalse(orangeOption.isEnabled());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
