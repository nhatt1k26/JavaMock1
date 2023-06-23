package nhat.fpt.Mock1.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import nhat.fpt.Mock1.model.entity.Car;
import nhat.fpt.Mock1.model.entity.ParkingLot;

import java.util.List;
@Getter
public class ParkingLotDTO {
    private Long parkArea;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;
}
