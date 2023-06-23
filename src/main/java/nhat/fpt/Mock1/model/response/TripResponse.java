package nhat.fpt.Mock1.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TripResponse {
    private Long tripId;
    private int bookedTicketNumber;
    private String carType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;
//    @JsonIgnoreProperties({"trip"})
//    private List<BookingOfficeResponse> bookingOffices;
//    @JsonIgnoreProperties("trip")
//    private List<TicketResponse> tickets;
}
