package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElectricTrainPage extends Page{

    public static final String INPUT_FROM_FIELD = "//*[@id=\"wrapper\"]/div[2]/div/form/div/div/div[1]/div/div[1]/div[1]/input";
    public static final String INPUT_WHERE_FIELD = "//*[@id=\"wrapper\"]/div[2]/div/form/div/div/div[3]/div/div[1]/div[1]/input";
    public static final String INPUT_DATA_FIELD = "//*[@id=\"wrapper\"]/div[2]/div/form/div/div/div[4]/div/div[1]/div/input";
    public static final String SEARCH_SCHEDULE_BUTTON = "//*[@id=\"wrapper\"]/div[2]/div/form/div/div/div[5]/button/span/span[3]";

    public ElectricTrainPage(WebDriver driver) {
        super(driver);
    }

    public void searchElectricSchedule(String CityFrom, String CityWhere){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement aviaFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        aviaFromCityInput.click();
        aviaFromCityInput.sendKeys(CityFrom);

        WebElement aviaWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        aviaWhereCityInput.click();
        aviaWhereCityInput.sendKeys(CityWhere);

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ui-state-default') and text()='21']")));
        dateElement.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_SCHEDULE_BUTTON)));
        searchButton.click();
    }
}
