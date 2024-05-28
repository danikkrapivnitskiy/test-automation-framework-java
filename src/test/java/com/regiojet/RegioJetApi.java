package com.regiojet;


import api.Specification;
import regioJet.api.Location;
import regioJet.api.RoutesResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RegioJetApi {

    private String URL = "https://brn-ybus-pubapi.sa.cz";
    private final Integer fromId = getLocationId("Ostrava");
    private final Integer toId = getLocationId("Brno");

    private final String nextMonday = Location.getNextMondayDate();

    private final String SEARCH_PATH = "/restapi/routes/search/simple?tariffs=REGULAR&to" +
            "LocationType=CITY&toLocationId=" + toId + "&fromLocationType=CITY&" +
            "fromLocationId=" + fromId + "&departureDate=" + nextMonday;

    private final String LOCATION_PATH = "/restapi/consts/locations";
    @Test
    public void earliestDeparture() {
        minResponse("departureTime", "Earliest departure: ");
    }

    @Test
    public void cheapiestPrice() {
        minResponse("priceFrom", "Cheapiset price: ");
    }

    @Test
    public void minTravelTime() {
        minResponse("travelTime", "Min travel time: ");
    }

    public void minResponse(String fieldName, String description) {
        Specification.requestSpec(URL);
        List<RoutesResponse> routesResponsesList = given()
                .when()
                .get(URL + SEARCH_PATH)
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("routes", RoutesResponse.class);

        Comparator<RoutesResponse> comparator;
        switch(fieldName) {
            case "departureTime":
                comparator = Comparator.comparing(RoutesResponse::getDepartureTime);
                break;
            case "priceFrom":
                comparator = Comparator.comparing(RoutesResponse::getPriceFrom);
                break;
            case "travelTime":
                comparator = Comparator.comparing(RoutesResponse::getTravelTime);
                break;
            default:
                throw new IllegalArgumentException("Unknown field name: " + fieldName);
        }

        RoutesResponse minValue = routesResponsesList.stream().min(comparator).orElse(null);
        Assert.assertNotNull(minValue);

        System.out.println(description + "The route is - " + minValue.getDepartureTime()
                + " - with arrival " + minValue.getArrivalTime()
                + " - travel time " + minValue.getTravelTime()
                + " and - price " + minValue.getPriceFrom());
    }

    public Integer getLocationId(String cityName) {
        Specification.requestSpec(URL);
        return given()
                .when()
                .get(URL + LOCATION_PATH)
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getInt("find { it.cities.find { it.name == '" + cityName
                        + "' } }.cities.find { it.name == '" + cityName + "' }.id");
    }
}
