import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SignInPage;

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
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.openLoginWindow(wait);

            SignInPage signInPage = new SignInPage(webDriver);
            signInPage.signInFast(CORRECT_MAIL);

            WebElement sendCodeForSignInMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignInPage.SEND_CODE_FAST_AUTH_WINDOW_XPATH)));
            Assertions.assertNotNull(sendCodeForSignInMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signInWithIncorrectMail(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.openLoginWindow(wait);

            SignInPage signInPage = new SignInPage(webDriver);
            signInPage.signIn(INCORRECT_MAIL, CORRECT_PASSWORD);


            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignInPage.ERROR_MESSAGE_MAIL_XPATH)));
            Assertions.assertNotNull(errorMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signInWithIncorrectPassword(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.openLoginWindow(wait);

            SignInPage signInPage = new SignInPage(webDriver);
            signInPage.signIn(CORRECT_MAIL, INCORRECT_PASSWORD);


            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignInPage.ERROR_MESSAGE_PASSWORD_XPATH)));
            Assertions.assertNotNull(errorMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signInWithCorrectData(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.openLoginWindow(wait);

            SignInPage signInPage = new SignInPage(webDriver);
            signInPage.signIn(CORRECT_MAIL, CORRECT_PASSWORD);


            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SignInPage.WINDOW_AFTER_AUTH_XPATH)));
            assert tickets.size() > 0 : SignInPage.ERROR_MESSAGE;
        });
        drivers.forEach(WebDriver::quit);
    }
}
