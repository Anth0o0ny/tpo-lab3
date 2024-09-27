package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page{

    public static final String INPUT_FROM_FIELD = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/label/input";
    public static final String INPUT_WHERE_FIELD = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/label/input";
    public static final String INPUT_DATA_FIELD = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div/label/input";

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void searchTicket(String iconPath, String CityFrom, String CityWhere, String buttonPath ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconPath)));
        icon.click();

        WebElement aviaFromCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FROM_FIELD)));
        aviaFromCityInput.click();
        aviaFromCityInput.sendKeys(CityFrom);
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Санкт-Петербург']/ancestor::div[contains(@class, 'cell_0f2e59da')]")));
        city.click();

        WebElement aviaWhereCityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_WHERE_FIELD)));
        aviaWhereCityInput.click();
        aviaWhereCityInput.sendKeys(CityWhere);
        WebElement city2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Москва']/ancestor::div[contains(@class, 'cell_0f2e59da')]")));
        city2.click();

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_DATA_FIELD)));
        dateInput.click();
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Sep 21 2024']")));
        dateElement.click();
        WebElement chooseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-ti='order-button' and @variant='primary']")));
        chooseButton.click();

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonPath)));
        searchButton.click();
    }

    public void searchAviaTickets(String cityFrom, String cityWhere){
        final String icon = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/button[1]";
        final String searchButton = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/button";
        searchTicket(icon, cityFrom, cityWhere, searchButton);
    }

    public void searchTrainTickets(String cityFrom, String cityWhere){
        final String icon = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/button[2]";
        final String ticketSearchButton = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/button";
        searchTicket(icon, cityFrom, cityWhere, ticketSearchButton);
    }

    public void searchBusTickets(String cityFrom, String cityWhere){
        final String icon = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/button[3]";
        final String ticketSearchButton = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/button";
        searchTicket(icon, cityFrom, cityWhere, ticketSearchButton);
    }

    public void goToElectricTicketsPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/a[2]")));
        icon.click();
    }

    public void goToHotelPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/a[1]")));
        icon.click();
    }

    public void goToAdventurePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/a[3]")));
        icon.click();
    }

    public void goToTourPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/a[4]")));
        icon.click();
    }

    public void goToAeroexpressPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[1]/a[5]")));
        icon.click();
    }

    public void goToProfilePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Открыть меню']")));
        icon.click();
    }

    public void signInFast(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        openLoginWindow(wait);

        WebElement signInWithoutPassButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='login-by-email-or-phone-trigger']")));
        signInWithoutPassButton.click();

        WebElement signInEmailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='email-or-phone-field']")));
        signInEmailFieldInput.clear();
        signInEmailFieldInput.click();
        signInEmailFieldInput.sendKeys(email);

        WebElement signUpButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='submit-trigger']")));
        signUpButton.click();
    }

    public void signIn(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        openLoginWindow(wait);

        WebElement signInEmailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='email-field']")));
        signInEmailFieldInput.clear();
        signInEmailFieldInput.click();
        signInEmailFieldInput.sendKeys(email);

        WebElement signInPasswordFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='password-field']")));
        signInPasswordFieldInput.clear();
        signInPasswordFieldInput.click();
        signInPasswordFieldInput.sendKeys(password);

        WebElement signUpButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='submit-trigger']")));
        signUpButton.click();
    }

    public void signUp(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement registrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='registration-link']")));
        registrationButton.click();

        WebElement regEmailFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ti='email-field']")));
        regEmailFieldInput.clear();
        regEmailFieldInput.click();
        regEmailFieldInput.sendKeys(email);

        WebElement agreementCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-ti='agreement-checkbox']")));
        agreementCheckbox.click();

        WebElement signUpButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ti='submit-trigger']")));
        signUpButton.click();
    }



    public void openLoginWindow(WebDriverWait wait) {
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'contentListWithAddon300_1fe1996f')]/../..")));
        icon.click();
    }

}
