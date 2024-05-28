package regioJet.api;

import api.Specification;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
@Data
public class Location {

    private String URL = "https://brn-ybus-pubapi.sa.cz";
    private final String SEARCH_PATH = "/restapi/consts/locations";

    public String getLocationId(String name) {
        Specification.requestSpec(URL);
        List<Location> locationList = given()
                .when()
                .get(URL + SEARCH_PATH)
                .then().log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList(".", Location.class);
        return locationList.stream().filter(x->x.name.equals(name)).map(Location::getId).findFirst().toString();
    }
    public static String getNextMondayDate() {
        LocalDate now = LocalDate.now();
        int daysUntilMonday = DayOfWeek.MONDAY.getValue() - now.getDayOfWeek().getValue();
        if (daysUntilMonday != 0) {
            daysUntilMonday += 7;
        }
        LocalDate nextMonday = now.plusDays(daysUntilMonday);
        return nextMonday.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public Object id;
    public String name;
    public String fullname;
    public ArrayList<String> aliases;
    public String address;
    public ArrayList<String> stationsTypes;
    public String iataCode;
    public String stationUrl;
    public String stationTimeZoneCode;
    public String wheelChairPlatform;
    public Integer significance;
    public Double longitude;
    public Double latitude;
    public String imageUrl;
}
