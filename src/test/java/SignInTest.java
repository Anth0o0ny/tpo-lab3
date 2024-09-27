import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class SignInTest {
    public static final String CORRECT_MAIL = "Pushkin_A.2003@list.ru";
    public static final String INCORRECT_MAIL = "jgf";
    public static final String CORRECT_PASSWORD = "12345678";
    public static final String INCORRECT_PASSWORD = "111";

    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void signInFastWithCorrectData(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.signInFast(CORRECT_MAIL);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement sendCodeForSignInMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@class='zs2K2sscD_kMthNV']/..")));
            Assertions.assertNotNull(sendCodeForSignInMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signInWithIncorrectMail(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.signIn(INCORRECT_MAIL, CORRECT_PASSWORD);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@data-ti-error='email']")));
            Assertions.assertNotNull(errorMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signInWithIncorrectPassword(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.signIn(CORRECT_MAIL, INCORRECT_PASSWORD);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@data-ti-error='authApi']")));
            Assertions.assertNotNull(errorMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signInWithCorrectData(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.signIn(CORRECT_MAIL, CORRECT_PASSWORD);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='xhYJ1HmBz43ZlJF7']")));
            assert tickets.size() > 0 : "Укажите корректные данные";
        });
        drivers.forEach(WebDriver::quit);
    }
}
