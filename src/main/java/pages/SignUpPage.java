package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends Page{

    public static final String SEND_CODE_REGISTRATION_WINDOW_XPATH = "//div[@data-ti-screen='registration-email-code-code']";
    public static final String ERROR_MESSAGE_XPATH = "//p[@data-ti-error='email']";

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement registrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='registration-link']")));
        registrationButton.click();

        WebElement regEmailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='email-field']")));
        regEmailFieldInput.clear();
        regEmailFieldInput.click();
        regEmailFieldInput.sendKeys(email);

        WebElement agreementCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-ti='agreement-checkbox']")));
        agreementCheckbox.click();

        WebElement signUpButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='submit-trigger']")));
        signUpButton.click();
    }
}
