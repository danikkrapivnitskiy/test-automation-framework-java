package api;

import api.businessLogic.RegioJetApi;
import configuration.ConfigProperties;
import listeners.ListenerAllureJunit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;
@Slf4j(topic = "|RegioJetApiTest|")
@ExtendWith(ListenerAllureJunit.class)
public class RegioJetApiTest {

    private RegioJetApi regioJetApi;

    @BeforeEach
    void setUp() {
        Specification.installSpecification(Specification.requestSpec(ConfigProperties.getRegioJetApiUrl()),
                Specification.responseSpecOK200());
        regioJetApi = new RegioJetApi();
    }

    @ParameterizedTest
    @ValueSource(strings = {"departureTime", "priceFrom", "travelTime"})
    void minTravelCharacteristics(String testName) {
        regioJetApi.getMinResponse(
                testName,
                "Ostrava",
                "Brno",
                regioJetApi.getNextSpecificDayByDate(DayOfWeek.MONDAY)
        );
    }
}