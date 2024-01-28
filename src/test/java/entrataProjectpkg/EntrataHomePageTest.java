package entrataProjectpkg;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

class EntrataHomePageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();   
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        driver.get("https://www.entrata.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority=1)
    private void testHomepageLoad() {
        driver.get("https://www.entrata.com/");
        driver.manage().window().maximize();
        softAssert.assertEquals(driver.getTitle(), "Property Management Software | Entrata", "Homepage title mismatch");
        softAssert.assertAll();
    }

    @Test(priority=2)
    private void testFooterPresence() {
        driver.get("https://www.entrata.com/");
        WebElement footer = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/footer"));
        softAssert.assertTrue(footer.isDisplayed(), "Footer is not displayed");
        softAssert.assertAll();
    }

    @Test(priority=3)
    private void testFooterSpecificPhoneNumber() {
        driver.get("https://www.entrata.com/");
        WebElement footerPhoneNumber = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/footer/div[2]/div[1]/div/div[2]"));
        String expectedPhoneNumber = "Sales: 814.747.5807";
        softAssert.assertEquals(footerPhoneNumber.getText(), expectedPhoneNumber, "Footer phone number does not match");
        softAssert.assertAll();
    }

    @Test(priority=4)
    private void testWatchDemoButtonRedirection() {
        driver.get("https://www.entrata.com/");
        WebElement watchDemoButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div[2]/a"));
        watchDemoButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div/span/form")));
        WebElement formElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div/span/form"));
        softAssert.assertTrue(formElement.isDisplayed(), "Form is not present on the redirected page");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}