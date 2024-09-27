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
    public void searchingFilteredTour(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.goToAdventurePage();
            AdventurePage adventurePage = new AdventurePage(webDriver);
            adventurePage.searchTour(CITY_WHERE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__ssr__verify-layout\"]/div[2]/div[5]/div/div[1]/div[2]")));

            adventurePage.doFilter(COST);
            List<WebElement> ticketsAfterFilter = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__ssr__verify-layout\"]/div[2]/div[5]/div/div[1]/div[2]")));

            assert tickets.size() >= ticketsAfterFilter.size() : "что-то не так";
        });
        drivers.forEach(WebDriver::quit);
    }
}
