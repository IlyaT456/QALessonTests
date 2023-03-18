package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.BasePages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class BaseSteps {

    BasePages basePages = new BasePages();
    @Step("Открываем главую страницу")
    public BaseSteps openMainPage() {
        open("https://www.citilink.ru/");
        return this;
    }

    @Step("Поиск в поисковой строке {0}")
    public BaseSteps searchBarText(String text) {
        basePages.searchBar().setValue(text);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public BaseSteps clickButtonSearch() {
        Selenide.sleep(5000);
        basePages.buttonSearch().shouldBe(enabled, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Проверка работы поискового запроса")
    public BaseSteps сheckingOperationSearchQuery(String text) {
        basePages.searchPage().shouldBe(text(text), Duration.ofSeconds(10));
        return this;
    }

    @Step("Проверка соответсвии главного меню")
    public BaseSteps checkingComplianceMainMenu() {
        List<String> elements = Arrays.asList("Журнал", "Акции", "Ситилинк.Бизнес", "Конфигуратор", "Доставка", "Магазины", "Обратная связь");
        for (String element : elements) {
            basePages.mainMenu(element).shouldBe(exist);
        }
        return this;
    }

    @Step("Проверка ошибок в консоли 'SEVERE'")
    public BaseSteps consoleShouldNotHaveErrorsTest() {
        List<String> consoleLogs = Selenide.getWebDriverLogs(BROWSER);
        String errorText = "SEVERE";
        Assertions.assertFalse(consoleLogs.contains(errorText));
        return this;
    }

    @Step("Выбираем нужную позиции в панели каталога")
    public BaseSteps selectDesiredPositionInTheCatalogPanel(String text) {
        basePages.categorePanel(text).click();
        return this;
    }

    @Step("Добавляем товар в корзину")
    public BaseSteps addingTheProductTheCart() {
        basePages.buttonByText("В корзину").click();
        return this;
    }

    @Step("Переходим в корзину")
    public BaseSteps clickOnTheBasket() {
        basePages.buttonByText("Перейти в корзину").click();
        return this;
    }

    @Step("Проверяем наличие добавленого товара в корзину")
    public BaseSteps checkAddedProductToCart(String text) {
        basePages.addedProductInCart().shouldBe(text(text));
        return this;
    }

    @Step("Наживаем на вкладку войти")
    public BaseSteps clickingTheLogInTab() {
        basePages.userPanel("Войти").click();
        return this;
    }

    @Step("Авторизация")
    public BaseSteps authorization() {
        basePages.login().click();
        basePages.login().setValue("testdsdsw2@rambler.ru");
        basePages.password().click();
        basePages.password().setValue("Q1w2e3r4t5");
        basePages.buttonByTextContains("Войти").shouldBe(enabled).click();
        return this;
    }

    @Step("Проверка профиля пользователя")
    public BaseSteps checkingTheUserProfile(String user) {
        $x("//div[@data-meta-name = 'HeaderBottom__search']//following-sibling::div//span[text()='"+user+"']")
                .shouldBe(exist, Duration.ofSeconds(15)).click();
        basePages.aByText("Мой профиль").click();
        $(".MainLayout__main").shouldHave(text(user));
        return this;
    }


















}
