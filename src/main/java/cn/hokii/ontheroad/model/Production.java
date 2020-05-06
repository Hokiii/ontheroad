package cn.hokii.ontheroad.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class Production {
    private int productionId;
    private String productionName;
    private String productionLocation;
    private String productionRoute;
    private int productionDays;
    private String productionImgUrl;
    private int productionPrice;
    private int productionSales;
}
