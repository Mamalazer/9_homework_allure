package allure.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static allure.data.Constants.issueName;
import static allure.data.Constants.repository;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@Feature("Allure")
@Story("Тесты с применением listener'a selenide")
public class ClearSelenideTest extends GeneralFrontTest {

    @Owner("d.kuznetsov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка названия Issue в репозитории")
    @Test
    public void test01() {
        open("/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();

        $(linkText(repository)).click();
        $("#issues-tab").click();
        $(withText(issueName)).should(exist);
    }
}
