package cn.hokii.ontheroad.dao;

import cn.hokii.ontheroad.model.Hotel;
import cn.hokii.ontheroad.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HotelDao {

    @Select("select * from hotels")
    List<Hotel> getAll();

    @Select("select * from hotels order by price")
    List<Hotel> getAllByPriceAsc();

    @Select("select hotels.*,rooms.price from hotels,rooms where hotels.hotel_id=rooms.hotel_id and rooms.remainder!=0 group by hotels.hotel_id order by rooms.price")
    List<Hotel> getDefaultHotels();

    @Select("select * from hotels Where hotel_id=#{hotelId}")
    Hotel getHotelByHotelId(int hotelId);

    @Select("select * from rooms where hotel_id=#{hotelId}")
    List<Room> getRoomsByHotelId(int hotelId);

    @Select("select * from hotels where city=#{city}")
    List<Hotel> getHotelByCity(String city);

    @Select("select * from rooms where room_id=#{roomId}")
    Room getRoomByRoomId(int roomId);
}
