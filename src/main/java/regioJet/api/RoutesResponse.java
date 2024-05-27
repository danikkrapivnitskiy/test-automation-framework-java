package regioJet.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
@Data
public class RoutesResponse {
    private String id;
    private Integer departureStationId;
    private Date departureTime;
    private Object arrivalStationId;
    private Date arrivalTime;
    private ArrayList<String> vehicleTypes;
    private Integer transfersCount;
    private Integer freeSeatsCount;
    private Double priceFrom;
    private Double priceTo;
    private Double creditPriceFrom;
    private Double creditPriceTo;
    private Integer pricesCount;
    private Object actionPrice;
    private Boolean surcharge;
    private Boolean notices;
    private Boolean support;
    private Boolean nationalTrip;
    private Boolean bookable;
    private Object delay;
    private String travelTime;
    private String vehicleStandardKey;
}
