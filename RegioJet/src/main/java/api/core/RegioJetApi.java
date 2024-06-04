package api.core;

import api.app.ApiMethods;
import api.app.RoutesResponse;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class RegioJetApi extends ApiMethods {
    public void getMinResponse(String fieldName, String from, String to, String departureDate) {
        log.info("Get min value by params");
        List<RoutesResponse> allValues = getAllValuesByTripParams(from, to, departureDate);
        RoutesResponse minValue = getMinValueFromResponse(fieldName, allValues);
        checkMinimalValueOfList(fieldName, minValue, allValues);

        assertAll("Check not null fields and log result",
                () -> {
                    assertNotNull(minValue.getDepartureTime());
                    assertNotNull(minValue.getArrivalTime());
                    assertNotNull(minValue.getTravelTime());
                    assertNotNull(minValue.getPriceFrom());

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
        );
    }
}
