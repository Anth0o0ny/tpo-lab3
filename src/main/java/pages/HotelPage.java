package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HotelPage extends Page{

    public static final String INPUT_FROM_FIELD = "//span[text()='Куда хотите поехать?']/../input";
    public static final String DATE_FIELD = "//span[text()='Когда']/../input";

    public HotelPage(WebDriver driver) {
        super(driver);
    }

    public void searchHotel(String place, String dateFrom, String dateTo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement hotelFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        hotelFromCityInput.click();
        hotelFromCityInput.sendKeys(place);
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ti='dropdown-item'][1]")));
        city.click();


        WebElement hotelDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DATE_FIELD)));
        hotelDate.click();
        String dateFromXpath = String.format("//div[@aria-label='%s']", dateFrom);
        WebElement dateElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateFromXpath)));
        dateElement1.click();
        String dateToXpath = String.format("//div[@aria-label='%s']", dateTo);
        WebElement dateElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateToXpath)));
        dateElement2.click();


        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='order-button']")));
        searchButton.click();
    }
}
