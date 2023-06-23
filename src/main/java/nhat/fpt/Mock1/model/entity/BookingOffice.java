package nhat.fpt.Mock1.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;
    private LocalDate endContractDeadline;
    @Column(length=50)
    private String officeName;
    @Column(length=11)
    private String officePhone;
    @Column(length=50)
    private String officePlace;
    @Column(length=20)
    private Long officePrice;
    private LocalDate startContractDeadline;
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;
}
