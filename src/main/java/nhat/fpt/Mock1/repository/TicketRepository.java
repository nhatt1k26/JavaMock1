package nhat.fpt.Mock1.repository;

import nhat.fpt.Mock1.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
