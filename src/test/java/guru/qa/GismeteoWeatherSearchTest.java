package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GismeteoWeatherSearchTest extends BaseTest {

    @BeforeEach
    void setUp() {
        open("https://www.gismeteo.ru/");
    }

    @CsvSource(value = {
            "Москва, Погода в Москве сегодня",
            "Пенза,  Погода в Пензе сегодня"
    })

    @DisplayName("Проверка поиска на сайте gismeteo.ru с помощью @CsvSource")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void searchBestFilmsWithCsvSource(String cityName, String info) {
        $("[type='search']").setValue(cityName).pressEnter();
        $(".page-title").shouldHave(text(info));
    }
}
