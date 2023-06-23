package nhat.fpt.Mock1.service;

import nhat.fpt.Mock1.exception.EntityNotFoundException;
import nhat.fpt.Mock1.model.dto.ParkingLotDTO;
import nhat.fpt.Mock1.model.entity.ParkingLot;
import nhat.fpt.Mock1.model.response.ParkingLotResponse;
import nhat.fpt.Mock1.repository.ParkingLotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;
    private final ModelMapper modelMapper;

    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository, ModelMapper modelMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ParkingLotResponse> findAll(){
        return parkingLotRepository.findAll().stream().map(s->modelMapper.map(s, ParkingLotResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ParkingLotResponse findById(Long id){
        ParkingLot result = parkingLotRepository.findById(id).orElseThrow(()->{
            throw new EntityNotFoundException("ParkingLot with id= "+ id + " not found");});
        return modelMapper.map(result,ParkingLotResponse.class);
    }

    @Override
    public void addParkingLot(ParkingLotDTO e){
        parkingLotRepository.save(modelMapper.map(e,ParkingLot.class));
    }

    @Override
    public void updateParkingLot(Long id, ParkingLotDTO e){
        if (!parkingLotRepository.existsById(id))
            throw new EntityNotFoundException("ParkingLot with id="+id+" not found.");
        ParkingLot parkingLotToUpdate = modelMapper.map(e, ParkingLot.class);
        parkingLotToUpdate.setParkID(id);
        parkingLotRepository.save(parkingLotToUpdate);
    }

    @Override
    public void deleteParkingLot(Long id){
        if (!parkingLotRepository.existsById(id))
            throw new EntityNotFoundException("ParkingLot with id="+id+" not found.");
        parkingLotRepository.deleteById(id);
    }
}
