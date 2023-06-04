import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_SignUp extends P00_PageBase {

    public P01_SignUp(WebDriver driver) {
        super(driver);
    }

    public WebElement fristName() {
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"first_name\"]"));
    }
  public  WebElement lastName(){
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"last_name\"]"));

  }

  public WebElement phone(){
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"phone\"]"));
  }

  public WebElement email(){
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"email\"]"));
  }

  public WebElement passWord(){
        return driver.findElement(By.xpath("//input[@class=\"form-control\"][@name=\"password\"]"));

  }
public WebElement signupBut(){
        return driver.findElement(By.xpath("//button[@id=\"button\"]"));
}
}
