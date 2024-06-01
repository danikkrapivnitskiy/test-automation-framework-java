package projects.regioJet.api;

import apiSpecification.Specification;
import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
@Slf4j(topic = "|RegioJetApi|")
public class RegioJetApi {

    private static final String LOCATION_PATH = "/restapi/consts/locations";
    private static final String SEARCH_PATH = "/restapi/routes/search/simple";

    private Integer getLocationIdByCityName(String cityName) {
        log.info("Get location id for: " + cityName);
        return Specification
                .sendGetRequest(LOCATION_PATH, new HashMap<>())
                .then()
                .extract().body().jsonPath().getInt("find { it.cities.find { it.name == '" + cityName
                        + "' } }.cities.find { it.name == '" + cityName + "' }.id");
    }
    public String getNextSpecificDayDate(DayOfWeek dayOfWeek) {
        LocalDate now = LocalDate.now();
        String nextDayOfWeekDate;
        if (now.getDayOfWeek() == dayOfWeek) {
            nextDayOfWeekDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else nextDayOfWeekDate = now.with(TemporalAdjusters.next(dayOfWeek))
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
        log.info(String.format("Next %s: %s", dayOfWeek, nextDayOfWeekDate));
        return nextDayOfWeekDate;
    }
    private Comparator<RoutesResponse> getComparator(String fieldName) {
        log.info("Compare: " + fieldName + " to POJO class field");
        return switch (fieldName) {
            case "departureTime" -> Comparator.comparing(RoutesResponse::getDepartureTime);
            case "priceFrom" -> Comparator.comparing(RoutesResponse::getPriceFrom);
            case "travelTime" -> Comparator.comparing(RoutesResponse::getTravelTime);
            default -> throw new IllegalArgumentException("Unknown field name: " + fieldName);
        };
    }

    public RoutesResponse getMinResponse(String fieldName, String from, String to, String departureDate) {
        log.info("Get min value by params");
        return Specification
                .sendGetRequest(SEARCH_PATH, buildSearchQueryParamsByDepartureAndArrivalDestinationAndDate(from, to, departureDate))
                .then().extract().body().jsonPath().getList("routes", RoutesResponse.class)
                .stream().min(getComparator(fieldName)).orElse(null);
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
}
