package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AeroexpressPage extends Page{


    public static final String INPUT_DATA_FIELD = "//input[@placeholder='Выберите дату']";
    public static final String FIRST_STAGE_CONTINUE_BUTTON = "//button[@data-ti='navigate-to-passenger-page']";
    public static final String INPUT_MAIL_FIELD = "//input[@data-ti='email-input']";
    public static final String INPUT_PHONE_FIELD = "//input[@data-ti='phone-input']";
    public static final String INPUT_CHECKBOX_FIELD = "//input[@data-ti='agreement-input']";
    public static final String SECOND_STAGE_CONTINUE_BUTTON = "//button[@data-ti='navigate-to-payment']";
    public static final String TICKETS_RESULT_LIST_XPATH = "//*[@id=\"payment_form\"]";
    public static final String ERROR_MESSAGE = "Ошибка страницы оплаты";


    public AeroexpressPage(WebDriver driver) {
        super(driver);
    }

    public void fastAeroSearch(String date, String mail, String number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        enteringTripData(wait, date);
        enteringUserCred(wait, mail, number);
    }

    void enteringTripData (WebDriverWait wait, String date) {
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();

        String dateXpath = String.format("//div[@aria-label='%s']", date);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath)));
        dateElement.click();

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_STAGE_CONTINUE_BUTTON)));
        continueButton.click();
    }

    void enteringUserCred(WebDriverWait wait, String mail, String number) {
        WebElement mailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_MAIL_FIELD)));
        mailInput.click();
        mailInput.sendKeys(mail);

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_PHONE_FIELD)));
        phoneInput.click();
        phoneInput.sendKeys(number);

        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_CHECKBOX_FIELD)));
        checkbox.click();

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SECOND_STAGE_CONTINUE_BUTTON)));
        continueButton.click();
    }
}
