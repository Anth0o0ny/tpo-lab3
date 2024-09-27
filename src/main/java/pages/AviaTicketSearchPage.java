package pages;

import org.openqa.selenium.WebDriver;

public class AviaTicketSearchPage extends TicketSearchPage{

    public static final String TICKETS_RESULT_LIST_XPATH = "//div[@data-ti='offersList']";
    public static final String ERROR_MESSAGE = "Билеты не найдены";

    public AviaTicketSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchAviaTickets(String cityFrom, String cityWhere, String data) {
        final String iconPath = "//span[text()='Авиабилеты']/ancestor::button";
        final String searchButtonPath = "//div[text()='Найти билеты']/ancestor::button";
        searchTicket(iconPath, cityFrom, cityWhere, data, searchButtonPath);
    }

}
