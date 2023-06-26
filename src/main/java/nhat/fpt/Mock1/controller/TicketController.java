package nhat.fpt.Mock1.controller;

import nhat.fpt.Mock1.model.dto.TicketDTO;
import nhat.fpt.Mock1.model.entity.Ticket;
import nhat.fpt.Mock1.model.response.TicketResponse;
import nhat.fpt.Mock1.repository.TicketRepository;
import nhat.fpt.Mock1.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final ModelMapper modelMapper;

    public TicketController(TicketService ticketService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponse>> findAllTicket(){
        return ResponseEntity.ok(ticketService.findAll());
    }

    @PostMapping("/addTicket")
    public ResponseEntity<String> addTicket(
            @RequestBody TicketDTO newTicket
    )
    {
        ticketService.addTicket(newTicket);
        return new ResponseEntity<>("Add new employee successful", HttpStatus.CREATED);
    }

    @PutMapping("/updateTicket/{id}")
    public ResponseEntity<String> updateTicket(
            @PathVariable Long id,
            @RequestBody TicketDTO newTicket
    )
    {
        ticketService.updateTicket(id,newTicket);
        return ResponseEntity.ok("Update new employee successful");
    }
    @DeleteMapping("/deleteTicket/{id}")
    public ResponseEntity<String> deleteTicket(
            @PathVariable Long id
    )
    {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Delete new employee successful");
    }
}
