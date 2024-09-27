package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HotelPage extends Page{

    public static final String INPUT_FROM_FIELD = "//input[@data-ti='hotels-destination-input']";

    public HotelPage(WebDriver driver) {
        super(driver);
    }

    public void searchHotel(String place) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement aviaFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        aviaFromCityInput.click();
        aviaFromCityInput.sendKeys(place);
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ti-suggest-item='Москва']")));
        city.click();


        WebElement dateElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sun Sep 22 2024']")));
        dateElement1.click();
        WebElement dateElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Sep 28 2024']")));
        dateElement2.click();


        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='order-button']")));
        searchButton.click();
    }
}
