package allure.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static allure.data.Constants.issueName;
import static allure.data.Constants.repository;
import static allure.page.MainPage.openMainPage;

@Feature("Allure")
@Story("Тесты с применением web steps")
public class StepTest extends BaseTest {

    @Owner("d.kuznetsov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка названия Issue в репозитории")
    @Test
    public void test01() {
        openMainPage()
                .searchRepository(repository)
                .chooseRepository(repository)
                .openIssuesTab()
                .checkIssueByName(issueName);
    }

    @Owner("d.kuznetsov")
    @DisplayName("Проверка перехода к странице 'Enterprise'")
    @Test
    public void test02() {
        openMainPage()
                .hoverButtonInHeader("Solutions")
                .openHeaderLinkByName("Enterprise", "Build like the best");
    }
}
