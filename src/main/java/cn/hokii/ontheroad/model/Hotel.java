package cn.hokii.ontheroad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Hotel {
    private int hotelId;
    private String name;
    private String province;
    private String city;
    private String address;
    private int star;
    private float score;
    private String imgUrl;
    private String connection;
    private int freeParking;
    private int freePickUp;
    private int petsAllow;
    private int luggageStorage;
    private int lowestPrice;

    public Hotel(int hotelId,String name,String province,String city,String address,int star,float score,String imgUrl,String connection,int freeParking,int freePickUp,int petsAllow,int luggageStorage) {
        this.hotelId=hotelId;
        this.name=name;
        this.province=province;
        this.city=city;
        this.address=address;
        this.star=star;
        this.score=score;
        this.imgUrl=imgUrl;
        this.connection=connection;
        this.freeParking=freeParking;
        this.freePickUp=freePickUp;
        this.petsAllow=petsAllow;
        this.luggageStorage=luggageStorage;
        this.lowestPrice=0;
    }
}
