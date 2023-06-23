package nhat.fpt.Mock1.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nhat.fpt.Mock1.model.entity.BookingOffice;
import nhat.fpt.Mock1.model.entity.Ticket;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Getter
public class TripDTO {
    private int bookedTicketNumber;
    private String carType;
    @JsonFormat(pattern ="dd/MM/yyyy")
    private Date departureDate;
    @JsonFormat(pattern = "HH:mm:ss")
    private Time departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;
}
