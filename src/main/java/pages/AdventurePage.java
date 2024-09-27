package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdventurePage extends Page{

    public static final String INPUT_WHERE_FIELD = "//input[@data-ti='input']";

    public AdventurePage(WebDriver driver) {
        super(driver);
    }

    public void searchTour (String place) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement adventureWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        adventureWhereCityInput.click();
        adventureWhereCityInput.sendKeys(place);
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-ti='place']")));
        city.click();
    }

    public void doFilter(String priceTo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement direction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__ssr__verify-layout\"]/div[2]/div[4]/div/div/div/div[1]/div/div/div[2]/div/button")));
//        direction.click();
//        WebElement chooseDirection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Тбилиси, Грузия']/ancestor::div[contains(@class, 'o331109')]")));
//        chooseDirection.click();

        WebElement cost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__ssr__verify-layout\"]/div[2]/div[4]/div/div/div/div/div/div/div[4]/div/button")));
        cost.click();
        WebElement priceToField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='price_to_input']")));
        priceToField.click();
        priceToField.sendKeys(priceTo);

        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='apply_button']")));
        button.click();
    }
}
