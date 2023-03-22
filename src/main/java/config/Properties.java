package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Properties {
    public void settingsSelenoid() {
        //настройки selenoid clean test -Dselenide.remote=https://user1:1234@selenoid.autotests.cloud/wd/hub
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.driverManagerEnabled = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    public void settingsBrowser() {
        // настройки браузера
          Configuration.browser = System.getProperty("browser", "chrome");
          Configuration.browserVersion = System.getProperty("browserVersion", "100");
          Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
    }

    public void settingAllure() {
        // настройки для работы Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

//    public void beforeEach() {
//        Configuration.baseUrl = "https://www.citilink.ru/";
//    }
}
