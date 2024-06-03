package api.app;

import api.Specification;
import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j(topic = "|ApiMethods|")
public class ApiMethods extends Specification {
    private static final String LOCATION_PATH = "/restapi/consts/locations";
    private static final String SEARCH_PATH = "/restapi/routes/search/simple";
    public int getLocationIdByCityName(String cityName) {
        log.info("Get location id for: " + cityName);
        return sendGetRequest(LOCATION_PATH, new HashMap<>())
                .then()
                .extract().body().jsonPath().getInt("find { it.cities.find { it.name == '" + cityName
                        + "' } }.cities.find { it.name == '" + cityName + "' }.id");
    }
    public Comparator<RoutesResponse> getComparator(String fieldName) {
        log.info("Compare: " + fieldName + " to POJO class field");
        return switch (fieldName) {
            case "departureTime" -> Comparator.comparing(RoutesResponse::getDepartureTime);
            case "priceFrom" -> Comparator.comparing(RoutesResponse::getPriceFrom);
            case "travelTime" -> Comparator.comparing(RoutesResponse::getTravelTime);
            default -> throw new IllegalArgumentException("Unknown field name: " + fieldName);
        };
    }
    public String getNextSpecificDayByDate(DayOfWeek dayOfWeek) {
        LocalDate now = LocalDate.now();
        String nextDayOfWeekDate;
        if (now.getDayOfWeek() == dayOfWeek) {
            nextDayOfWeekDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            nextDayOfWeekDate = now.with(TemporalAdjusters.next(dayOfWeek))
                    .format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        log.info(String.format("Next %s: %s", dayOfWeek, nextDayOfWeekDate));
        return nextDayOfWeekDate;
    }
    public Map<String, Object> buildSearchQueryParamsByDepartureAndArrivalDestinationAndDate(String from, String to, String departureDate) {
        log.info(String.format("Create params from: %s, to: %s, departure time: %s", from, to, departureDate));
        Map<String, Object> params = new HashMap<>();
        params.put("tariffs", "REGULAR");
        params.put("toLocationType", "CITY");
        params.put("toLocationId", getLocationIdByCityName(to));
        params.put("fromLocationType", "CITY");
        params.put("fromLocationId", getLocationIdByCityName(from));
        params.put("departureDate", departureDate);
        return params;
    }
    protected List<RoutesResponse> getAllValuesByTripParams(String from, String to, String departureDate) {
        log.info("Get all values by trip params");
        return Specification
                .sendGetRequest(SEARCH_PATH, buildSearchQueryParamsByDepartureAndArrivalDestinationAndDate(from, to, departureDate))
                .then().extract().body().jsonPath().getList("routes", RoutesResponse.class);
    }
    protected RoutesResponse getMinValueFromResponse(String fieldName, List<RoutesResponse> allValues) {
        log.info("Get min value from the list");
        return allValues.stream().min(getComparator(fieldName)).orElse(null);
    }
}
