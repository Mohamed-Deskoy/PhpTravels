import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_Login extends P00_PageBase{
    public P02_Login(WebDriver driver) {
        super(driver);
    }

    public WebElement email(){
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"email\"]"));
    }

    public WebElement password(){
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"password\"]"));
    }
    public WebElement login(){
        return driver.findElement(By.xpath("//button[@type=\"submit\"][@class=\"btn btn-default btn-lg btn-block effect ladda-button waves-effect\"]"));

    }
}
