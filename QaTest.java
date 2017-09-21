import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class QaTest {
    private WebDriver driver;
    //before
    @Before
    public void setUp(){
        //place for code executed before each test.
        System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");
        this.driver = new FirefoxDriver();

        this.driver.manage()
                .timeouts()
                .implicitlyWait(5 , TimeUnit.SECONDS );

    }

    @Test
    public void testLogin_validCredential_expectedNavigateToProfile(){
        //test methods.
        this.driver.get("https://softuni.bg/");

        WebElement loginLink
                = this.driver.findElement(By.cssSelector(".login-btn-wrap > a:nth-child(1)"));
        loginLink.click();

        WebElement usernameField
                = this.driver
                .findElement(By.xpath("/html/body/main/div[2]/div/div[3]/div/form/div[1]/div/input"));
        usernameField.sendKeys("xgotcx");

        WebElement passwordField
                = this.driver
                .findElement(By.xpath("/html/body/main/div[2]/div/div[3]/div/form/div[2]/div/input"));
        passwordField.sendKeys("8zorito1");

        WebElement loginButton
                = this.driver
                .findElement(By.cssSelector("input.btn"));

        loginButton.click();

    }
    @Test
    public void testRegister_enterValidUsername_expectedLogin(){
        //test methods.

    }

    @After
    public void tearDown(){
        //what happen after each test.
        this.driver.quit();

    }

}
