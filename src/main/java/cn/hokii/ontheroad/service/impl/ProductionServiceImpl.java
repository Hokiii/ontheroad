package cn.hokii.ontheroad.service.impl;

import cn.hokii.ontheroad.dao.ProductionDao;
import cn.hokii.ontheroad.model.Production;
import cn.hokii.ontheroad.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private ProductionDao productionDao;

    @Override
    public List<Production> getAll() {
        return productionDao.getAll();
    }

    @Override
    public List<Production> getTop5SalesProduction() {
        return productionDao.getTop5SalesProduction();
    }
}
