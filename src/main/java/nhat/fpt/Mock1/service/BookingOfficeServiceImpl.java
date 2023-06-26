package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.exception.FKMapNotExistException;
import nhat.fpt.Mock1.model.dto.BookingOfficeDTO;
import nhat.fpt.Mock1.model.entity.BookingOffice;
import nhat.fpt.Mock1.model.entity.Trip;
import nhat.fpt.Mock1.model.response.BookingOfficeResponse;
import nhat.fpt.Mock1.repository.BookingOfficeRepository;
import nhat.fpt.Mock1.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingOfficeServiceImpl implements BookingOfficeService{
    private final BookingOfficeRepository bookingOfficeRepository;
    private final TripRepository tripRepository;
    private final ModelMapper modelMapper;

    public BookingOfficeServiceImpl(BookingOfficeRepository bookingOfficeRepository, TripRepository tripRepository, ModelMapper modelMapper) {
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripRepository = tripRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public boolean isEmpty(){
        return !bookingOfficeRepository.findAll().isEmpty();
    }

    @Override
    public List<BookingOfficeResponse> findAll(){
         return  bookingOfficeRepository.findAll().stream().map(bookingOffice -> modelMapper.map(bookingOffice, BookingOfficeResponse.class))
                .collect(Collectors.toList());
    }
    @Override
    public BookingOfficeResponse findById(Long id){
        return modelMapper.map(bookingOfficeRepository.findByOfficeId(id).orElseThrow(()->{
            throw new EntityNotFoundException("Booking office with id = " + id + "not exists");
        }), BookingOfficeResponse.class);
    }
    @Override
    public BookingOfficeResponse addBookingOffice(BookingOfficeDTO bookingOfficeDTO){
        Long tripId = bookingOfficeDTO.getTripId();
        Trip trip = modelMapper.map(tripRepository.findById(tripId).orElseThrow(()->{
            throw new FKMapNotExistException("Trip with id = " + tripId + "not exists");
        }),Trip.class);
        BookingOffice bookingOfficeToAdd = modelMapper.map(bookingOfficeDTO,BookingOffice.class);
        bookingOfficeToAdd.setOfficeId(null);
       // bookingOfficeToAdd.setTrip(trip);
        return modelMapper.map(bookingOfficeRepository.save(bookingOfficeToAdd),BookingOfficeResponse.class);
    }
    @Override
    public BookingOfficeResponse updateBookingOffice(Long id, BookingOfficeDTO bookingOfficeDTO){
        Long tripId = bookingOfficeDTO.getTripId();
        Trip trip = modelMapper.map(tripRepository.findById(tripId).orElseThrow(()->{
            throw new EntityNotFoundException("Trip with id = " + tripId + "not exists");
        }),Trip.class);
        BookingOffice bookingOfficeToUpdate = modelMapper.map(bookingOfficeDTO, BookingOffice.class);
        bookingOfficeToUpdate.setOfficeId(id);
       // bookingOfficeToUpdate.setTrip(trip);
        return modelMapper.map(bookingOfficeRepository.save(bookingOfficeToUpdate), BookingOfficeResponse.class);
    }
    public void deleteBookingOffice(Long id){
        if (!bookingOfficeRepository.existsByOfficeId(id))
            throw new EntityNotFoundException("Trip with id = "+id+" not existed");
        bookingOfficeRepository.deleteById(id);
    }
}
