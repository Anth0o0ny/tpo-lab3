import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElectricTrainPage;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class ElectricTrainTest {
    public static final String DATE_DAY = "21";
    public static final String CITY_FROM = "Санкт-Петербург (все вокзалы)";
    private static final String CITY_WHERE = "Колпино (Московское напр.)";
    @BeforeAll
    public static void initDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    public void searchingElectricSchedule(){
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            HomePage homePage = new HomePage(webDriver);
            webDriver.get(Utils.PAGE);
            homePage.goToElectricTicketsPage();
            ElectricTrainPage electricTrainPage = new ElectricTrainPage(webDriver);
            electricTrainPage.searchElectricSchedule(CITY_FROM, CITY_WHERE,DATE_DAY);

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            List<WebElement> tickets = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//th[text()='Режим движения']/ancestor::table/tbody")));
            assert tickets.size() > 0 : "Укажите корректные данные";
        });
        drivers.forEach(WebDriver::quit);
    }

}
