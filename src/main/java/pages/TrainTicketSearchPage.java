package pages;

import org.openqa.selenium.WebDriver;

public class TrainTicketSearchPage extends TicketSearchPage {

    public static final String TICKETS_RESULT_LIST_XPATH = "//*[@id=\"payment_form\"]";
    public static final String ERROR_MESSAGE = "Ошибка страницы оплаты";

    public TrainTicketSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchTrainTickets(String cityFrom, String cityWhere, String data) {
        final String iconPath = "//span[text()='Ж/д билеты']/ancestor::button";
        final String searchButtonPath = "(//div[text()='Найти билеты']/ancestor::button)[2]";
        searchTicket(iconPath, cityFrom, cityWhere, data, searchButtonPath);
    }
}
