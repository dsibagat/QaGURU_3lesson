package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubSoftAssertionsPage {

    @Description("Открыть страницу SoftAssertions в github/selenide и проверить что внутри есть пример кода для JUnit5")
    @Test
    void SoftAssertionsTest() {
        open("https://github.com/");
        $("[name=q]").val("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h1").shouldHave(text("selenide / selenide"));
        $("[data-hotkey='g w']").click();
        $("#wiki-body").shouldHave(text("Welcome to the selenide wiki!"));
        $$(".Box-row").findBy(text("SoftAssertions")).click();
        $(".page").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
