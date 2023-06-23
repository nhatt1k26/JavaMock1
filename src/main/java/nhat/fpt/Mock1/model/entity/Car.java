package nhat.fpt.Mock1.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Car {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length=10)
    private String licensePlate;
    @Column(length=10)
    private String carColor;
    @Column(length=50)
    private String company;
    @OneToMany(mappedBy = "car")
    private List<Ticket> ticketList;
    @ManyToOne
    private ParkingLot parkingLot;
}
