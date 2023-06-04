import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T01_SignUp extends T00_TestBase {
    P00_PageBase pageBase;
    P01_SignUp signUp;
    P02_Login login;
    @Test(priority = 0)
    public void validRegister() {
        pageBase = new P00_PageBase(driver);
        signUp = new P01_SignUp(driver);
        login = new P02_Login(driver);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(3));

        signUp.fristName().sendKeys("Mohamed");
        signUp.lastName().sendKeys("Ahmed");
        signUp.phone().sendKeys("201111156231");
        signUp.email().sendKeys("mmmm@gmail.com");
        signUp.passWord().sendKeys("Password123");

        //recaptcha can't be automated
        WebElement iframe = driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkbox);
        driver.switchTo().defaultContent();
        //wait and solve the recaptcha manually util the signup button clickable
        wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id=\"button\"]"))));
        signUp.signupBut().click();

    }
    @Test(priority = 1)
    public void ValidLogin() {
        pageBase = new P00_PageBase(driver);
        login = new P02_Login(driver);

        login.email().sendKeys("mmmm@gmail.com");
        login.password().sendKeys("Password123");
        login.login().click();


        String actualpagetitle = driver.getTitle();
        System.out.println(actualpagetitle);

        String expected_pagetitle = "Dashboard - PHPTRAVELS";

        SoftAssert soft;
        soft = new SoftAssert();
        soft.assertEquals(actualpagetitle, expected_pagetitle, "login successfully");
        System.out.println("login successfully");

        Assert.assertEquals(actualpagetitle, expected_pagetitle, "login successfully");

    }
}
