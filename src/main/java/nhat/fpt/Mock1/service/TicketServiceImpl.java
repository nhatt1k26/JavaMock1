package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.model.dto.TicketDTO;
import nhat.fpt.Mock1.model.entity.Ticket;
import nhat.fpt.Mock1.model.response.TicketResponse;
import nhat.fpt.Mock1.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TicketResponse> findAll(){
        return ticketRepository.findAll().stream().map(s->modelMapper.map(s, TicketResponse.class)).collect(Collectors.toList());
    }

    @Override
    public TicketResponse findById(Long id){
        Ticket result = ticketRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("Ticket with id= "+ id + " not found");});
        return modelMapper.map(result,TicketResponse.class);
    }

    @Override
    public void addTicket(TicketDTO e){
        ticketRepository.save(modelMapper.map(e,Ticket.class));
    }

    @Override
    public void updateTicket(Long id, TicketDTO e){
        if (!ticketRepository.existsById(id))
            throw new EntityNotFoundException("Ticket with id="+id+" not found.");
        Ticket ticketToUpdate = modelMapper.map(e, Ticket.class);
        ticketToUpdate.setTicketId(id);
        ticketRepository.save(ticketToUpdate);
    }

    @Override
    public void deleteTicket(Long id){
        if (!ticketRepository.existsById(id))
            throw new EntityNotFoundException("Ticket with id="+id+" not found.");
        ticketRepository.deleteById(id);
    }
}
