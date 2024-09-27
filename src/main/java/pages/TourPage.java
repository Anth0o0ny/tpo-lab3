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

    public void searchTour(String cityFrom, String cityWhere, String date){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement tourFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        tourFromCityInput.click();

        String cityFromXpath = String.format("//span[text()='%s']/..", cityFrom);
        WebElement cityChoose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityFromXpath)));
        cityChoose.click();

        WebElement aviaWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        aviaWhereCityInput.click();

        String cityWhereXpath = String.format("//div[text()='%s']", cityWhere);
        WebElement cityChooseTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityWhereXpath)));
        cityChooseTo.click();

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();

        String dateXpath = String.format("//div[@aria-label='%s']", date);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath)));
        dateElement.click();
        dateInput.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_SCHEDULE_BUTTON)));
        searchButton.click();
    }
}
