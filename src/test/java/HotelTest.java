import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElectricTrainPage;
import pages.HomePage;
import pages.HotelPage;

import java.time.Duration;
import java.util.List;

public class HotelTest {
    public static final String CITY_FROM = "Москва";
    public static final String DATE_FROM = "Fri Sep 27 2024";
    public static final String DATE_TO = "Mon Sep 30 2024";
    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingHotel(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.goToHotelPage();
            HotelPage hotelPage = new HotelPage(webDriver);
            hotelPage.searchHotel(CITY_FROM, DATE_FROM, DATE_TO);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1000));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HotelPage.TICKETS_RESULT_LIST_XPATH)));
            assert tickets.size() > 0 : HotelPage.ERROR_MESSAGE;
        });
        drivers.forEach(WebDriver::quit);
    }
}
