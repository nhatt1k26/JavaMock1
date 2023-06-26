package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.model.dto.TicketDTO;
import nhat.fpt.Mock1.model.entity.Ticket;
import nhat.fpt.Mock1.model.response.TicketResponse;

import java.util.List;

public interface TicketService {
    boolean isEmpty();
    List<TicketResponse> findAll();
    TicketResponse findById(Long id);
    void addTicket(TicketDTO e);
    void updateTicket(Long id,TicketDTO e);
    void deleteTicket(Long id);
}
