package allure.test;

import allure.data.Constants;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static allure.data.Constants.url;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class GeneralFrontTest {
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.baseUrl = url;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}

