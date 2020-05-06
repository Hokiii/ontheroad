package cn.hokii.ontheroad.dao;

import cn.hokii.ontheroad.model.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CarDao {
    @Select("select * from cars")
    List<Car> getAll();

    @Select("select * from cars where is_ordered=0 order by score desc limit 1,5")
    List<Car> getTop5ScoreCars();
}
