package nhat.fpt.Mock1.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import nhat.fpt.Mock1.model.entity.Car;
import nhat.fpt.Mock1.model.entity.Trip;

import java.sql.Time;
@Getter
public class TicketDTO {
    private Time bookingTime;
    private String customerName;
    private String licensePlate;
    private Long tripId;
}
