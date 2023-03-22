import config.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class CitilinkTests extends BaseTest {
    BaseSteps selectors = new BaseSteps();

    @Test
    @DisplayName("Проверка работы строки поиска")
    public void checkingOperationSearchBar() {
        selectors.openMainPage()
                .searchBarText("Ноутбук Apple MacBook Pro")
                .clickButtonSearch()
                .сheckingOperationSearchQuery("Ноутбук Apple MacBook Pro");
    }

    @Test
    @DisplayName("Проверка соответсвии главного меню")
    public void сheckComplianceMainMenu() {
        selectors.openMainPage()
                .checkingComplianceMainMenu();
    }

    @Test
    @DisplayName("Проверка ошибок консоли")
    public void consoleShouldNotHaveErrorsTest() {
        selectors.openMainPage()
                .consoleShouldNotHaveErrorsTest();
    }

    @Test
    @DisplayName("Проверка добавления выбраной позиции в корзину")
    public void сheckingAdditionSelectedItemCart() {
        selectors.openMainPage()
                .searchBarText("Холодильник двухкамерный Атлант")
                .clickButtonSearch()
                .selectDesiredPositionInTheCatalogPanel("Холодильник двухкамерный Атлант XM-4208-000")
                .addingTheProductTheCart()
                .clickOnTheBasket()
                .checkAddedProductToCart("Холодильник двухкамерный Атлант XM-4208-000");
    }

    @Test
    @DisplayName("Авторизация на сайте")
    public void AuthorizationTheWebsite() {
        selectors.openMainPage()
                .clickingTheLogInTab()
                .authorization()
                .checkingTheUserProfile("Петр");
    }

}
