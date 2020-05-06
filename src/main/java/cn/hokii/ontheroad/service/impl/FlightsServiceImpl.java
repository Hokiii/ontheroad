package cn.hokii.ontheroad.service.impl;

import cn.hokii.ontheroad.dao.FlightsDao;
import cn.hokii.ontheroad.model.Flights;
import cn.hokii.ontheroad.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsServiceImpl implements FlightsService {
    @Autowired
    private FlightsDao flightsDao;

    @Override
    public List<Flights> getAll() {
        return flightsDao.getAll();
    }

    @Override
    public List<Flights> getTop8LowPriceFlights() {
        return flightsDao.getTop8LowPriceFlights();
    }
}
