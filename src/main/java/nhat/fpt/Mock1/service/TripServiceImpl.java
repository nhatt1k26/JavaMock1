package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.model.dto.TripDTO;
import nhat.fpt.Mock1.model.entity.Trip;
import nhat.fpt.Mock1.model.response.TripResponse;
import nhat.fpt.Mock1.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService{
    private final TripRepository tripRepository;
    private final ModelMapper modelMapper;

    public TripServiceImpl(TripRepository tripRepository, ModelMapper modelMapper) {
        this.tripRepository = tripRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public boolean isEmpty(){
        return !tripRepository.findAll().isEmpty();
    }
    @Override
    public List<TripResponse> findAll(){
        List<TripResponse> tripList = tripRepository.findAll().stream().map(s->modelMapper.map(s,TripResponse.class)).collect(Collectors.toList());
        return tripList;
    }


    @Override
    public TripResponse findById(Long id){
        return modelMapper.map(tripRepository.findById(id).orElseThrow(()->{
                throw new EntityNotFoundException("Trip with id: "+ id +"not found");
            }), TripResponse.class);
    }

    @Override
    public TripResponse addTrip(TripDTO e){
        Trip tripToAdd = tripRepository.save(modelMapper.map(e,Trip.class));
        tripToAdd.setTripId(null);
        return modelMapper.map(tripToAdd, TripResponse.class);
    }
    @Override
    public TripResponse updateTrip(Long tripId,TripDTO e){
        if (!tripRepository.existsByTripId(tripId))
            throw new EntityNotFoundException("Trip with id = "+ tripId + " not found");
        Trip tripToAdd = tripRepository.save(modelMapper.map(e,Trip.class));
        tripToAdd.setTripId(tripId);
        return modelMapper.map(tripToAdd, TripResponse.class);
    }
    @Override
    public void deleteTrip(Long tripId){
        if (!tripRepository.existsByTripId(tripId))
            throw new EntityNotFoundException("Trip with id = "+ tripId + " not found");
        tripRepository.deleteById(tripId);
    }
}
