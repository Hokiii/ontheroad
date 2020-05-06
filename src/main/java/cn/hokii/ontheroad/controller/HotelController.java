package cn.hokii.ontheroad.controller;

import cn.hokii.ontheroad.model.Hotel;
import cn.hokii.ontheroad.model.Room;
import cn.hokii.ontheroad.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin  //允许跨域
@Slf4j
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(path="/hotels",method = RequestMethod.GET)
    public String getHotels(HttpSession session,
                            ModelMap model) {
        List<Hotel> hotels = hotelService.getDefaultHotels();
        log.info(String.valueOf(hotels));
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @RequestMapping(path="/hotelsWithParameter",method = RequestMethod.GET)
    public String getHotelsWithParam(HttpSession session,
                                     Model model,
                                     @RequestParam String destination,
                                     @RequestParam String checkIn,
                                     @RequestParam String checkOut) {
        model.addAttribute("destination",destination);
        model.addAttribute("checkIn",checkIn);
        model.addAttribute("checkOut",checkOut);
        return "hotels";
    }

    @RequestMapping(path = "/hotelDetail/{hotelId}")
    public String view(HttpSession session,
                       Model model,
                       @PathVariable("hotelId") int hotelId) {
//        log.info(String.valueOf(hotelId));
//        List<Hotel> h = hotelService.getHotelByCity("北京");
//        System.out.println(h);
//        Room room = hotelService.getRoomByRoomId(1);
//        log.info(String.valueOf(room));
        Hotel hotel = hotelService.getHotelByHotelId(hotelId);
        log.info(hotel.toString());
        List<Room> rooms = hotelService.getRoomsByHotelId(hotelId);
        log.info(String.valueOf(rooms));
        model.addAttribute("hotel",hotel);
        model.addAttribute("rooms",rooms);
        return "hotel-detail";
    }
}
