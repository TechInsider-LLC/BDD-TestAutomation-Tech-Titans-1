package stepDefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    private static WebDriver driver;

   @Before
   public void setUp() {

    @Before
   public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @After
    public void tearDown() {
       driver.quit();
    }
    public static WebDriver getDriver() {
       return driver;
   }

    public static WebDriver getDriver(){
        return driver;
    }
}
