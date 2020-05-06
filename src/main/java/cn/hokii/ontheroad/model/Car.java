package cn.hokii.ontheroad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class Car {
    private int carId;
    private String carName;
    private String carType;
    private int seats;
    private int price;
    private String connection;
    private int isOrdered;
    private String imgUrl;
    private float score;
    private int orderedTimes;
}
