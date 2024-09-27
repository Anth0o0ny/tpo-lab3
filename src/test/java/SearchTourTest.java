import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.HotelPage;
import pages.TourPage;

import java.time.Duration;
import java.util.List;

public class SearchTourTest {
    public static final String DATE = "Mon Sep 30 2024";
    public static final String CITY_FROM = "Санкт-Петербург";
    private static final String CITY_WHERE = "Турция";

    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingTours(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.goToTourPage();
            TourPage tourPage = new TourPage(webDriver);
            tourPage.searchTour(CITY_FROM, CITY_WHERE, DATE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10000));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='hotelsContainer']")));
            assert tickets.size() > 0 : "Укажите корректные данные";
        });
        drivers.forEach(WebDriver::quit);
    }
}
