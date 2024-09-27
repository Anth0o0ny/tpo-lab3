import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class SearchBusTicketTest {

    public static final String CITY_FROM = "Санкт-Петербург";
    private static final String CITY_WHERE = "Москва";
    public static final String DATE = "Mon Sep 30 2024";

    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingBusTickets(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.searchBusTickets(CITY_FROM,CITY_WHERE,DATE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-ti='offersList']")));
             assert tickets.size() > 0 : "Билеты не найдены";
        });
        drivers.forEach(WebDriver::quit);
    }


}
