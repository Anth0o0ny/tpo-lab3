import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdventurePage;
import pages.HomePage;
import pages.HotelPage;

import java.time.Duration;
import java.util.List;

public class AdventureTest {
    public static final String CITY_WHERE = "Грузия";
    public static final String COST = "32000";
    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingAdventure(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.goToAdventurePage();
            AdventurePage adventurePage = new AdventurePage(webDriver);
            adventurePage.searchTour(CITY_WHERE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AdventurePage.TICKETS_RESULT_LIST_XPATH)));

            adventurePage.doFilter(COST);
            List<WebElement> ticketsAfterFilter = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AdventurePage.TICKETS_RESULT_LIST_XPATH)));

            assert tickets.size() >= ticketsAfterFilter.size() : AdventurePage.ERROR_MESSAGE;
        });
        drivers.forEach(WebDriver::quit);
    }
}
