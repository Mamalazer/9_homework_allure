package allure.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {

    private final String codeTab = "#code-tab";
    private final String issuesTab = "#issues-tab";

    public RepositoryPage() {
        $(codeTab).shouldBe(visible);
    }

    @Step("Открыть вкладку Issues")
    public IssuePage openIssuesTab() {
        $(issuesTab).click();
        return new IssuePage();
    }
}
