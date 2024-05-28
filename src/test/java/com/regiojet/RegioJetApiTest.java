package com.regiojet;


import api.Specification;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import regioJet.api.RegioJetApi;
import regioJet.api.RoutesResponse;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@Slf4j(topic = "|RegioJetApiTest|")
public class RegioJetApiTest {

    private static final String BASE_URL = "https://brn-ybus-pubapi.sa.cz";
    private RegioJetApi regioJetApi;
    private final String departureTime = "departureTime";
    private final String cheapiestPrice = "priceFrom";
    private final String minTravelTime = "travelTime";

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = BASE_URL;
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpecOK200());
        regioJetApi = new RegioJetApi();
    }

    @ParameterizedTest
    @ValueSource(strings = {departureTime, cheapiestPrice, minTravelTime})
    void minTravelCharacteristics(String testName) {
        RoutesResponse minResponse = regioJetApi.getMinResponse(
                testName,
                "Ostrava",
                "Brno",
                regioJetApi.getNextSpecificDayDate(DayOfWeek.MONDAY)
        );
        assertNotNull(minResponse);
        logToConsole(testName, minResponse);
    }

    private void logToConsole(String testName, RoutesResponse minValue) {
        String result = String.format(
                "%s test: The route is - departure %s, arrival %s, travel time %s, price %s",
                testName,
                minValue.getDepartureTime(),
                minValue.getArrivalTime(),
                minValue.getTravelTime(),
                minValue.getPriceFrom()
        );
        log.info(result);
    }
}