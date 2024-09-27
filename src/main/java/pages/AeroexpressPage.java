package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AeroexpressPage extends Page{


    public static final String INPUT_DATA_FIELD = "//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div/div[1]/div/div/div/input";
    public static final String FIRST_STAGE_CONTINUE_BUTTON = "//button[@data-ti='navigate-to-passenger-page']";
    public static final String INPUT_MAIL_FIELD = "//input[@data-ti='email-input']";
    public static final String INPUT_PHONE_FIELD = "//input[@data-ti='phone-input']";
    public static final String INPUT_CHECKBOX_FIELD = "//input[@data-ti='agreement-input']";
    public static final String SECOND_STAGE_CONTINUE_BUTTON = "//button[@data-ti='navigate-to-payment']";

    public AeroexpressPage(WebDriver driver) {
        super(driver);
    }

    public void fastAeroSearch(String mail, String number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        firstStage(wait);
        secondStage(wait, mail, number);
    }

    void firstStage(WebDriverWait wait) {
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Sep 28 2024']")));
        dateElement.click();

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_STAGE_CONTINUE_BUTTON)));
        continueButton.click();
    }

    void secondStage(WebDriverWait wait, String mail, String number) {
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
