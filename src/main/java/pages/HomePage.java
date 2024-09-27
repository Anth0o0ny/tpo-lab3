package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToElectricTicketsPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Электрички']/..)[2]")));
        icon.click();
    }

    public void goToHotelPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Отели']/ancestor::button")));
        icon.click();
    }

    public void goToAdventurePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Приключения']/..")));
        icon.click();
    }

    public void goToTourPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Туры']/ancestor::a[@type='link']")));
        icon.click();
    }

    public void goToAeroexpressPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Аэроэкспрессы']/../span[1]")));
        icon.click();
    }

    public void openLoginWindow(WebDriverWait wait) {
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[.//span[text()='Войти']])[1]")));
        icon.click();
    }

}
