import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingUpReg {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.ebanq.com/log-in");
        driver.findElement(By.cssSelector("[href=\"/sign-up\"]")).click();
        driver.findElement(By.cssSelector("#first-n-input")).sendKeys("demo");
        driver.findElement(By.cssSelector("#last-name-input")).sendKeys("demo");
        driver.findElement(By.cssSelector("#username")).sendKeys("demo");
        driver.findElement(By.cssSelector("#em")).sendKeys("Demo@gmail.com");
        driver.findElement(By.cssSelector("#confirm-em")).sendKeys("Demo@gmail.com");
        driver.findElement(By.cssSelector("#no-autocomplete")).sendKeys("Demoebanq1$");
        driver.findElement(By.cssSelector("#confirm-ps")).sendKeys("Demoebanq1$");
        driver.findElement(By.cssSelector("#securityQuestionId")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#a9bc3ab1e012 .ng-option-label"),"Your"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("#sequrityQuestionAnswer")).sendKeys("demo");
        driver.findElement(By.cssSelector(".checkbox-checkmark")).click();
        driver.findElement(By.cssSelector(".checkbox-checkmark")).submit();
    }
}
