package cn.hokii.ontheroad.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class Flights {
    private int flightsId;
    private String departureProvince;
    private String departureCity;
    private String departureAirport;
    private String departureAirportCode;
    private String arrivalProvince;
    private String arrivalCity;
    private String arrivalAirport;
    private String arrivalAirportCode;
    private String departureTime;
    private String arrivalTime;
    private String flightsNumber;
    private String flightsType;
    private String schedule;
    private int price;
    private String duration;
}
