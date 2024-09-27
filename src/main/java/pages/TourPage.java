package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TourPage extends Page{

    public static final String INPUT_FROM_FIELD = "//input[@data-ti='departure_input']";
    public static final String INPUT_WHERE_FIELD = "//input[@data-ti='arrival_input']";
    public static final String INPUT_DATA_FIELD = "//input[@data-ti='date_input']";
    public static final String SEARCH_SCHEDULE_BUTTON = "//button[@data-ti='search_button']";


    public TourPage(WebDriver driver) {
        super(driver);
    }

    public void searchTour(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement tourFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        tourFromCityInput.click();
        WebElement cityChoose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Санкт-Петербург']/..")));
        cityChoose.click();

        WebElement aviaWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        aviaWhereCityInput.click();
        WebElement cityChooseTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Турция']")));
        cityChooseTo.click();

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Sep 28 2024']")));
        dateElement.click();
        dateInput.click();
//        WebElement submitDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-ti='close']")));
//        submitDate.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_SCHEDULE_BUTTON)));
        searchButton.click();
    }
}
