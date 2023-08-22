package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LitresBookSearchTest extends BaseTest {

    @BeforeEach
    void setUp() {
        open("https://www.litres.ru/");
    }

    @CsvFileSource(resources = "/LitresTestParameters.csv")

    @DisplayName("Проверка поиска на сайте litres.ru с помощью @CsvFileSource")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void searchBooksWithCsvFileSource(String bookStyle, String info) {
        $("[data-test-id='header__search-input--desktop']").setValue(bookStyle).pressEnter();
        $("[data-test-id='search-title__wrapper']").shouldHave(text(info));
    }
}
