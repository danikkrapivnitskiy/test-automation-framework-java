package api.regiojet;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

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

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getStationsTypes() {
        return stationsTypes;
    }

    public void setStationsTypes(ArrayList<String> stationsTypes) {
        this.stationsTypes = stationsTypes;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getStationUrl() {
        return stationUrl;
    }

    public void setStationUrl(String stationUrl) {
        this.stationUrl = stationUrl;
    }

    public String getStationTimeZoneCode() {
        return stationTimeZoneCode;
    }

    public void setStationTimeZoneCode(String stationTimeZoneCode) {
        this.stationTimeZoneCode = stationTimeZoneCode;
    }

    public String getWheelChairPlatform() {
        return wheelChairPlatform;
    }

    public void setWheelChairPlatform(String wheelChairPlatform) {
        this.wheelChairPlatform = wheelChairPlatform;
    }

    public Integer getSignificance() {
        return significance;
    }

    public void setSignificance(Integer significance) {
        this.significance = significance;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Location() {
    }

    public Location(Object id, String name, String fullname, ArrayList<String> aliases, String address, ArrayList<String> stationsTypes, String iataCode, String stationUrl, String stationTimeZoneCode, String wheelChairPlatform, Integer significance, Double longitude, Double latitude, String imageUrl) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
        this.aliases = aliases;
        this.address = address;
        this.stationsTypes = stationsTypes;
        this.iataCode = iataCode;
        this.stationUrl = stationUrl;
        this.stationTimeZoneCode = stationTimeZoneCode;
        this.wheelChairPlatform = wheelChairPlatform;
        this.significance = significance;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageUrl = imageUrl;
    }
}
