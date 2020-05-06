package cn.hokii.ontheroad.service;

import cn.hokii.ontheroad.model.Hotel;
import cn.hokii.ontheroad.model.Room;

import java.util.List;

public interface HotelService {

    List<Hotel> getAll();

    List<Hotel> getDefaultHotels();

    Hotel getHotelByHotelId(int hotelId);

    List<Room> getRoomsByHotelId(int hotelId);

    List<Hotel> getHotelByCity(String city);

    Room getRoomByRoomId(int roomId);
}
