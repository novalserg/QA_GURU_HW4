

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {
    @BeforeAll
    static void setEnv() {
        Configuration.baseUrl = ("https://github.com");
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void SelenideGithubTest(){
        String junit5CodeExample = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $("#wiki-body").$("ul").$$("li").findBy(text("Soft assertions")).$("a").click();
        $(withTagAndText("h4", "Using JUnit5 extend test class")).closest(".markdown-heading").sibling(0).$("pre").shouldHave(exactText(junit5CodeExample));



    }
}
