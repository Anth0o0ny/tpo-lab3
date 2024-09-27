import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AviaTicketSearchPage;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class SearchAviaTicketTest {

    public static final String CITY_FROM = "Санкт-Петербург";
    private static final String CITY_WHERE = "Москва";
    public static final String DATE = "Mon Sep 30 2024";

    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingAviaTickets(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            AviaTicketSearchPage aviaTicketSearchPage = new AviaTicketSearchPage(webDriver);
            webDriver.get(Utils.PAGE);
            aviaTicketSearchPage.searchAviaTickets(CITY_FROM,CITY_WHERE, DATE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AviaTicketSearchPage.TICKETS_RESULT_LIST_XPATH)));
            assert tickets.size() > 0 : AviaTicketSearchPage.ERROR_MESSAGE;
        });
        drivers.forEach(WebDriver::quit);
    }
}
