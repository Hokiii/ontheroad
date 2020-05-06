package cn.hokii.ontheroad.dao;

import cn.hokii.ontheroad.model.Flights;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FlightsDao {
    @Select("select * from flights")
    List<Flights> getAll();

    @Select("select t1.* from (select * from flights order by price) t1 where departure_airport_code='PEK' group by t1.price order by price limit 1,8")
    List<Flights> getTop8LowPriceFlights();
}
