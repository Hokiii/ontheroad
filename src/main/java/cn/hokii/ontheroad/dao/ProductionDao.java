package cn.hokii.ontheroad.dao;

import cn.hokii.ontheroad.model.Production;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductionDao {

    @Select("select * from users")
    List<Production> getAll();

    @Select("select * from production order by production_price asc,production_sales desc limit 1, 5")
    List<Production> getTop5SalesProduction();
}
