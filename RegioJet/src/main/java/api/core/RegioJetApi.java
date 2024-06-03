package api.core;

import api.app.ApiMethods;
import api.app.RoutesResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class RegioJetApi extends ApiMethods {
    public void getMinResponse(String fieldName, String from, String to, String departureDate) {
        log.info("Get min value by params");
        List<RoutesResponse> allValues = getAllValuesByTripParams(from, to, departureDate);
        RoutesResponse minValue = getMinValueFromResponse(fieldName, allValues);
        checkMinimalValueOfList(fieldName, minValue, allValues);

        String result = String.format(
                "%s test: The route is - departure %s, arrival %s, travel time %s, price %s",
                fieldName,
                minValue.getDepartureTime(),
                minValue.getArrivalTime(),
                minValue.getTravelTime(),
                minValue.getPriceFrom()
        );
        log.info(result);
    }
    private void checkMinimalValueOfList(String fieldName, RoutesResponse minValue, List<RoutesResponse> allValues) {
        switch (fieldName) {
            case "departureTime" ->
                    assertTrue(allValues.stream().allMatch(r -> r.getDepartureTime().compareTo(minValue.getDepartureTime()) >= 0));
            case "travelTime" ->
                    assertTrue(allValues.stream().allMatch(r -> r.getTravelTime().compareTo(minValue.getTravelTime()) >= 0));
            case "priceFrom" ->
                    assertTrue(allValues.stream().allMatch(r -> r.getPriceFrom() >= minValue.getPriceFrom()));
            default -> throw new IllegalArgumentException("Unknown field name: " + fieldName);
        }
    }
}
