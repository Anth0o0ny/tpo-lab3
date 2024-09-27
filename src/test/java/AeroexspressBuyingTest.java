import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AeroexpressPage;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class AeroexspressBuyingTest {
    public static final String DATE = "Sat Sep 28 2024";
    public static final String MAIL = "testName@mail.ru";
    public static final String PHONE = "9999999999";
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
            homePage.goToAeroexpressPage();
            AeroexpressPage aeroexpressPage = new AeroexpressPage(webDriver);
            aeroexpressPage.fastAeroSearch(DATE, MAIL, PHONE);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AeroexpressPage.TICKETS_RESULT_LIST_XPATH)));
            assert tickets.size() > 0 : AeroexpressPage.ERROR_MESSAGE;
        });
        drivers.forEach(WebDriver::quit);
    }
}
