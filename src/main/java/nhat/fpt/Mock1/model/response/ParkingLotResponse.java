package nhat.fpt.Mock1.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import nhat.fpt.Mock1.model.entity.Car;

import java.util.List;
@Getter
@Setter
public class ParkingLotResponse {
    private Long parkID;
    private Long parkArea;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;
//    @JsonIgnoreProperties("parkingLot")
    private List<Car> carList;
}
