package cn.hokii.ontheroad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.jdbc.Null;

@Data
public class Room {
    private int roomId;
    private int hotelId;
    private String type;
    private int price;
    private int num;
    private int wifi;
    private int breakfast;
    private int window;
    private int retreat;
    private int remainder;

//    public Room() {
//        this.roomId=0;
//        this.hotelId=0;
//        this.type=null;
//        this.price=0;
//        this.num=0;
//        this.wifi=0;
//        this.breakfast=0;
//        this.window=0;
//        this.retreat=0;
//        this.remainder=0;
//    }

    public Room(int roomId,int hotelId,String type,int price,int num,int wifi,int breakfast,int window,int retreat,int remainder){
        this.roomId=roomId;
        this.hotelId=hotelId;
        this.type=type;
        this.price=price;
        this.num=num;
        this.wifi=wifi;
        this.breakfast=breakfast;
        this.window=window;
        this.retreat=retreat;
        this.remainder=remainder;
    }
}
