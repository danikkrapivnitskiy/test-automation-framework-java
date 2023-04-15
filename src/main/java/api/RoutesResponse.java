package api;

import java.util.ArrayList;
import java.util.Date;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Integer departureStationId) {
        this.departureStationId = departureStationId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Object getArrivalStationId() {
        return arrivalStationId;
    }

    public void setArrivalStationId(Object arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ArrayList<String> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(ArrayList<String> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public Integer getTransfersCount() {
        return transfersCount;
    }

    public void setTransfersCount(Integer transfersCount) {
        this.transfersCount = transfersCount;
    }

    public Integer getFreeSeatsCount() {
        return freeSeatsCount;
    }

    public void setFreeSeatsCount(Integer freeSeatsCount) {
        this.freeSeatsCount = freeSeatsCount;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public Double getCreditPriceFrom() {
        return creditPriceFrom;
    }

    public void setCreditPriceFrom(Double creditPriceFrom) {
        this.creditPriceFrom = creditPriceFrom;
    }

    public Double getCreditPriceTo() {
        return creditPriceTo;
    }

    public void setCreditPriceTo(Double creditPriceTo) {
        this.creditPriceTo = creditPriceTo;
    }

    public Integer getPricesCount() {
        return pricesCount;
    }

    public void setPricesCount(Integer pricesCount) {
        this.pricesCount = pricesCount;
    }

    public Object getActionPrice() {
        return actionPrice;
    }

    public void setActionPrice(Object actionPrice) {
        this.actionPrice = actionPrice;
    }

    public Boolean getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Boolean surcharge) {
        this.surcharge = surcharge;
    }

    public Boolean getNotices() {
        return notices;
    }

    public void setSupport(Boolean support) {
        this.support = support;
    }

    public Boolean getNationalTrip() {
        return nationalTrip;
    }

    public void setNationalTrip(Boolean nationalTrip) {
        this.nationalTrip = nationalTrip;
    }

    public Boolean getBookable() {
        return bookable;
    }

    public void setBookable(Boolean bookable) {
        this.bookable = bookable;
    }

    public Object getDelay() {
        return delay;
    }

    public void setDelay(Object delay) {
        this.delay = delay;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getVehicleStandardKey() {
        return vehicleStandardKey;
    }

    public void setVehicleStandardKey(String vehicleStandardKey) {
        this.vehicleStandardKey = vehicleStandardKey;
    }

    public RoutesResponse() {}
    public RoutesResponse(String id, Integer departureStationId, Date departureTime, Object arrivalStationId, Date arrivalTime, ArrayList<String> vehicleTypes, Integer transfersCount, Integer freeSeatsCount, Double priceFrom, Double priceTo, Double creditPriceFrom, Double creditPriceTo, Integer pricesCount, Object actionPrice, Boolean surcharge, Boolean notices, Boolean support, Boolean nationalTrip, Boolean bookable, Object delay, String travelTime, String vehicleStandardKey) {
        this.id = id;
        this.departureStationId = departureStationId;
        this.departureTime = departureTime;
        this.arrivalStationId = arrivalStationId;
        this.arrivalTime = arrivalTime;
        this.vehicleTypes = vehicleTypes;
        this.transfersCount = transfersCount;
        this.freeSeatsCount = freeSeatsCount;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.creditPriceFrom = creditPriceFrom;
        this.creditPriceTo = creditPriceTo;
        this.pricesCount = pricesCount;
        this.actionPrice = actionPrice;
        this.surcharge = surcharge;
        this.notices = notices;
        this.support = support;
        this.nationalTrip = nationalTrip;
        this.bookable = bookable;
        this.delay = delay;
        this.travelTime = travelTime;
        this.vehicleStandardKey = vehicleStandardKey;
    }

    private Boolean bookable;
    private Object delay;
    private String travelTime;
    private String vehicleStandardKey;
}
