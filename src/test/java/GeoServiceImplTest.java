import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "172.0.0.1", "172.0.2.12"})
    public void byIp_rus_test(String ip) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        String expectedCity = "Moscow";
        String actualCity = geoService.byIp(ip).getCity();
        Assertions.assertEquals(actualCity, expectedCity);
        Country actual = geoService.byIp(ip).getCountry();
        Country expected = Country.RUSSIA;
        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.0.32.11", "96.0.0.1", "96.0.2.12"})
    public void byIp_eng_test(String ip) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        String expectedCity = "New York";
        String actualCity = geoService.byIp(ip).getCity();
        Assertions.assertEquals(actualCity, expectedCity);
        Country actual = geoService.byIp(ip).getCountry();
        Country expected = Country.USA;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void byIp_rus_location_test() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("172.0.32.11");
        String expectedCity = "Moscow";
        String actualCity = actual.getCity();
        Assertions.assertEquals(actualCity, expectedCity);
        Country expectedCountry = Country.RUSSIA;
        Country actualCountry = actual.getCountry();
        Assertions.assertEquals(actualCountry, expectedCountry);
        String expectedStreet = "Lenina";
        String actualStreet = actual.getStreet();
        Assertions.assertEquals(actualStreet, expectedStreet);
        int expectedBuilding = 15;
        int actualBuilding = actual.getBuilding();
        Assertions.assertEquals(actualBuilding, expectedBuilding);
    }

    @Test
    public void byIp_eng_location_test() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("96.44.183.149");
        String expectedCity = "New York";
        String actualCity = actual.getCity();
        Assertions.assertEquals(actualCity, expectedCity);
        Country expectedCountry = Country.USA;
        Country actualCountry = actual.getCountry();
        Assertions.assertEquals(actualCountry, expectedCountry);
        String expectedStreet = " 10th Avenue";
        String actualStreet = actual.getStreet();
        Assertions.assertEquals(actualStreet, expectedStreet);
        int expectedBuilding = 32;
        int actualBuilding = actual.getBuilding();
        Assertions.assertEquals(actualBuilding, expectedBuilding);
    }

    @Test
    public void byIp_lh_test() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("127.0.0.1");
        String actualCity = actual.getCity();
        Assertions.assertNull(actualCity);
        Country actualCountry = actual.getCountry();
        Assertions.assertNull(actualCountry);
        String actualStreet = actual.getStreet();
        Assertions.assertNull(actualStreet);
        int expectedBuilding = 0;
        int actualBuilding = actual.getBuilding();
        Assertions.assertEquals(actualBuilding, expectedBuilding);
    }
}
