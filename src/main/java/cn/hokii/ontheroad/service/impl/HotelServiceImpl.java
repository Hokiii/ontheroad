package cn.hokii.ontheroad.service.impl;

import cn.hokii.ontheroad.dao.HotelDao;
import cn.hokii.ontheroad.model.Hotel;
import cn.hokii.ontheroad.model.Room;
import cn.hokii.ontheroad.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<Hotel> getAll() {
        return hotelDao.getAll();
    }

    @Override
    public List<Hotel> getDefaultHotels() {
        return hotelDao.getDefaultHotels();
    }

    @Override
    public Hotel getHotelByHotelId(int hotelId) {
        System.out.println(hotelId);
        return hotelDao.getHotelByHotelId(hotelId);
    }

    @Override
    public List<Room> getRoomsByHotelId(int hotelId) {
        return hotelDao.getRoomsByHotelId(hotelId);
    }

    @Override
    public List<Hotel> getHotelByCity(String city) {
        System.out.println(city);
        return hotelDao.getHotelByCity(city);
    }

    @Override
    public Room getRoomByRoomId(int roomId) {
        return hotelDao.getRoomByRoomId(roomId);
    }
}
