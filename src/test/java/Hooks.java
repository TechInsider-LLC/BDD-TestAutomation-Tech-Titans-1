import org.junit.Before;

import java.time.Duration;

public class Hooks {
   @Before
   public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
