package nhat.fpt.Mock1.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkID;
    private Long parkArea;
    @Column(length=50)
    private String parkName;
    @Column(length=11)
    private String parkPlace;
    private Long parkPrice;
    @Column(length=50)
    private String parkStatus;
    @OneToMany(mappedBy = "parkingLot",fetch =FetchType.LAZY)
    private List<Car> carList;
}
