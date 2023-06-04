import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class T00_TestBase {
    WebDriver driver;


    @BeforeTest
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\python\\FWD\\winjigo_website\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://phptravels.net/signup");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot.toPath(), new File("D:\\python\\FWD\\PhpTravels" + result.getName() + ".png").toPath());

        }
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
