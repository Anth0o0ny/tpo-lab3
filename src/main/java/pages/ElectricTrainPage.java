package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElectricTrainPage extends Page{

    public static final String INPUT_FROM_FIELD = "//input[@placeholder='Откуда']";
    public static final String INPUT_WHERE_FIELD = "//input[@placeholder='Куда']";
    public static final String INPUT_DATA_FIELD = "//input[@placeholder='Дата']";
    public static final String SEARCH_SCHEDULE_BUTTON = "//span[@class='inner_wrapper']/span[3]";


    public ElectricTrainPage(WebDriver driver) {
        super(driver);
    }

    public void searchElectricSchedule(String CityFrom, String CityWhere, String date){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement aviaFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        aviaFromCityInput.click();
        aviaFromCityInput.sendKeys(CityFrom);

        WebElement aviaWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        aviaWhereCityInput.click();
        aviaWhereCityInput.sendKeys(CityWhere);

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();

        String dateXpath = String.format("//a[contains(@class, 'ui-state-default') and text()='%s']", date);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath)));
        dateElement.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_SCHEDULE_BUTTON)));
        searchButton.click();
    }
}
