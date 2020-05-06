package cn.hokii.ontheroad.service;

import cn.hokii.ontheroad.model.Production;

import java.util.List;

public interface ProductionService {

    List<Production> getAll();

    List<Production> getTop5SalesProduction();
}
