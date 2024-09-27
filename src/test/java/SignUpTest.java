import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.HotelPage;

import java.time.Duration;
import java.util.List;

public class SignUpTest {
    public static final String CORRECT_MAIL = "pushkinanton1313@gmail.com";
    public static final String INCORRECT_MAIL = "jgf";

    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void signUpWithCorrectData(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.signUp(CORRECT_MAIL);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement sendCodeForRegisterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ti-screen='registration-email-code-code']")));
            Assertions.assertNotNull(sendCodeForRegisterMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signUpWithIncorrectData(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.signUp(INCORRECT_MAIL);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@data-ti-error='email']")));
            Assertions.assertNotNull(errorMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }
}
