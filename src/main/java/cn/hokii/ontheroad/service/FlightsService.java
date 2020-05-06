package cn.hokii.ontheroad.service;

import cn.hokii.ontheroad.model.Flights;

import java.util.List;

public interface FlightsService {

    List<Flights> getAll();

    List<Flights> getTop8LowPriceFlights();
}
