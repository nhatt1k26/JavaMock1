package nhat.fpt.Mock1.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;
    @Column(length=11)
    private Integer bookedTicketNumber;
    @Column(length = 11)
    private String carType;
    private Date departureDate;
    private Time departureTime;
    @Column(length=50)
    private String destination;
    @Column(length=11)
    private String driver;
    private Integer maximumOnlineTicketNumber;
    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
    private List<BookingOffice> bookingOfficeList;
    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;
}
