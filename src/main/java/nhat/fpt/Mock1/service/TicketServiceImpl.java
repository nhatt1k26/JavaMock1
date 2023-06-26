package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.exception.FKMapNotExistException;
import nhat.fpt.Mock1.model.dto.TicketDTO;
import nhat.fpt.Mock1.model.entity.Ticket;
import nhat.fpt.Mock1.model.response.TicketResponse;
import nhat.fpt.Mock1.repository.CarRepository;
import nhat.fpt.Mock1.repository.TicketRepository;
import nhat.fpt.Mock1.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final CarRepository carRepository;
    private final TripRepository tripRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, CarRepository carRepository, TripRepository tripRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.carRepository = carRepository;
        this.tripRepository = tripRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public boolean isEmpty(){
        return !ticketRepository.findAll().isEmpty();
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
        String licensePlate = e.getLicensePlate();
        Long tripId = e.getTripId();
        carRepository.findByLicensePlate(licensePlate).orElseThrow(()->{
            throw new FKMapNotExistException("Not exists car with licensePlate: "+licensePlate);
        });
        tripRepository.findByTripId(tripId).orElseThrow(()->{
            throw new FKMapNotExistException("Not exists trip with tripId: "+tripId);
        });
        ticketRepository.save(modelMapper.map(e,Ticket.class));
    }

    @Override
    public void updateTicket(Long id, TicketDTO e){
        String licensePlate = e.getLicensePlate();
        Long tripId = e.getTripId();
        carRepository.findByLicensePlate(licensePlate).orElseThrow(()->{
            throw new EntityNotFoundException("Not exists car with licensePlate: "+licensePlate);
        });
        tripRepository.findByTripId(tripId).orElseThrow(()->{
            throw new EntityNotFoundException("Not exists trip with tripId: "+tripId);
        });
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
