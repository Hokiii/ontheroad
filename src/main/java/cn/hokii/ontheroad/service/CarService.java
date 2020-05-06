package cn.hokii.ontheroad.service;

import cn.hokii.ontheroad.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAll();

    List<Car> getTop5ScoreCars();
}
