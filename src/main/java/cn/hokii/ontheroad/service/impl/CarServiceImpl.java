package cn.hokii.ontheroad.service.impl;

import cn.hokii.ontheroad.dao.CarDao;
import cn.hokii.ontheroad.model.Car;
import cn.hokii.ontheroad.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;


    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public List<Car> getTop5ScoreCars() {
        return carDao.getTop5ScoreCars();
    }
}
