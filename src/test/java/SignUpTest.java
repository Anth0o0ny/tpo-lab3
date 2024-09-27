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
import pages.SignUpPage;

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
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.openLoginWindow(wait);

            SignUpPage signUpPage = new SignUpPage(webDriver);
            signUpPage.signUp(CORRECT_MAIL);

            WebElement sendCodeForRegisterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPage.SEND_CODE_REGISTRATION_WINDOW_XPATH)));
            Assertions.assertNotNull(sendCodeForRegisterMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }

    @Test
    public void signUpWithIncorrectData(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.openLoginWindow(wait);

            SignUpPage signUpPage = new SignUpPage(webDriver);
            signUpPage.signUp(INCORRECT_MAIL);


            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPage.ERROR_MESSAGE_XPATH)));
            Assertions.assertNotNull(errorMessage.getText());
        });
        drivers.forEach(WebDriver::quit);
    }
}
