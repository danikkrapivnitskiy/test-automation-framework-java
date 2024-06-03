package api.app;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
@Data
public class RoutesResponse {
    public String id;
    public Integer departureStationId;
    public Date departureTime;
    public Object arrivalStationId;
    public Date arrivalTime;
    public ArrayList<String> vehicleTypes;
    public Integer transfersCount;
    public Integer freeSeatsCount;
    public Double priceFrom;
    public Double priceTo;
    public Double creditPriceFrom;
    public Double creditPriceTo;
    public Integer pricesCount;
    public Object actionPrice;
    public Boolean surcharge;
    public Boolean notices;
    public Boolean support;
    public Boolean nationalTrip;
    public Boolean bookable;
    public Object delay;
    public String travelTime;
    public String vehicleStandardKey;
    public ArrayList<String> vehicleStandards;
}
