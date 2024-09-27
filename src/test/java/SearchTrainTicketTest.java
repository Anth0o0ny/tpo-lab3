import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.TrainTicketSearchPage;

import java.time.Duration;
import java.util.List;

public class SearchTrainTicketTest {
    public static final String CITY_FROM = "Санкт-Петербург";
    private static final String CITY_WHERE = "Москва";
    public static final String DATE = "Mon Sep 30 2024";

    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingTrainTickets(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            TrainTicketSearchPage trainTicketSearchPage = new TrainTicketSearchPage(webDriver);
            webDriver.get(Utils.PAGE);
            trainTicketSearchPage.searchTrainTickets(CITY_FROM,CITY_WHERE, DATE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-ti='offersList']")));
            assert tickets.size() > 0 : "Билеты не найдены";
        });
        drivers.forEach(WebDriver::quit);
    }
}
