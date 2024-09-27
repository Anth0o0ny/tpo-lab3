package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends Page{

    public static final String SEND_CODE_FAST_AUTH_WINDOW_XPATH = "//span[text()='Проверьте почту ']";
    public static final String ERROR_MESSAGE_MAIL_XPATH = "//p[@data-ti-error='email']";
    public static final String ERROR_MESSAGE_PASSWORD_XPATH = "//p[@data-ti-error='authApi']";
    public static final String WINDOW_AFTER_AUTH_XPATH = "//div[@data-ti='search-form']";
    public static final String ERROR_MESSAGE = "Укажите корректные данные";

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement signInEmailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='email-field']")));
        signInEmailFieldInput.clear();
        signInEmailFieldInput.click();
        signInEmailFieldInput.sendKeys(email);

        WebElement signInPasswordFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='password-field']")));
        signInPasswordFieldInput.clear();
        signInPasswordFieldInput.click();
        signInPasswordFieldInput.sendKeys(password);

        WebElement signUpButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='submit-trigger']")));
        signUpButton.click();
    }

    public void signInFast(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement signInWithoutPassButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='login-by-email-or-phone-trigger']")));
        signInWithoutPassButton.click();

        WebElement signInEmailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='email-or-phone-field']")));
        signInEmailFieldInput.clear();
        signInEmailFieldInput.click();
        signInEmailFieldInput.sendKeys(email);

        WebElement signUpButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='submit-trigger']")));
        signUpButton.click();
    }
}
