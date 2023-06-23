package nhat.fpt.Mock1.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import nhat.fpt.Mock1.model.entity.Car;
import nhat.fpt.Mock1.model.entity.Trip;

import java.sql.Time;

public class TicketResponse {
    private Long ticketId;
    private Time bookingTime;
    @Column(length=11)
    private String customerName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;
}
