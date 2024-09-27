package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class TicketSearchPage extends Page{

    public static final String INPUT_FROM_FIELD = "//span[text()='Откуда']/../input";
    public static final String INPUT_WHERE_FIELD = "//span[text()='Куда']/../input";
    public static final String INPUT_DATA_FIELD = "//span[text()='Когда']/../input";

    public TicketSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchTicket(String iconPath, String сityFrom, String сityWhere, String data, String buttonPath ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconPath)));
        icon.click();

        WebElement aviaFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        aviaFromCityInput.click();
        aviaFromCityInput.sendKeys(сityFrom);
        String cityFromXpath = String.format("//span[text()='%s']/ancestor::div[@data-ti='dropdown-item']", сityFrom);
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityFromXpath)));
        city.click();

        WebElement aviaWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        aviaWhereCityInput.click();
        aviaWhereCityInput.sendKeys(сityWhere);
        String cityWhereXpath = String.format("//span[text()='%s']/ancestor::div[@data-ti='dropdown-item']", сityWhere);
        WebElement city2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityWhereXpath)));
        city2.click();

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();

        String dataXpath = String.format("//div[@aria-label='%s']", data);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dataXpath)));
        dateElement.click();
        WebElement chooseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-ti='order-button' and @variant='primary']")));
        chooseButton.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonPath)));
        searchButton.click();
    }
}
