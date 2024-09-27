package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page{

    public static final String INPUT_FROM_FIELD = "//span[text()='Откуда']/../input";
    public static final String INPUT_WHERE_FIELD = "//span[text()='Куда']/../input";
    public static final String INPUT_DATA_FIELD = "//span[text()='Когда']/../input";

    public HomePage(WebDriver driver) {
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

    public void searchAviaTickets(String cityFrom, String cityWhere, String data){
        final String icon = "//span[text()='Авиабилеты']/ancestor::button";
        final String searchButton = "//div[text()='Найти билеты']/ancestor::button";
        searchTicket(icon, cityFrom, cityWhere, data, searchButton);
    }

    public void searchTrainTickets(String cityFrom, String cityWhere, String data){
        final String icon = "//span[text()='Ж/д билеты']/ancestor::button";
        final String ticketSearchButton = "(//div[text()='Найти билеты']/ancestor::button)[2]";
        searchTicket(icon, cityFrom, cityWhere, data, ticketSearchButton);
    }

    public void searchBusTickets(String cityFrom, String cityWhere, String data){
        final String icon = "//span[text()='Автобусы']/ancestor::button";
        final String ticketSearchButton = "//div[text()='Найти билеты']/ancestor::button";
        searchTicket(icon, cityFrom, cityWhere, data, ticketSearchButton);
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
        openLoginWindow(wait);

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
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[.//span[text()='Войти']])[1]")));
        icon.click();
    }

}
