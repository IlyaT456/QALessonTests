package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BasePages {

    public SelenideElement searchBar() {
        return $("input[type='search']");
    }

    public SelenideElement buttonSearch() {
        return $$("use[href='#search']").last().parent();
    }

    public SelenideElement buttonByText(String text) {
        return $x("//button[. = '" + text + "']");
    }

    public SelenideElement searchPage() {
        return $x("//main");
    }

    public SelenideElement mainMenu(String text) {
        return $$(".elgmz660").find(text(text));
    }

    public SelenideElement userPanel(String text) {
        return $$("div[role='button']").find(text(text));
    }

    public SelenideElement categorePanel(String text) {
        return $x("//div[contains(@class, 'app-catalog-oacxam') and . = '" + text + "']");
    }

    public SelenideElement addedProductInCart() {
        return $("span[class='e1ys5m360 e106ikdt0 css-175fskm e1gjr6xo0']");
    }

    public SelenideElement login() {
        return $("input[name='login']");
    }

    public SelenideElement password() {
        return $("input[type='password']");
    }

    public SelenideElement aByText(String text) {
        return  $$("a").find(text(text));
    }

    public SelenideElement buttonByTextContains(String text) {
        return $x("//button[contains(., '" + text + "')]");
    }

    public SelenideElement cooket() {
        return $x("//span[text()='Я согласен']");
    }


}
