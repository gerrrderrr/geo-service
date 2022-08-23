import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    @Test
    public void locate_rus_test() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        String actual = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void locate_eng_test() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = "Welcome";
        String actual = localizationService.locale(Country.USA);
        Assertions.assertEquals(actual, expected);
    }
}
